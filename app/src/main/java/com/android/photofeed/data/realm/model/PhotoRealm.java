package com.android.photofeed.data.realm.model;

import com.android.photofeed.data.model.Photo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

@SuppressWarnings("ALL")
public class PhotoRealm extends RealmObject {

    @PrimaryKey
    private int id;

    private int albumId;

    private String title;

    private String url;

    private String thumbnailUrl;

    public PhotoRealm() { }

    public PhotoRealm(Photo photo) {
        this.id = photo.getId();
        this.albumId = photo.getAlbumId();
        this.title = photo.getTitle();
        this.url = photo.getUrl();
        this.thumbnailUrl = photo.getThumbnailUrl();
    }

    public PhotoRealm(int id, int albumId, String title, String url, String thumbnailUrl) {
        this.id = id;
        this.albumId = albumId;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Photo transform() {
        return new Photo(id, albumId, title, url, thumbnailUrl);
    }

}
