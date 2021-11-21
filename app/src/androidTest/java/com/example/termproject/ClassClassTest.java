package com.example.termproject;

import junit.framework.TestCase;


public class ClassClassTest extends TestCase {

    ClassClass noInput = new ClassClass();
    ClassClass with3Input = new ClassClass(123, "Zen", "Vibes");
    ClassClass with1Input = new ClassClass("Zen");
    ClassClass with2Input = new ClassClass("Zen", "Vibes");
   // ClassClass with6Input = new ClassClass("Zen", "Vibes", "1/4/2022", "3:33", 2, 500);

//    @Test
//    /** Testing of creted blank ClassClass */
//    public void testClassClassConstructors() {
//
//        // test for no input
//        assertThat(noInput.getName()).isEqualTo("");
//        assertThat(noInput.getDescription()).isEqualTo("");
//        assertThat(noInput.getDate()).isEqualTo("");
//        assertThat(noInput.getTime()).isEqualTo("");
//        assertThat(noInput.id()).isEqualTo(-1);
//        assertThat(noInput.Difficulty()).isEqualTo(-1);
//        assertThat(noInput.capacity()).isEqualTo(-1);
//
//        // test for 3 input
//        assertThat(with3Input.getName()).isEqualTo("Zen");
//        assertThat(with3Input.getDescription()).isEqualTo("Vibes");
//        assertThat(with3Input.getDate()).isEqualTo("");
//        assertThat(with3Input.getTime()).isEqualTo("");
//        assertThat(with3Input.id()).isEqualTo(123);
//        assertThat(with3Input.Difficulty()).isEqualTo(-1);
//        assertThat(with3Input.capacity()).isEqualTo(-1);
//
//        // test for 2 input
//        assertThat(with2Input.getName()).isEqualTo("Zen");
//        assertThat(with2Input.getDescription()).isEqualTo("Vibes");
//        assertThat(with2Input.getDate()).isEqualTo("");
//        assertThat(with2Input.getTime()).isEqualTo("");
//        assertThat(with2Input.id()).isEqualTo(-1);
//        assertThat(with2Input.Difficulty()).isEqualTo(-1);
//        assertThat(with2Input.capacity()).isEqualTo(-1);
//
//        // test for 1 input
//        assertThat(with1Input.getName()).isEqualTo("Zen");
//        assertThat(with1Input.getDescription()).isEqualTo("Not Specified");
//        assertThat(with1Input.getDate()).isEqualTo("Not Specified");
//        assertThat(with1Input.getTime()).isEqualTo("Not Specified");
//        assertThat(with1Input.id()).isEqualTo(-1);
//        assertThat(with1Input.Difficulty()).isEqualTo(0);
//        assertThat(with1Input.capacity()).isEqualTo(50);
//
//        // test for 6 input
//        assertThat(with6Input.getName()).isEqualTo("Zen");
//        assertThat(with6Input.getDescription()).isEqualTo("Vibes");
//        assertThat(with6Input.getDate()).isEqualTo("1/4/2022");
//        assertThat(with6Input.getTime()).isEqualTo("3:33");
//        assertThat(with6Input.id()).isEqualTo(-1);
//        assertThat(with6Input.Difficulty()).isEqualTo(2);
//        assertThat(with6Input.capacity()).isEqualTo(500);
//    }
//
//    @Test
//    /** Testing of the setter methods in class class */
//    public void testChanges() {
//        noInput.changeID(1814);
//        with3Input.changeID(1814);
//        with2Input.changeID(1814);
//        with1Input.changeID(1814);
//        with6Input.changeID(1814);
//
//        noInput.changeName("Hell");
//        with3Input.changeName("Hell");
//        with2Input.changeName("Hell");
//        with1Input.changeName("Hell");
//        with6Input.changeName("Hell");
//
//        noInput.changeDescription("Not-A-Vibe");
//        with3Input.changeDescription("Not-A-Vibe");
//        with2Input.changeDescription("Not-A-Vibe");
//        with1Input.changeDescription("Not-A-Vibe");
//        with6Input.changeDescription("Not-A-Vibe");
//
//        noInput.changeDate("0/00/0000");
//        with3Input.changeDate("0/00/0000");
//        with2Input.changeDate("0/00/0000");
//        with1Input.changeDate("0/00/0000");
//        with6Input.changeDate("0/00/0000");
//
//        noInput.changeTime("00:00");
//        with3Input.changeTime("00:00");
//        with2Input.changeTime("00:00");
//        with1Input.changeTime("00:00");
//        with6Input.changeTime("00:00");
//
//        noInput.changeDifficulty(3);
//        with3Input.changeDifficulty(3);
//        with2Input.changeDifficulty(3);
//        with1Input.changeDifficulty(3);
//        with6Input.changeDifficulty(3);
//
//        noInput.changeDifficulty(150);
//        with3Input.changeDifficulty(150);
//        with2Input.changeDifficulty(150);
//        with1Input.changeDifficulty(150);
//        with6Input.changeDifficulty(150);
//
//        // test for no input
//        assertThat(noInput.getName()).isEqualTo("Hell");
//        assertThat(noInput.getDescription()).isEqualTo("Not-A-Vibe");
//        assertThat(noInput.getDate()).isEqualTo("0/00/0000");
//        assertThat(noInput.getTime()).isEqualTo("00:00");
//        assertThat(noInput.id()).isEqualTo(1814);
//        assertThat(noInput.Difficulty()).isEqualTo(150);
//        assertThat(noInput.capacity()).isEqualTo(3);
//
//        // test for 3 input
//        assertThat(noInput.getName()).isEqualTo("Hell");
//        assertThat(noInput.getDescription()).isEqualTo("Not-A-Vibe");
//        assertThat(noInput.getDate()).isEqualTo("0/00/0000");
//        assertThat(noInput.getTime()).isEqualTo("00:00");
//        assertThat(noInput.id()).isEqualTo(1814);
//        assertThat(noInput.Difficulty()).isEqualTo(150);
//        assertThat(noInput.capacity()).isEqualTo(3);
//
//        // test for 2 input
//        assertThat(noInput.getName()).isEqualTo("Hell");
//        assertThat(noInput.getDescription()).isEqualTo("Not-A-Vibe");
//        assertThat(noInput.getDate()).isEqualTo("0/00/0000");
//        assertThat(noInput.getTime()).isEqualTo("00:00");
//        assertThat(noInput.id()).isEqualTo(1814);
//        assertThat(noInput.Difficulty()).isEqualTo(150);
//        assertThat(noInput.capacity()).isEqualTo(3);
//
//        // test for 1 input
//        assertThat(noInput.getName()).isEqualTo("Hell");
//        assertThat(noInput.getDescription()).isEqualTo("Not-A-Vibe");
//        assertThat(noInput.getDate()).isEqualTo("0/00/0000");
//        assertThat(noInput.getTime()).isEqualTo("00:00");
//        assertThat(noInput.id()).isEqualTo(1814);
//        assertThat(noInput.Difficulty()).isEqualTo(150);
//        assertThat(noInput.capacity()).isEqualTo(3);
//
//        // test for 6 input
//        assertThat(noInput.getName()).isEqualTo("Hell");
//        assertThat(noInput.getDescription()).isEqualTo("Not-A-Vibe");
//        assertThat(noInput.getDate()).isEqualTo("0/00/0000");
//        assertThat(noInput.getTime()).isEqualTo("00:00");
//        assertThat(noInput.id()).isEqualTo(1814);
//        assertThat(noInput.Difficulty()).isEqualTo(150);
//        assertThat(noInput.capacity()).isEqualTo(3);
//    }
//
//    @Test
//    /** Testing the method in ClassClass */
//    public void testCheckIfFull() {
//        ClassClass testFull = new ClassClass("Zen");
//        assertThat(testFull.checkIfFull(500)).isTrue();
//        assertThat(testFull.checkIfFull(38)).isFalse();
//
//        testFull.changeCapacity(100);
//        assertThat(testFull.checkIfFull(101)).isTrue();
//        assertThat(testFull.checkIfFull(98)).isFalse();
//        assertThat(testFull.checkIfFull(100)).isFalse();
//
//        ClassClass testFull = new ClassClass("Zen", "Vibes", "1/4/2022", "3:33", 2, 500);
//        assertThat(testFull.checkIfFull(505)).isTrue();
//        assertThat(testFull.checkIfFull(38)).isFalse();
//
//        testFull.changeCapacity(100);
//        assertThat(testFull.checkIfFull(101)).isTrue();
//        assertThat(testFull.checkIfFull(98)).isFalse();
//        assertThat(testFull.checkIfFull(100)).isFalse();
//    }
}