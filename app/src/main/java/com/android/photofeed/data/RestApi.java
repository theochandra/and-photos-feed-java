package com.android.photofeed.data;

import com.android.photofeed.BuildConfig;
import com.android.photofeed.data.model.Photo;

import java.util.List;

import io.reactivex.Observable;

public interface RestApi {

    String PHOTO_URL = BuildConfig.PHOTO_BASE_URL;

    int CONNECTION_TIMEOUT = 60;

    int READ_TIMEOUT = 60;

    Observable<List<Photo>> getPhotoList(String fullUrl);

}
