package com.ayonymus.daggerskeleton;

import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module public class TestAppModule {
    @Provides @Singleton MVPContract.Presenter presenter() {
        return Mockito.mock(MVPContract.Presenter.class);
    }
}
