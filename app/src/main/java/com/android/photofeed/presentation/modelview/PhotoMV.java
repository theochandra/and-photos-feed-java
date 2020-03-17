package com.android.photofeed.presentation.modelview;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;

public class PhotoMV implements Parcelable {

    public static final Creator<PhotoMV> CREATOR = new Creator<PhotoMV>() {
        @Override
        public PhotoMV createFromParcel(Parcel parcel) {
            return new PhotoMV(parcel);
        }

        @Override
        public PhotoMV[] newArray(int i) {
            return new PhotoMV[i];
        }
    };

    private String title;

    private String thumbnailUrl;

    public PhotoMV() { }

    protected PhotoMV(Parcel source) {
        title           = source.readString();
        thumbnailUrl    = source.readString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(thumbnailUrl);
    }

}
