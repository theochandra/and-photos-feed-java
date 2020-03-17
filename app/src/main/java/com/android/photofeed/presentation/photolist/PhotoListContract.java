package com.android.photofeed.presentation.photolist;

import com.android.photofeed.base.BasePresenter;
import com.android.photofeed.base.BaseView;
import com.android.photofeed.presentation.modelview.PhotoMV;

import java.util.List;

public interface PhotoListContract {

    interface View extends BaseView {

        void populatePhotoList(List<PhotoMV> photoMVList);

    }

    interface Presenter extends BasePresenter {

        void getPhotoList();

    }

}
