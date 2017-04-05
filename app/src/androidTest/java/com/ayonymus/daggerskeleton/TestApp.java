package com.ayonymus.daggerskeleton;

public class TestApp extends App {

    @Override protected AppComponent createComponent() {
        return DaggerTestAppComponent.builder().build();
    }
}
