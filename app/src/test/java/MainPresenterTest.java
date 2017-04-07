package com.ayonymus.daggerskeleton;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/*
* CAU: do not use dependency injection in unit test! Mock the components instead!
* */
public class MainPresenterTest {

    @Mock MVPContract.View view;

    MainPresenter presenter;

    @Before public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new MainPresenter();
    }

    @Test public void givenViewIsSet_thenUpdateImmediately() {
        presenter.setView(view);
        verify(view, times(1)).updateView(0);
    }


}