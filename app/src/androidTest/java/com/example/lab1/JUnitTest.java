package com.example.lab1;
import static androidx.test.espresso.Espresso.onView;

import org.junit.Test;
import static org.junit.Assert.*;


public class JUnitTest {

    @Test
    public void testAddition(){
        onView(withId(R.id.btn1)).perform(click());//click button 1
        onView(withId(R.id.btnAdd)).perform(click());//click button add
        onView(withId(R.id.btn2)).perform(click());//click button 2

        onView(withId(R.id.btnEqual)).perform(click());//click equals
        onView(withID(R.id.display)).check(mathces("3"));//check to see if display correct

    }
    @Test
    public void testSubtraction(){
        onView(withId(R.id.btn9)).perform(click());//click button 9
        onView(withId(R.id.btnSub)).perform(click());//click button sub
        onView(withId(R.id.btn5)).perform(click());//click button 5

        onView(withId(R.id.btnEqual)).perform(click());//click equals
        onView(withID(R.id.display)).check(mathces("4"));//check to see if display correct

    }
    @Test
    public void testMultiplication(){
        onView(withId(R.id.btn2)).perform(click());//click button 2
        onView(withId(R.id.btnMul)).perform(click());//click button mul
        onView(withId(R.id.btn8)).perform(click());//click button 8

        onView(withId(R.id.btnEqual)).perform(click());//click equals
        onView(withID(R.id.display)).check(mathces("16"));//check to see if display correct

    }
    @Test
    public void testDivision(){
        onView(withId(R.id.btn8)).perform(click());//click button 8
        onView(withId(R.id.btnDiv)).perform(click());//click button div
        onView(withId(R.id.btn4)).perform(click());//click button 4

        onView(withId(R.id.btnEqual)).perform(click());//click equals
        onView(withID(R.id.display)).check(mathces("2"));//check to see if display correct

    }

    @Test
    public void testDecimal(){
        onView(withId(R.id.btn1)).perform(click());//click button 1
        onView(withId(R.id.btnDec)).perform(click());//click button decimal
        onView(withId(R.id.btn5)).perform(click());//click button 5
        onView(withId(R.id.btnAdd)).perform(click());//click button add
        onView(withId(R.id.btn2)).perform(click());//click button 2

        onView(withId(R.id.btnEqual)).perform(click());//click equals
        onView(withID(R.id.display)).check(mathces("3.5"));//check to see if display correct

    }

    @Test
    public void testClear(){
        onView(withId(R.id.btn1)).perform(click());//click button 1
        onView(withId(R.id.btnClear)).perform(click());//click button clear

        onView(withID(R.id.display)).check(mathces(""));//check to see if display correct

    }
}
