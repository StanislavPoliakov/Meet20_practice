package home.stanislavpoliakov.meet20_practice;

import android.view.View;

import org.hamcrest.Description;

public class MDTextViewMatcher extends MaterialDesignMatcher {

    @Override
    protected boolean matchesSafely(View item) {
        return checkFontSize(item) && checkPaddings(item);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("meet the MaterialDesign requirements");
    }
}
