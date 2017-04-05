package com.ayonymus.daggerskeleton;

import android.app.Application;

public class App extends Application {

    private final AppComponent component = createComponent();

    protected AppComponent createComponent() {
        return DaggerAppComponent.builder().build();
    }

    public AppComponent getComponent() {
        return component;
    }
}
