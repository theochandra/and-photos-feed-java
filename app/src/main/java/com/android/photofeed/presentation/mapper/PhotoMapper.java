package com.android.photofeed.presentation.mapper;

import com.android.photofeed.data.model.Photo;
import com.android.photofeed.presentation.modelview.PhotoMV;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhotoMapper {

    public static List<PhotoMV> transform(List<Photo> photoList) {
        List<PhotoMV> photoMVList;
        if (photoList != null&& !photoList.isEmpty()) {
            photoMVList = new ArrayList<>();
            for (Photo photo : photoList) {
                photoMVList.add(transform(photo));
            }
        } else {
            photoMVList = Collections.emptyList();
        }
        return photoMVList;
    }

    private static PhotoMV transform(Photo photo) {
        PhotoMV photoMV = null;
        if (photo != null) {
            photoMV = new PhotoMV();
            photoMV.setTitle(photo.getTitle());
            photoMV.setThumbnailUrl(photo.getThumbnailUrl());
        }
        return photoMV;
    }

}
