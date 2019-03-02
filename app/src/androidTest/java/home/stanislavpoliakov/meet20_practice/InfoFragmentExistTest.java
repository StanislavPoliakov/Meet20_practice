package home.stanislavpoliakov.meet20_practice;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static home.stanislavpoliakov.meet20_practice.MaterialDesignMatcher.isCorrectTextView;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;

/**
 * Класс проверки корректности отображения UI-элементов, а также проверки корректности
 * отображаемых данных в этих элементах
 */
@RunWith(AndroidJUnit4.class)
public class InfoFragmentExistTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    /**
     * Выводим фрагмент перед каждым тестом
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        onView(withId(R.id.sendButton)).perform(click());
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }

    /**
     * Присутсвует ли на экране (и видна ли пользователю) TextView nameView?
     * Важное уточнение по поводу видимости пользователю - если содержимое TextView осутствует,
     * то значение isDisplayed = false (то есть не видимо для пользователя), но
     * withEffectiveVisibility(Visibility.VISIBLE) = true (то есть на экране присутсвует)!
     */
    @Test
    public void nameTextViewExistTest() {
        onView(withId(R.id.nameView)).check(matches(isDisplayed()));
    }

    /**
     * Надпись не пуста?
     */
    @Test
    public void nameTextViewNotNullOrEmptyTest() {
        onView(withId(R.id.nameView)).check(matches(withText(not(isEmptyOrNullString()))));
    }

    /**
     * Соответсвует ли nameView стандартам MaterialDesign?
     */
    @Test
    public void nameTextViewMaterialDesignTest() {
        onView(withId(R.id.nameView)).check(matches(isCorrectTextView()));
    }

    /**
     * Присутсвует ли на экране (и видна ли пользователю) TextView infoView?
     */
    @Test
    public void infoTextViewExistTest() {
        onView(withId(R.id.infoView)).check(matches(isDisplayed()));
    }

    /**
     * Надпись не пуста?
     */
    @Test
    public void infoTextViewNotNullOrEmptyTest() {
        onView(withId(R.id.infoView)).check(matches(withText(not(isEmptyOrNullString()))));
    }

    /**
     * Соответсвует ли nameView стандартам MaterialDesign?
     */
    @Test
    public void infoTextViewMaterialDesignTest() {
        onView(withId(R.id.infoView)).check(matches(isCorrectTextView()));
    }
}