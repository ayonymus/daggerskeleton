package com.ayonymus.daggerskeleton;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = TestAppModule.class)
public interface TestAppComponent extends AppComponent {
    void inject(MainActivityTest mainActivityTest);
}