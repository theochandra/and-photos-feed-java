package com.android.photofeed;

import com.android.photofeed.data.source.factory.PhotoDataSourceFactory;
import com.android.photofeed.domain.repository.PhotoDataRepository;
import com.android.photofeed.domain.repository.PhotoRepository;
import com.android.photofeed.domain.usecase.GetPhotoListUseCase;

public class ApplicationComponent {

    private ApplicationComponent() { }

    private static PhotoRepository providePhotoRepository() {
        PhotoDataSourceFactory photoDataSourceFactory = new PhotoDataSourceFactory();
        return new PhotoDataRepository(photoDataSourceFactory.createCloudDataSource(),
            photoDataSourceFactory.createLocalDataSource());
    }

    public static GetPhotoListUseCase provideGetPhotoListUseCase(){
        return new GetPhotoListUseCase(providePhotoRepository());
    }

}
