package com.android.photofeed.data.realm;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;

@SuppressWarnings("ALL")
public class SchemaMigration implements RealmMigration {

    public static final long SCHEMA_VERSION = 0;

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

    }

}
