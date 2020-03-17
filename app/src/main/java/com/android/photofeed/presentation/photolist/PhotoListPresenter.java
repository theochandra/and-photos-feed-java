package com.android.photofeed.presentation.photolist;

import com.android.photofeed.data.model.Photo;
import com.android.photofeed.domain.usecase.GetPhotoListUseCase;
import com.android.photofeed.presentation.mapper.PhotoMapper;

import java.util.List;

import io.reactivex.observers.DisposableObserver;

public class PhotoListPresenter implements PhotoListContract.Presenter {

    private GetPhotoListUseCase mUseCase;

    private PhotoListContract.View mView;

    public PhotoListPresenter (
        GetPhotoListUseCase useCase,
        PhotoListContract.View view
    ) {
        mUseCase    = useCase;
        mView       = view;
    }

    @Override
    public void getPhotoList() {
        mView.showLoadingBar();
        mUseCase.execute(new DisposableObserver<List<Photo>>() {
            @Override
            public void onNext(List<Photo> photoList) {
                mView.hideLoadingBar();
                if (photoList != null && !photoList.isEmpty()) {
                    mView.populatePhotoList(PhotoMapper.transform(photoList));
                }
            }

            @Override
            public void onError(Throwable e) {
                mView.hideLoadingBar();
            }

            @Override
            public void onComplete() {
                // default implementation ignored
            }
        });
    }

    @Override
    public void destroy() {
        mUseCase.unsubscribe();
    }

}
