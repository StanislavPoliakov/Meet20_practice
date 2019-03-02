package home.stanislavpoliakov.meet20_practice;

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
import static home.stanislavpoliakov.meet20_practice.MaterialDesignMatcher.isCorrectViewHolder;

/**
 * Класс проверки корректности отображения UI-элементов, а также проверки корректности
 * отображаемых данных в этих элементах
 */
@RunWith(AndroidJUnit4.class)
public class PeopleActivityExistTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    /**
     * Запускаем отображение второй активити перед каждым тестом
     */
    @Before
    public void setUp() {
        onView(withId(R.id.sendButton)).perform(click());
    }

    /**
     * Присутствует ли на экране надпись перед списком?
     */
    @Test
    public void labelExistTest() {
        onView(withId(R.id.textView2)).check(matches(isDisplayed()));
    }

    /**
     * Соответсвует ли текст надписи реусурсу String.second_activity_intro и значению "Сохраненные данные"?
     */
    @Test
    public void labelDefaultValueTest() {
        onView(withId(R.id.textView2))
                .check(matches(withText(R.string.second_activity_intro)))
                .check(matches(withText("Сохраненные данные")));
    }

    /**
     * Соответствует ли элемент TextView стандартам MaterialDesign?
     * Проверяет paddings % 4 == 0 и fontSize
     */
    @Test
    public void labelMatchesMaterialDesignTest() {
        onView(withId(R.id.textView2))
                .check(matches(isCorrectTextView()));
    }

    /**
     * Присутсвует ли на экране RecyclerView?
     */
    @Test
    public void recyclerViewExistTest() {
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()));
    }

    /**
     * Соответствует ли элемент RecyclerView стандартам MaterialDesign?
     */
    @Test
    public void recyclerViewItemMaterialDesignTest() {
        onView(withId(R.id.recyclerView))
                .check(matches(isCorrectViewHolder()));
    }
}