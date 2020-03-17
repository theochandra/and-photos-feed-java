package com.android.photofeed.domain.repository;

import com.android.photofeed.data.model.Photo;

import java.util.List;

import io.reactivex.Observable;

public interface PhotoRepository {

    Observable<List<Photo>> getPhotoList();

}
