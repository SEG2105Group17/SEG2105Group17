package com.example.termproject;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.StringContains.containsString;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import junit.framework.TestCase;

import org.junit.Test;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

@RunWith(AndroidJUnit4.class)
public class MemberTest {
    @Rule
    public ActivityScenarioRule<MemberEnrolActivity> rule = new ActivityScenarioRule<MemberEnrolActivity>(MemberEnrolActivity.class);

    @Test
    public void testCourseName(){
        onView(withId(R.id.editMCourse)).perform(typeText("Pushups"));
        onView(withText("Pushups")).check(matches(isDisplayed()));
    }

    @Test
    public void testDay(){
        onView(withId(R.id.editMDay)).perform(typeText("Monday"));
        onView(withText("Monday")).check(matches(isDisplayed()));
    }
}
