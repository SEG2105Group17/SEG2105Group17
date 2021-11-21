package com.example.termproject;

import junit.framework.TestCase;

import org.junit.Test;


public class ClassClassTest extends TestCase {

    ClassClass noInput = new ClassClass();
    ClassClass with3Input = new ClassClass(123, "Zen", "Vibes");
    ClassClass with1Input = new ClassClass("Zen");
    ClassClass with2Input = new ClassClass("Zen", "Vibes");
    ClassClass with6Input = new ClassClass("Zen", "Vibes", "1/4/2022", "3:33", 2, 500,"Jim");

    @Test
    /** Testing of creted blank ClassClass */
    public void testClassClassConstructors() {

        // test for no input
        assertEquals(noInput.getName(),"");
        assertEquals(noInput.getDescription(),"");
        assertEquals(noInput.getDate(),"");
        assertEquals(noInput.getTime(),"");
        assertEquals(noInput.getId(),-1);
        assertEquals(noInput.getDifficulty(),-1);
        assertEquals(noInput.getDifficulty(),-1);

        // test for 3 input
        assertEquals(with3Input.getName(), "Zen");
        assertEquals(with3Input.getDescription(),"Vibes");
        assertEquals(with3Input.getDate(),"");
        assertEquals(with3Input.getTime(),"");
        assertEquals(with3Input.getId(),123);
        assertEquals(with3Input.getDifficulty(),-1);
        assertEquals(with3Input.getCapacity(),-1);

        // test for 2 input
        assertEquals(with2Input.getName(),"Zen");
        assertEquals(with2Input.getDescription(),"Vibes");
        assertEquals(with2Input.getDate(),"");
        assertEquals(with2Input.getTime(),"");
        assertEquals(with2Input.getId(),-1);
        assertEquals(with2Input.getDifficulty(),-1);
        assertEquals(with2Input.getCapacity(),-1);

        // test for 1 input
        assertEquals(with1Input.getName(),"Zen");
        assertEquals(with1Input.getDescription(),"Not Specified");
        assertEquals(with1Input.getDate(),"Not Specified");
        assertEquals(with1Input.getTime(),"Not Specified");
        assertEquals(with1Input.getId(),-1);
        assertEquals(with1Input.getDifficulty(),0);
        assertEquals(with1Input.getCapacity(),50);

        // test for 6 input
        assertEquals(with6Input.getName(),"Zen");
        assertEquals(with6Input.getDescription(),"Vibes");
        assertEquals(with6Input.getDate(),"1/4/2022");
        assertEquals(with6Input.getTime(),"3:33");
        assertEquals(with6Input.getId(),-1);
        assertEquals(with6Input.getDifficulty(),2);
        assertEquals(with6Input.getCapacity(),500);
    }

    @Test
    /** Testing of the setter methods in class class */
    public void testChanges() {
        noInput.changeID(1814);
        with3Input.changeID(1814);
        with2Input.changeID(1814);
        with1Input.changeID(1814);
        with6Input.changeID(1814);

        noInput.changeName("Hell");
        with3Input.changeName("Hell");
        with2Input.changeName("Hell");
        with1Input.changeName("Hell");
        with6Input.changeName("Hell");

        noInput.changeDescription("Not-A-Vibe");
        with3Input.changeDescription("Not-A-Vibe");
        with2Input.changeDescription("Not-A-Vibe");
        with1Input.changeDescription("Not-A-Vibe");
        with6Input.changeDescription("Not-A-Vibe");

        noInput.changeDate("0/00/0000");
        with3Input.changeDate("0/00/0000");
        with2Input.changeDate("0/00/0000");
        with1Input.changeDate("0/00/0000");
        with6Input.changeDate("0/00/0000");

        noInput.changeTime("00:00");
        with3Input.changeTime("00:00");
        with2Input.changeTime("00:00");
        with1Input.changeTime("00:00");
        with6Input.changeTime("00:00");

        noInput.changeDifficulty(3);
        with3Input.changeDifficulty(3);
        with2Input.changeDifficulty(3);
        with1Input.changeDifficulty(3);
        with6Input.changeDifficulty(3);

        noInput.changeDifficulty(150);
        with3Input.changeDifficulty(150);
        with2Input.changeDifficulty(150);
        with1Input.changeDifficulty(150);
        with6Input.changeDifficulty(150);

        // test for no input
        assertEquals(noInput.getName(),"Hell");
        assertEquals(noInput.getDescription(),"Not-A-Vibe");
        assertEquals(noInput.getDate(),"0/00/0000");
        assertEquals(noInput.getTime(),"00:00");
        assertEquals(noInput.getId(),1814);
        assertEquals(noInput.getDifficulty(),150);
        assertEquals(noInput.getCapacity(),3);

        // test for 3 input
        assertEquals(noInput.getName(),"Hell");
        assertEquals(noInput.getDescription(),"Not-A-Vibe");
        assertEquals(noInput.getDate(),"0/00/0000");
        assertEquals(noInput.getTime(),"00:00");
        assertEquals(noInput.getId(),1814);
        assertEquals(noInput.getDifficulty(),150);
        assertEquals(noInput.getCapacity(),3);

        // test for 2 input
        assertEquals(noInput.getName(),"Hell");
        assertEquals(noInput.getDescription(),"Not-A-Vibe");
        assertEquals(noInput.getDate(),"0/00/0000");
        assertEquals(noInput.getTime(),"00:00");
        assertEquals(noInput.getId(),1814);
        assertEquals(noInput.getDifficulty(),150);
        assertEquals(noInput.getCapacity(),3);

        // test for 1 input
        assertEquals(noInput.getName(),"Hell");
        assertEquals(noInput.getDescription(),"Not-A-Vibe");
        assertEquals(noInput.getDate(),"0/00/0000");
        assertEquals(noInput.getTime(),"00:00");
        assertEquals(noInput.getId(),1814);
        assertEquals(noInput.getDifficulty(),150);
        assertEquals(noInput.getCapacity(),3);

        // test for 6 input
        assertEquals(noInput.getName(),"Hell");
        assertEquals(noInput.getDescription(),"Not-A-Vibe");
        assertEquals(noInput.getDate(),"0/00/0000");
        assertEquals(noInput.getTime(),"00:00");
        assertEquals(noInput.getId(),1814);
        assertEquals(noInput.getDifficulty(),150);
        assertEquals(noInput.getCapacity(),3);
    }

    @Test
    /** Testing the method in ClassClass */
    public void testCheckIfFull() {
        ClassClass testFull = new ClassClass("Zen");
        assertTrue(testFull.checkIfFull(500));
        assertFalse(testFull.checkIfFull(38));

        testFull.changeCapacity(100);
        assertTrue(testFull.checkIfFull(101));
        assertFalse(testFull.checkIfFull(98));
        assertFalse(testFull.checkIfFull(100));

        ClassClass testFull2 = new ClassClass("Zen", "Vibes", "1/4/2022", "3:33", 2, 500,"jim");
        assertTrue(testFull2.checkIfFull(505));
        assertFalse(testFull2.checkIfFull(38));

        testFull.changeCapacity(100);
        assertTrue(testFull2.checkIfFull(101));
        assertFalse(testFull2.checkIfFull(98));
        assertFalse(testFull2.checkIfFull(100));
    }
}