package com.ayonymus.daggerskeleton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MVPContract.View {

    @Inject MVPContract.Presenter presenter;

    @BindView(R.id.textView) TextView textView;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplication()).getComponent().inject(this);
        ButterKnife.bind(this);
        presenter.setView(this);
    }

    @OnClick(R.id.button) public void click() {
        presenter.doSomething();
    }

    @Override public void updateView(int text) {
        textView.setText("What a lovely day! " + text);
    }
}
