package com.android.photofeed.data.realm;

import com.android.photofeed.data.LocalApi;
import com.android.photofeed.data.model.Photo;
import com.android.photofeed.data.realm.model.PhotoRealm;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.realm.Realm;

public class RealmDataSource implements LocalApi {

    @Override
    public Observable<Boolean> writePhotoList(List<Photo> photoList) {
        if (photoList != null && !photoList.isEmpty()) {
            Realm realm = Realm.getDefaultInstance();
            realm.executeTransaction(transactionRealm -> {
                for (Photo photo : photoList) {
                    PhotoRealm photoRealm = new PhotoRealm(photo);
                    transactionRealm.copyToRealmOrUpdate(photoRealm);
                }
            });

            realm.close();

            return Observable.just(realm.isClosed());
        } else {
            return Observable.just(true);
        }
    }

    @Override
    public Observable<List<Photo>> readPhotoList() {
        Realm realm = Realm.getDefaultInstance();
        List<PhotoRealm> photoRealmList = realm.where(PhotoRealm.class).findAll();
        List<Photo> photoList = new ArrayList<>();
        for (PhotoRealm photoRealm : photoRealmList) {
            photoList.add(photoRealm.transform());
        }
        realm.close();
        return Observable.just(photoList);
    }

}
