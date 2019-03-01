package home.stanislavpoliakov.meet20_practice;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;

@RunWith(AndroidJUnit4.class)
public class PeopleActivityTest {

    @Rule
    public ActivityTestRule<PeopleActivity> mActivity =
            new ActivityTestRule<PeopleActivity>(PeopleActivity.class) {
                private ArrayList<Person> personList = new ArrayList<>();

                @Override
                protected Intent getActivityIntent() {
                    Intent intent = new Intent(InstrumentationRegistry.getContext(), PeopleActivity.class);
                    initList();
                    intent.putParcelableArrayListExtra("personList", personList);
                    return intent;
                }

                @Override
                public PeopleActivity launchActivity(@Nullable Intent startIntent) {
                    return super.launchActivity(startIntent);
                }

                private void initList() {
                    Person pushkin = new Person("Пушкин", "Александр", "Сергеевич");
                    pushkin.setResId(R.string.pushkin);
                    personList.add(pushkin);

                    Person lermontov = new Person("Лермонтов", "Михаил", "Юрьевич");
                    lermontov.setResId(R.string.lermontov);
                    personList.add(lermontov);

                    Person esenin = new Person("Есенин", "Сергей", "Александрович");
                    esenin.setResId(R.string.esenin);
                    personList.add(esenin);

                    Person mayakovskiy = new Person("Маяковский", "Владимир", "Владимирович");
                    mayakovskiy.setResId(R.string.mayakovskiy);
                    personList.add(mayakovskiy);

                    Person blok = new Person("Блок", "Александр", "Александрович");
                    blok.setResId(R.string.blok);
                    personList.add(blok);

                    Person tvardovskiy = new Person("Твардовский", "Александр", "Трифонович");
                    tvardovskiy.setResId(R.string.tvardovskiy);
                    personList.add(tvardovskiy);

                    Person mandelstam = new Person("Мандельштам", "Осип", "Эмильевич");
                    mandelstam.setResId(R.string.mandelshtam);
                    personList.add(mandelstam);

                    Person cvetaeva = new Person("Цветаева", "Марина", "Ивановна");
                    cvetaeva.setResId(R.string.cvetaeva);
                    personList.add(cvetaeva);

                    Person ahmatova = new Person("Ахматова", "Анна", "Андреевна");
                    ahmatova.setResId(R.string.ahmatomva);
                    personList.add(ahmatova);

                    Person tutchev = new Person("Тютчев", "Федор", "Иванович");
                    tutchev.setResId(R.string.tutchev);
                    personList.add(tutchev);

                    Person bunin = new Person("Бунин", "Иван", "Алексеевич");
                    bunin.setResId(R.string.bunin);
                    personList.add(bunin);

                    Person marshak = new Person("Маршак", "Самуил", "Яковлевич");
                    marshak.setResId(R.string.marshak);
                    personList.add(marshak);
                }
            };

    @Test
    public void generalVisibilityTest() {
        mActivity.launchActivity(null);
        onView(withId(R.id.textView2)).check(matches(isDisplayed()));
    }


}