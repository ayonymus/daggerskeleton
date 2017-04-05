package com.ayonymus.daggerskeleton;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    // Inject items

    @Rule public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Before public void setUp() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        App app = (App) instrumentation.getTargetContext().getApplicationContext();
        TestAppComponent component = (TestAppComponent) app.getComponent();
        component.inject(this);
    }

    @Test  public void makeSureSetupWorks() {
        System.out.println("Oh yah");
        assertTrue(true);
    }
}
