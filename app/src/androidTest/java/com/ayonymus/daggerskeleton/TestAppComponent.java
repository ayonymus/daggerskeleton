package com.ayonymus.daggerskeleton;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = TestAppModule.class)
public interface TestAppComponent extends AppComponent {
    /* Inject to both the activity and to the test class as well
    * so that we can verify what interactions happened with the mock*/
    void inject(MainActivity mainActivity);
    void inject(MainActivityTest mainActivityTest);
}