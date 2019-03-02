package home.stanislavpoliakov.meet20_practice;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.text.IsEqualIgnoringCase;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Класс проверки корректности отображения UI-элементов, а также проверки корректности
 * отображаемых данных в этих элементах
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityExistTest {
    private static final String TAG = "meet20_logs";

    @Rule
    public ActivityTestRule<MainActivity> mFirstActivityRule = new ActivityTestRule<>(MainActivity.class);

    /**
     * Присутствует ли на экране EditText lastName?
     */
    @Test
    public void lastNameEditExistTest() {
        onView(withId(R.id.lastNameEdit)).check(matches(isDisplayed()));
    }

    /**
     * Поле lastName соответствует ресурсу String.last_name и значению "Фамилия"?
     */
    @Test
    public void lastNameEditDefaultValueTest() {
        onView(withId(R.id.lastNameEdit))
                .check(matches(withText(R.string.last_name)))
                .check(matches(withText("Фамилия")));
    }

    /**
     * Пристуствует ли на экране EditText firstName?
     */
    @Test
    public void firstNameEditExistTest() {
        onView(withId(R.id.firstNameEdit)).check(matches(isDisplayed()));
    }

    /**
     * Поле firstName соответствует ресурсу String.first_name и значению "Имя"?
     */
    @Test
    public void firstNameEditDefaultValueTest() {
        onView(withId(R.id.firstNameEdit))
                .check(matches(withText(R.string.first_name)))
                .check(matches(withText("Имя")));
    }

    /**
     * Присутствует ли на экране EditText patronymic?
     */
    @Test
    public void patronymicEditExistTest() {
        onView(withId(R.id.patronymicEdit)).check(matches(isDisplayed()));
    }

    /**
     * Поле patronymic соответствует ресурсу String.patronymic и значению "Отчество"?
     */
    @Test
    public void patronymicDefaultValueTest() {
        onView(withId(R.id.patronymicEdit))
                .check(matches(withText(R.string.patronymic)))
                .check(matches(withText("Отчество")));
    }

    /**
     * Присутствует ли не экране Button sendButton?
     */
    @Test
    public void sendButtonExistTest() {
        onView(withId(R.id.sendButton)).check(matches(isDisplayed()));
    }

    /**
     * Название кнопки sendButton соответсвует ресурсу String.button_send и значению "Отправить"?
     * Запускаем тест на проверку значения с ignoreCase - это для наглядности.
     * Мы значем, что R.String.button_send = "Отправить". Мы также знаем, что наименование кнопок
     * Android автоматически преобразует к верхнему регистру ("ОТПРАВИТЬ"). Какой же будет реузультат?
     *
     * "Отравить"? : true
     * "ОТПРАВИТЬ"? : true
     * "отправить" : false
     * "ОтпРавить" : false
     *
     * Получается, что для кнопки одновременно хранится два значения: R.String... и его UpperCase.
     */
    @Test
    public void sendButtonDefaultValueTest() {
        onView(withId(R.id.sendButton))
                .check(matches(withText(R.string.button_send)))
                //.check(matches(withText("ОтпРавить или ОТРАВИТЬ или отправить или Отправить")))
                .check(matches(withText(IsEqualIgnoringCase.equalToIgnoringCase("Отправить"))));
    }

    /**
     * Доступна ли (isEnabled) кнопка sendButton и можно ли на нее нажать?
     */
    @Test
    public void sendButtonEnabledAndClickableTest() {
        onView(withId(R.id.sendButton))
                .check(matches(isEnabled()))
                .check(matches(isClickable()));
    }
}