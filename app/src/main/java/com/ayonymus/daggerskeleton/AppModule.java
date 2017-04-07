package com.ayonymus.daggerskeleton;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides @Singleton MVPContract.Presenter presenter() {
        return new MainPresenter();
    }
}
