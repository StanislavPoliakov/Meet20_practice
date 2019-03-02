package home.stanislavpoliakov.meet20_practice;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.hamcrest.Matcher;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;

public class ActionOnLastItem implements ViewAction {
    private static final String TAG = "meet20_logs";
    private ViewAction viewAction;

    private ActionOnLastItem(ViewAction action) {
        this.viewAction = action;
    }

    @Override
    public Matcher<View> getConstraints() {
        return isAssignableFrom(RecyclerView.class);
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void perform(UiController uiController, View view) {
        RecyclerView recyclerView = (RecyclerView) view;
        int lastPosition = recyclerView.getAdapter().getItemCount() - 1;
        RecyclerViewActions.actionOnItemAtPosition(lastPosition, click())
                .perform(uiController, view);
    }

    public static ActionOnLastItem scrollToLastAnd(ViewAction action) {
        return new ActionOnLastItem(action);
    }
}
