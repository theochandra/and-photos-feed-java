package com.android.photofeed.domain.usecase;

import com.android.photofeed.domain.repository.PhotoDataRepository;

import io.reactivex.Observable;

public class GetPhotoListUseCase extends UseCase {

    private PhotoDataRepository mRepository;

    public GetPhotoListUseCase(PhotoDataRepository repository) {
        mRepository = repository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return mRepository.getPhotoList();
    }

}
