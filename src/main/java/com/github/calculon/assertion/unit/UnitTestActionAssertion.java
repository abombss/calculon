package com.github.calculon.assertion.unit;

import junit.framework.Assert;
import android.app.Activity;
import android.content.Intent;
import android.test.InstrumentationTestCase;

import com.github.calculon.assertion.ActionAssertion;

public class UnitTestActionAssertion extends ActionAssertion {

    public UnitTestActionAssertion(InstrumentationTestCase testCase, Activity activity,
            Runnable action, boolean runOnMainThread) {
        super(testCase, activity, action, runOnMainThread);
    }

    @Override
    public void starts(Class<? extends Activity> activityClass) {
        performPendingAction();

        String expectedActivityClass = activityClass.getCanonicalName();
        Intent intent = new Intent();
        intent = getUnitTestCase().getStartedActivityIntent();
        if (intent == null) {
            Assert.fail(String.format(STARTED_ACTIVITY_FAIL_MSG, expectedActivityClass, "not"));
        } else if (!(expectedActivityClass.equals(intent.getComponent().getClassName()))) {
            Assert.fail(String.format(STARTED_ACTIVITY_FAIL_MSG, expectedActivityClass, intent
                    .getComponent().getClassName()));
        }
    }
}
