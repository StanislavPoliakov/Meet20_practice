package home.stanislavpoliakov.meet20_practice;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    private static final String TAG = "meet20_logs";


    @Rule
    public ActivityTestRule<MainActivity> mFirstActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void lastNameEditExistTest() {
        onView(withId(R.id.lastNameEdit)).check(matches(isDisplayed()));
    }

    @Test
    public void lastNameEditDefaultValue() {
        onView(withId(R.id.lastNameEdit)).check(matches(withText(R.string.last_name)));
    }

    @Test
    public void firstNameEditExistTest() {
        onView(withId(R.id.firstNameEdit)).check(matches(isDisplayed()));
    }

    @Test
    public void firstNameEditDefaultValue() {
        onView(withId(R.id.firstNameEdit)).check(matches(withText(R.string.first_name)));
    }

    @Test
    public void patronymicEditExistTest() {
        onView(withId(R.id.patronymicEdit)).check(matches(isDisplayed()));
    }

    @Test
    public void patronymicDefaultValue() {
        onView(withId(R.id.patronymicEdit)).check(matches(withText(R.string.patronymic)));
    }

    @Test
    public void sendButtonDisplayedAndClickableTest() {
        onView(withId(R.id.sendButton)).check(matches(isDisplayed()));
        onView(withId(R.id.sendButton)).check(matches(withText(R.string.button_send)));
        onView(withId(R.id.sendButton)).check(matches(isClickable()));
    }

    //Flow test
    @Test
    public void secondActivityStartedTest() {
        Intents.init();
        onView(withId(R.id.sendButton)).perform(click());
        intended(hasComponent(PeopleActivity.class.getName()));
    }

    @Test
    public void recyclerViewContainsNewDataTest() {
        //Intents.init();

        onView(withId(R.id.lastNameEdit)).perform(replaceText("Иванов"));
        onView(withId(R.id.firstNameEdit)).perform(replaceText("Иван"));
        onView(withId(R.id.patronymicEdit)).perform(replaceText("Иванович"));

        onView(withId(R.id.sendButton)).perform(click());

        //Log.d(TAG, "activityRule = " + mFirstActivityRule.getActivity());

        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition(100, click()));

        onView(withId(R.id.infoView)).check(matches(isDisplayed()));
        onView(withId(R.id.infoView)).check(matches(withText(R.string.lermontov)));

        //intended(hasComponent(InfoFragment.class.getName()));

    }

}