package home.stanislavpoliakov.meet20_practice;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
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
    private int count;

    private class MyMatcher extends TypeSafeMatcher<View> {
        //private String matchTo;
        //private int count;

        public int getCount() {
            return count;
        }

        public MyMatcher() {

        }

        @Override
        protected boolean matchesSafely(View item) {
            RecyclerView recyclerView = (RecyclerView) item;
            //Log.d(TAG, "matchesSafely: item = " + item);
            MyAdapter myAdapter = (MyAdapter) recyclerView.getAdapter();
            //Log.d(TAG, "matchesSafely: adapter = " + myAdapter);
            count = myAdapter.getItemCount();
            //Log.d(TAG, "matchesSafely: count = " + itemCount);
            /*View mView = recyclerView.getChildAt(itemCount - 1);
            Log.d(TAG, "matchesSafely: child view = " + mView);

            MyAdapter.MyViewHolder myViewHolder = (MyAdapter.MyViewHolder) recyclerView.getChildViewHolder(mView);*/

            return true;
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("Items count = " + count);
        }
    }

    @Rule
    public ActivityTestRule<MainActivity> mFirstActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void recyclerViewCountItemsWithMatcherTest() {
        onView(withId(R.id.sendButton)).perform(click());
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()));

        MyMatcher getCount = new MyMatcher();

        onView(withId(R.id.recyclerView)).check(matches(getCount));

        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition(count - 1, click()));

        onView(withId(R.id.nameView)).check(matches(withText("Фамилия Имя Отчество")));

        //Log.d(TAG, "recyclerViewCountItemsWithMatcherTest: count = " + getItemCount);
    }

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

        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition(12, click()));

        onView(withId(R.id.nameView)).check(matches(isDisplayed()));
        onView(withId(R.id.nameView)).check(matches(withText("Иванов Иван Иванович")));

        //intended(hasComponent(InfoFragment.class.getName()));

    }

}