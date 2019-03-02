package home.stanislavpoliakov.meet20_practice;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static home.stanislavpoliakov.meet20_practice.ActionOnLastItem.scrollToLastAnd;

/**
 * Класс, описывающий взаимодействие пользователя с нашей программой (UseCases)
 */
@RunWith(AndroidJUnit4.class)
public class UseCaseTests {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    /**
     * Ничего не вводим в на первом экране, нажимаем кнопку "Отправить", в появившейся Activity
     * листаем RecyclerView до последнего элемента, нажимаем на него и сравниваем полученные значения
     */
    @Test
    public void defaultInputFlowTest() {

//        Нажимаем на кнопку "Отправить"
        onView(withId(R.id.sendButton)).perform(click());

//         Пролистываем RecyclerView до последнего элемента
//         Здесь метод scrollToLastAnd - это наш метод, в котором мы находим последний элемент,
//         скроллим до него и кликаем
        onView(withId(R.id.recyclerView)).perform(scrollToLastAnd(click()));

//         Проверяем полученные значения, которые видит пользователь
        onView(withId(R.id.nameView)).check(matches(withText("Фамилия Имя Отчество")));
    }

    /**
     * Вводим значения в поля ввода на первом экране, нажимаем кнопку, листаем до конца и проверяем реузльтат
     */
    @Test
    public void someInputFlowTest() {

//        Вводим фамилию
        onView(withId(R.id.lastNameEdit)).perform(replaceText("Бродский"));

//        Вводим имя
        onView(withId(R.id.firstNameEdit)).perform(replaceText("Иосиф"));

//        Вводим отчество
        onView(withId(R.id.patronymicEdit)).perform(replaceText("Александрович"));

//        Нажимаем кнопку "Отправить"
        onView(withId(R.id.sendButton)).perform(click());

//        Листаем до конца RecyclerView и кликаем на последнем элементе
        onView(withId(R.id.recyclerView)).perform(scrollToLastAnd(click()));

//        Проверяем результат на совпадение
        onView(withId(R.id.nameView)).check(matches(withText("Бродский Иосиф Александрович")));
    }
}
