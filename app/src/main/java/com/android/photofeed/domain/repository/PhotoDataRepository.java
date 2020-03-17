package com.android.photofeed.domain.repository;

import com.android.photofeed.data.model.Photo;
import com.android.photofeed.data.source.PhotoDataSource;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PhotoDataRepository implements PhotoRepository {

    PhotoDataSource cloudPhotoDataSource;

    PhotoDataSource localPhotoDataSource;

    public PhotoDataRepository(PhotoDataSource cloudPhotoDataSource,
                               PhotoDataSource localPhotoDataSource) {
        this.cloudPhotoDataSource = cloudPhotoDataSource;
        this.localPhotoDataSource = localPhotoDataSource;
    }

    @Override
    public Observable<List<Photo>> getPhotoList() {
        return cloudPhotoDataSource.getPhotoList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map(photoList -> localPhotoDataSource.writePhotoList(photoList))
            .observeOn(AndroidSchedulers.mainThread())
            .concatMap(isSuccess -> localPhotoDataSource.getPhotoList());
    }

}
