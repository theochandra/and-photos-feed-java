package com.android.photofeed.domain.usecase;

import com.android.photofeed.domain.repository.PhotoRepository;

import io.reactivex.Observable;

public class GetPhotoListUseCase extends UseCase {

    private PhotoRepository mRepository;

    public GetPhotoListUseCase(PhotoRepository repository) {
        mRepository = repository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return mRepository.getPhotoList();
    }

}
