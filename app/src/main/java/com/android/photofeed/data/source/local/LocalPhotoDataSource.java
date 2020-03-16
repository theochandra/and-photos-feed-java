package com.android.photofeed.data.source.local;

import com.android.photofeed.data.LocalApi;
import com.android.photofeed.data.model.Photo;
import com.android.photofeed.data.source.PhotoDataSource;

import java.util.List;

import io.reactivex.Observable;

public class LocalPhotoDataSource implements PhotoDataSource {

    private final LocalApi localApi;

    public LocalPhotoDataSource(LocalApi localApi) {
        this.localApi = localApi;
    }

    @Override
    public Observable<List<Photo>> getPhotoList(String fullUrl) {
        return null;
    }

    @Override
    public Observable<Boolean> writePhotoList(List<Photo> photoList) {
        return localApi.writePhotoList(photoList);
    }

    @Override
    public Observable<List<Photo>> readPhotoList() {
        return localApi.readPhotoList();
    }

}
