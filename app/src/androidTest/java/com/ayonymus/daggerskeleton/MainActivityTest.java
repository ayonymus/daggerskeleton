package com.ayonymus.daggerskeleton;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Inject MVPContract.Presenter presenter;

    @Rule public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Before public void setUp() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        App app = (App) instrumentation.getTargetContext().getApplicationContext();
        TestAppComponent component = (TestAppComponent) app.getComponent();
        component.inject(this);
    }

    @Test public void whenActivityStarted_thenViewIsSet() {
        verify(presenter, atLeastOnce()).setView(any(MVPContract.View.class));
    }

    /*
     * We only have to check if the click has been delegated to the presenter a
     * the presenter has its own fast and thorough unit tests.
      * */
    @Test public void whenButtonClicked_theDelegatedToPresenter() {
        onView(withId(R.id.button)).perform(click());
        verify(presenter, times(1)).doSomething();
    }

    /*
    * The update(int) method is called from a real presenter when the view is set.
    * In this case however we just mocked out the presenter, so it does not have
    * callbacks for the view. And quite frankly we only care what happens when
    * the view is updated.
    * */
    @Test public void whenUpdateCalled_thenViewUpdated() throws Throwable {
        // calls to ui still must be performed on the main thread
        rule.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                rule.getActivity().updateView(5);
            }
        });
        onView(withId(R.id.textView)).check(matches(withText("What a lovely day! " + 5)));
    }

}
