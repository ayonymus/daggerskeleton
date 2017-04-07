package com.ayonymus.daggerskeleton;


public class MainPresenter implements MVPContract.Presenter {

    private MVPContract.View view;
    private int counter = 0;

    @Override public void setView(MVPContract.View view) {
        this.view = view;
        view.updateView(counter);
    }

    @Override public void doSomething() {
        counter++;
        view.updateView(counter);
    }
}
