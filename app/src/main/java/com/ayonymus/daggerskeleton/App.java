package com.ayonymus.daggerskeleton;

import android.app.Application;


public class App extends Application {

    private final AppComponent component = createComponent();

    private AppComponent createComponent() {
        return DaggerAppComponent.builder().build();
    }

    public AppComponent getComponent() {
        return component;
    }
}
