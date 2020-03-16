package com.android.photofeed;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

@SuppressWarnings("ALL")
public class AndroidApplication extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context sContext;

    public static Context getAppContext() {
        return AndroidApplication.sContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        synchronized (AndroidApplication.class) {
            sContext = getApplicationContext();
        }

        initRealm();
    }

    private void initRealm() {
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
            .encryptionKey(EncryptionKey.generateKey())
            .schemaVersion(SchemaMigration.SCHEMA_VERSION)
            .migration(new SchemaMigration())
            .build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }

}
