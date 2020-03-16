package com.android.photofeed.data.source;

import com.android.photofeed.data.model.Photo;

import java.util.List;

import io.reactivex.Observable;

public interface PhotoDataSource {

    Observable<List<Photo>> getPhotoList(String fullUrl);

    Observable<Boolean> writePhotoList(List<Photo> photoList);

    Observable<List<Photo>> readPhotoList();

}
