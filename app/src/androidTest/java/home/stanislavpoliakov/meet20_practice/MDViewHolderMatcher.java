package home.stanislavpoliakov.meet20_practice;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class MDViewHolderMatcher extends MaterialDesignMatcher {
    @Override
    protected boolean matchesSafely(View item) {
        MyAdapter.MyViewHolder holder = getViewHolder(item);
        TextView textView = holder.briefInfo;
        return MaterialDesignMatcher.isCorrectTextView().matchesSafely(textView);
    }

    private MyAdapter.MyViewHolder getViewHolder(View view) {
        RecyclerView recyclerView = (RecyclerView) view;
        View childView = recyclerView.getChildAt(0);
        return (MyAdapter.MyViewHolder) recyclerView.getChildViewHolder(childView);
    }

    @Override
    public void describeTo(Description description) {

    }
}
