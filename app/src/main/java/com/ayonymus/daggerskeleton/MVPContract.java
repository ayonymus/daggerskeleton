package com.ayonymus.daggerskeleton;

public interface MVPContract {

    interface View {
        void updateView(int displayText);
    }

    interface Presenter {
        void setView(View view);
        void doSomething();
    }
}
