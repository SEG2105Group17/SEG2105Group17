package com.example.lab1;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
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
import androidx.test.ext.junit.runners.AndroidJUnit4;

@RunWith(AndroidJUnit4.class)
public class JUnitTest {
    @Rule
    public ActivityScenarioRule<MainActivity> rule = new ActivityScenarioRule<MainActivity>(MainActivity.class);
    @Test
    public void testAddition(){

        onView(withId(R.id.btn1)).perform(click());//click button 1
        onView(withId(R.id.btnAdd)).perform(click());//click button add
        onView(withId(R.id.btn2)).perform(click());//click button 2

        onView(withId(R.id.btnEqual)).perform(click());//click equals
        onView(withId(R.id.display)).check(matches(withText("3")));//check to see if display correct

    }
    @Test
    public void testSubtraction(){
        onView(withId(R.id.btn9)).perform(click());//click button 9
        onView(withId(R.id.btnSub)).perform(click());//click button sub
        onView(withId(R.id.btn5)).perform(click());//click button 5

        onView(withId(R.id.btnEqual)).perform(click());//click equals
        onView(withId(R.id.display)).check(matches(withText("4")));//check to see if display correct

    }
    @Test
    public void testMultiplication(){
        onView(withId(R.id.btn2)).perform(click());//click button 2
        onView(withId(R.id.btnMul)).perform(click());//click button mul
        onView(withId(R.id.btn8)).perform(click());//click button 8

        onView(withId(R.id.btnEqual)).perform(click());//click equals
        onView(withId(R.id.display)).check(matches(withText("16")));//check to see if display correct

    }
    @Test
    public void testDivision(){
        onView(withId(R.id.btn8)).perform(click());//click button 8
        onView(withId(R.id.btnDiv)).perform(click());//click button div
        onView(withId(R.id.btn4)).perform(click());//click button 4

        onView(withId(R.id.btnEqual)).perform(click());//click equals
        onView(withId(R.id.display)).check(matches(withText("2")));//check to see if display correct

    }

    @Test
    public void testDecimal(){
        onView(withId(R.id.btn1)).perform(click());//click button 1
        onView(withId(R.id.btnDec)).perform(click());//click button decimal
        onView(withId(R.id.btn5)).perform(click());//click button 5
        onView(withId(R.id.btnAdd)).perform(click());//click button add
        onView(withId(R.id.btn2)).perform(click());//click button 2

        onView(withId(R.id.btnEqual)).perform(click());//click equals
        onView(withId(R.id.display)).check(matches(withText("3.5")));//check to see if display correct

    }

    @Test
    public void testClear(){
        onView(withId(R.id.btn1)).perform(click());//click button 1
        onView(withId(R.id.btnClear)).perform(click());//click button clear

        onView(withId(R.id.display)).check(matches(withText("")));//check to see if display correct

    }
}
