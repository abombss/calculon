package com.github.calculon.assertion;

import android.app.Activity;
import android.test.InstrumentationTestCase;
import android.test.MoreAsserts;
import android.widget.TextView;

import static junit.framework.Assert.*;

public class TextViewAssertion extends ViewAssertion {

    private TextView textView;

    public TextViewAssertion(InstrumentationTestCase testCase, Activity activity, TextView textView) {
        super(testCase, activity, textView);
        this.textView = textView;
    }

    /**
     * Asserts that the text within the textview is and empty String
     */
    public void isEmpty() {
        String text = textView.getText().toString();
        assertTrue("expected '" + text +  "' to be empty, but it wasn't", "".equals(text));
    }

    public void reads(String text) {
        assertEquals("text mismatch:", text, textView.getText());
    }

    public void contains(String text) {
        assertTrue("expected text to contain '" + text + "', but it didn't", textView.getText()
                .toString().contains(text));
    }

    public void matches(String regex) {
        MoreAsserts.assertMatchesRegex(regex, textView.getText().toString());
    }

}
