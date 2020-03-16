package com.android.photofeed.data.resolver;

import com.android.photofeed.data.LocalApi;
import com.android.photofeed.data.model.Photo;

import java.util.List;

import io.reactivex.Observable;

public class ContentResolverDataSource implements LocalApi {

    @Override
    public Observable<Boolean> writePhotoList(List<Photo> photoList) {
        return null;
    }

    @Override
    public Observable<List<Photo>> readPhotoList() {
        return null;
    }

}
