package com.android.photofeed.data.source.cloud;

import com.android.photofeed.data.RestApi;
import com.android.photofeed.data.model.Photo;
import com.android.photofeed.data.source.PhotoDataSource;

import java.util.List;

import io.reactivex.Observable;

public class CloudPhotoDataSource implements PhotoDataSource {

    private final RestApi restApi;

    public CloudPhotoDataSource(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public Observable<List<Photo>> getPhotoList(String fullUrl) {
        return restApi.getPhotoList(fullUrl);
    }

    @Override
    public Observable<Boolean> writePhotoList(List<Photo> photoList) {
        return null;
    }

    @Override
    public Observable<List<Photo>> readPhotoList() {
        return null;
    }

}
