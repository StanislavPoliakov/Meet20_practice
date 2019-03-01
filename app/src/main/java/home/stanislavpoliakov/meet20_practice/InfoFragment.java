package home.stanislavpoliakov.meet20_practice;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends DialogFragment {

    public static InfoFragment newInstance() {
        return new InfoFragment();
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        Bundle infoBundle = getArguments();

        StringBuilder name = new StringBuilder();
        name.append(infoBundle.getString("lastName"))
                .append(" ")
                .append(infoBundle.getString("firstName"))
                .append(" ")
                .append(infoBundle.getString("patronymic"));

        TextView nameView = view.findViewById(R.id.nameView);
        nameView.setText(name.toString());

        TextView infoView = view.findViewById(R.id.infoView);
        infoView.setText(infoBundle.getString("info"));
    }
}
