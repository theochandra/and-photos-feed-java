package com.android.photofeed.data;

import com.android.photofeed.data.model.Photo;

import java.util.List;

import io.reactivex.Observable;

public interface LocalApi {

    Observable<Boolean> writePhotoList(List<Photo> photoList);

    Observable<List<Photo>> readPhotoList();

}
