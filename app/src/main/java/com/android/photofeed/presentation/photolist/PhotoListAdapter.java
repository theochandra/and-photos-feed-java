package com.android.photofeed.presentation.photolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.photofeed.R;
import com.android.photofeed.presentation.modelview.PhotoMV;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoListAdapter extends RecyclerView.Adapter {

    private List<PhotoMV> mPhotoMVList;

    private Context mContext;

    public PhotoListAdapter(Context context) {
        mContext = context;
        mPhotoMVList = new ArrayList<>();
    }

    public void addData(PhotoMV photoMV) {
        mPhotoMVList.add(photoMV);
        notifyItemInserted(getItemCount() - 1);
    }

    public void clearData() {
        mPhotoMVList.clear();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_photo, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PhotoViewHolder photoViewHolder = (PhotoViewHolder) holder;
        PhotoMV photoMV = mPhotoMVList.get(position);
        photoViewHolder.bindData(photoMV);
    }

    @Override
    public int getItemCount() {
        return mPhotoMVList.size();
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_photo)
        ImageView mIvPhoto;

        @BindView(R.id.tv_title)
        TextView mTvTitle;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindData(PhotoMV photoMV) {
            mTvTitle.setText(photoMV.getTitle());

            Picasso.get().load(photoMV.getThumbnailUrl())
                .placeholder(R.drawable.image_placeholder)
                .into(mIvPhoto);
        }

    }

}
