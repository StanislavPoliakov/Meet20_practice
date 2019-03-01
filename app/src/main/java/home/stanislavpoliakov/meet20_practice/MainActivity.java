package home.stanislavpoliakov.meet20_practice;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "meet20_logs";
    private ArrayList<Person> personList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initList();
        init();
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

    private void init() {
        EditText lastNameEdit = findViewById(R.id.lastNameEdit);
        EditText firstNameEdit = findViewById(R.id.firstNameEdit);
        EditText patronymicEdit = findViewById(R.id.patronymicEdit);
        Button sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener((v) -> {
            String lastName = lastNameEdit.getText().toString();
            String firstName = firstNameEdit.getText().toString();
            String patronymic = patronymicEdit.getText().toString();

            Person person = new Person(lastName, firstName, patronymic);
            personList.add(person);

            Intent secondActivityIntent = new Intent(this, PeopleActivity.class);
            secondActivityIntent.putParcelableArrayListExtra("personList", personList);

            startActivity(secondActivityIntent);
        });
    }
}
