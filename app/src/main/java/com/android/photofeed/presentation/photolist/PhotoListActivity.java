package com.android.photofeed.presentation.photolist;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.photofeed.ApplicationComponent;
import com.android.photofeed.R;
import com.android.photofeed.base.BaseActivity;
import com.android.photofeed.component.GridLayoutSpacesItemDecoration;
import com.android.photofeed.presentation.modelview.PhotoMV;

import java.util.List;

import butterknife.BindView;

public class PhotoListActivity extends BaseActivity
    implements PhotoListContract.View {

    @BindView(R.id.rv_photo_list)
    RecyclerView mRvPhotoList;

    @BindView(R.id.et_search_query)
    EditText mEtSearchQuery;

    @BindView(R.id.iv_clear_query)
    ImageView mIvClearQuery;

    private PhotoListAdapter mAdapter;

    private PhotoListContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideLeftMenu();
        initPresenter();
        initView();
        initRecyclerView();
        getPhotoList();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_photo_list;
    }

    @Override
    public String getScreenTitle() {
        return getString(R.string.label_search_list_title);
    }

    private void initPresenter() {
        mPresenter = new PhotoListPresenter(
            ApplicationComponent.provideGetPhotoListUseCase(),
            this
        );
    }

    private void initView() {

    }

    private void initRecyclerView() {
        int space = getResources().getDimensionPixelSize(R.dimen.margin_m);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        GridLayoutSpacesItemDecoration itemDecoration = new GridLayoutSpacesItemDecoration(space);
        mAdapter = new PhotoListAdapter(this);
        mRvPhotoList.setAdapter(mAdapter);
        mRvPhotoList.addItemDecoration(itemDecoration);
        mRvPhotoList.setLayoutManager(layoutManager);
    }

    private void getPhotoList() {
        mPresenter.getPhotoList();
    }

    @Override
    public void populatePhotoList(List<PhotoMV> photoMVList) {
        for (PhotoMV photoMV : photoMVList)
            mAdapter.addData(photoMV);
    }

}
