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

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import junit.framework.TestCase;

import org.junit.Test;
public class MemberLoginTest {
    @Rule
    public ActivityScenarioRule<MemberLoginActivity> rule = new ActivityScenarioRule<MemberLoginActivity>(MemberLoginActivity.class);

    @Test
    public void testValidUsername(){
        onView(withId(R.id.editUsernameA)).perform(typeText("Bill"));
        onView(withText("Bill")).check(matches(isDisplayed()));
        //onView(withText("Bill")).check(matches(R.id.editUsernameA.getText.toString()));
    }

    @Test
    public void testValidPassword(){
        onView(withId(R.id.editPasswordA)).perform(typeText("Bill"));
        onView(withText("Bill")).check(matches(isDisplayed()));
    }

    @Test
    public void testValidUsername2(){
        onView(withId(R.id.editPasswordA)).perform(typeText("Joe"));
        onView(withText("Joe")).check(matches(isDisplayed()));
    }

    @Test
    public void testValidUsername3(){
        onView(withId(R.id.editPasswordA)).perform(typeText("Sandy"));
        onView(withText("Sandy")).check(matches(isDisplayed()));
    }

    @Test
    public void testValidPassword2(){
        onView(withId(R.id.editPasswordA)).perform(typeText("123"));
        onView(withText("123")).check(matches(isDisplayed()));
    }
}
