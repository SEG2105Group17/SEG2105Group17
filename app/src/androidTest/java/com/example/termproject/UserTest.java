package com.example.termproject;

import junit.framework.TestCase;

import org.junit.Test;

public class UserTest extends TestCase {
    User testUserblank = new User();
    User testUser3Input = new User(123, "avrage", "joe");
    User testUser2Input = new User("avrage", "joe");

    @Test
    /** Chewcking constructors */
    public void testUserConstructor() {

        // testing with black constructor
        assertEquals(testUserblank.getID(),-1);
        assertEquals(testUserblank.getUserName(),"");
        assertEquals(testUserblank.getUserType(),"");

        // testing with 3 inputs constructor
        assertEquals(testUser3Input.getID(),(123));
        assertEquals(testUser3Input.getUserName(),"avrage");
        assertEquals(testUser3Input.getUserType(),"joe");

        // testing with 2 inputs constructor
        assertEquals(testUser2Input.getID(),-1);
        assertEquals(testUser2Input.getUserName(),"avrage");
        assertEquals(testUser2Input.getUserType(),"joe");

    }

    @Test
    /** Check the setter methods */
    public void testChanges() {
        testUserblank.setID(456);
        testUser3Input.setID(456);
        testUser2Input.setID(456);

        testUserblank.setUserName("HELP");
        testUser3Input.setUserName("HELP");
        testUser2Input.setUserName("HELP");

        testUserblank.setUserType("GOD");
        testUser3Input.setUserType("GOD");
        testUser2Input.setUserType("GOD");

        // testing with black constructor
        assertEquals(testUserblank.getID(),456);
        assertEquals(testUserblank.getUserName(),"HELP");
        assertEquals(testUserblank.getUserType(),"GOD");

        // testing with 3 inputs constructor
        assertEquals(testUser3Input.getID(),456);
        assertEquals(testUser3Input.getUserName(),"HELP");
        assertEquals(testUser3Input.getUserType(),"GOD");

        // testing with 2 inputs constructor
        assertEquals(testUser2Input.getID(),456);
        assertEquals(testUser2Input.getUserName(),"HELP");
        assertEquals(testUser2Input.getUserType(),"GOD");
    }

}