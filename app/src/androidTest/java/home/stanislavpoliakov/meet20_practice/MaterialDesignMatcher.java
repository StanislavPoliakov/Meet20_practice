package home.stanislavpoliakov.meet20_practice;

import android.support.test.InstrumentationRegistry;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.stream.DoubleStream;

public abstract class MaterialDesignMatcher extends TypeSafeMatcher<View> {
    private static final String TAG = "meet20_logs";

    @Override
    protected boolean matchesSafely(View item) {
        return false;
    }

    boolean checkPaddings(View view) {
        boolean isCorrectTop = view.getPaddingTop() % 4 == 0;
        boolean isCorrectBottom = view.getPaddingBottom() % 4 == 0;
        boolean isCorrectLeft = view.getPaddingLeft() % 4 == 0;
        boolean isCorrectRight = view.getPaddingRight() % 4 == 0;

        return isCorrectTop && isCorrectBottom && isCorrectLeft && isCorrectRight;
    }

    boolean checkFontSize(View view) {
        float scaleDensity = InstrumentationRegistry.getContext().getResources().getDisplayMetrics().scaledDensity;
        double[] sizeArray = {10, 12, 14, 16, 20, 24, 34, 48, 60, 96};
        float size = ((TextView) view).getTextSize();
        return DoubleStream.of(sizeArray).anyMatch(x -> x == Math.round(size / scaleDensity));
    }

    static MaterialDesignMatcher isCorrectTextView() {
        return new MDTextViewMatcher();
    }

    static MaterialDesignMatcher isCorrectViewHolder() {
        return new MDViewHolderMatcher();
    }
}
