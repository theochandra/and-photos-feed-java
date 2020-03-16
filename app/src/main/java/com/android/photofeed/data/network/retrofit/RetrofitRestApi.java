package com.android.photofeed.data.network.retrofit;

import com.android.photofeed.data.model.Photo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;

public interface RetrofitRestApi {

    String REQUEST_HEADER_CONTENT_TYPE = "Content-Type: application/json";

    @Headers({REQUEST_HEADER_CONTENT_TYPE})
    @GET
    Observable<List<Photo>> getPhotoList(@Url String fullUrl);

}
