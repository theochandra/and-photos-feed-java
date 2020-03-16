package com.android.photofeed.data.source.factory;

import com.android.photofeed.data.LocalApi;
import com.android.photofeed.data.RestApi;
import com.android.photofeed.data.network.retrofit.RetrofitRestApiImpl;
import com.android.photofeed.data.realm.RealmDataSource;
import com.android.photofeed.data.source.PhotoDataSource;
import com.android.photofeed.data.source.cloud.CloudPhotoDataSource;
import com.android.photofeed.data.source.local.LocalPhotoDataSource;

public class PhotoDataSourceFactory {

    public PhotoDataSource createCloudDataSource() {
        RestApi restApi = new RetrofitRestApiImpl();
        return new CloudPhotoDataSource(restApi);
    }

    public PhotoDataSource createLocalDataSource() {
        LocalApi localApi = new RealmDataSource();
        return new LocalPhotoDataSource(localApi);
    }

}
