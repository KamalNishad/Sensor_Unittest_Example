package com.example.sensorchp_1;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import junit.framework.TestCase;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity>mActivityTestRule=new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mActivity = null;

    @Before
    public void setUp() throws Exception { mActivity= mActivityTestRule.getActivity(); }

    @Test
    public void testLaunch(){
        View view = mActivity.findViewById(R.id.username_edt);
        View view1 =mActivity.findViewById(R.id.password_edt);
        Assert.assertNotNull(view);
        Assert.assertNotNull(view1);
    }

    @After
    public void tearDown() throws Exception { mActivity=null; }
}