package com.android.photofeed.data.network;

import com.android.photofeed.BuildConfig;

public class EndPointAddress {

    public static final String PHOTOS = "photos";

    private EndPointAddress() { }

    public static String getPhotosEndPoint(String endPointPath) {
        return BuildConfig.PHOTO_BASE_URL + endPointPath;
    }

}
