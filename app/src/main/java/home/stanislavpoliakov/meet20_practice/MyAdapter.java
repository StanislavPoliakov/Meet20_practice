package home.stanislavpoliakov.meet20_practice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private static final String TAG = "meet20_logs";
    private List<Person> data;
    private ICallback mActivity;

    public MyAdapter(Context context, List<Person> data) {
        this.data = data;
        try {
            mActivity = (ICallback) context;
        } catch (ClassCastException ex) {
            Log.w(TAG, "MyAdapter: PeopleActivity must implement ICallback interface", ex);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String lastName = data.get(position).getLastName();
        String firstName = data.get(position).getFirstName();
        int id = data.get(position).getPersonId();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(id)
                .append(") ")
                .append(firstName)
                .append(" ")
                .append(lastName);

        holder.briefInfo.setText(stringBuilder.toString());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView briefInfo;

        public MyViewHolder(View itemView) {
            super(itemView);

            briefInfo = itemView.findViewById(R.id.briefInfo);
            itemView.setOnClickListener((v) -> {
                mActivity.itemClicked(getAdapterPosition());
            });
        }
    }
}
