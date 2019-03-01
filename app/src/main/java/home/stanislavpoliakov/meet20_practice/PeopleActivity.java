package home.stanislavpoliakov.meet20_practice;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

public class PeopleActivity extends AppCompatActivity implements ICallback{
    private static final String TAG = "meet20_logs";
    private List<Person> personList;
    private FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);
    }

    @Override
    protected void onResume() {
        super.onResume();
        personList = getIntent().getParcelableArrayListExtra("personList");
        int resid = personList.get(0).getResId();
        Log.d(TAG, "resId = " + resid);
        String info = getResources().getString(resid);
        Log.d(TAG, "info = " + info);
        //Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
        init();
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        MyAdapter mAdapter = new MyAdapter(this, personList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void itemClicked(int itemPosition) {
        Person person = personList.get(itemPosition);
        int infoId = person.getResId();

        //FragmentManager fragmentManager = getSupportFragmentManager();
        InfoFragment fragment = InfoFragment.newInstance();

        Bundle bundle = new Bundle();
        bundle.putString("lastName", person.getLastName());
        bundle.putString("firstName", person.getFirstName());
        bundle.putString("patronymic", person.getPatronymic());
        if (infoId != 0) bundle.putString("info", getResources().getString(infoId));

        fragment.setArguments(bundle);

        fragmentManager.beginTransaction()
                .add(fragment, "info")
                .commitNow();

    }
}
