package com.example.termproject;

import com.google.common.truth.Truth.assertThat;
import org.junit.Test;

public class ClassClassTest {
    ClassClass noInput = new ClassClass();
    ClassClass with3Input = new ClassClass(123, "Zen", "Vibes");
    ClassClass with1Input = new ClassClass("Zen");
    ClassClass with2Input = new ClassClass("Zen", "Vibes");
    ClassClass with6Input = new ClassClass("Zen", "Vibes", "1/4/2022", "3:33", 2, 500);

    @Test
    /** Testing of creted blank ClassClass */
    public void testClassClassConstructors() {

        // test for no input
        assertThat(noInput.getName()).isEqualTo("");
        assertThat(noInput.getDescription()).isEqualTo("");
        assertThat(noInput.getDate()).isEqualTo("");
        assertThat(noInput.getTime()).isEqualTo("");
        assertThat(noInput.id()).isEqualTo(-1);
        assertThat(noInput.Difficulty()).isEqualTo(-1);
        assertThat(noInput.capacity()).isEqualTo(-1);

        // test for 3 input
        assertThat(with3Input.getName()).isEqualTo("Zen");
        assertThat(with3Input.getDescription()).isEqualTo("Vibes");
        assertThat(with3Input.getDate()).isEqualTo("");
        assertThat(with3Input.getTime()).isEqualTo("");
        assertThat(with3Input.id()).isEqualTo(123);
        assertThat(with3Input.Difficulty()).isEqualTo(-1);
        assertThat(with3Input.capacity()).isEqualTo(-1);

        // test for 2 input
        assertThat(with2Input.getName()).isEqualTo("Zen");
        assertThat(with2Input.getDescription()).isEqualTo("Vibes");
        assertThat(with2Input.getDate()).isEqualTo("");
        assertThat(with2Input.getTime()).isEqualTo("");
        assertThat(with2Input.id()).isEqualTo(-1);
        assertThat(with2Input.Difficulty()).isEqualTo(-1);
        assertThat(with2Input.capacity()).isEqualTo(-1);

        // test for 1 input
        assertThat(with1Input.getName()).isEqualTo("Zen");
        assertThat(with1Input.getDescription()).isEqualTo("");
        assertThat(with1Input.getDate()).isEqualTo("");
        assertThat(with1Input.getTime()).isEqualTo("");
        assertThat(with1Input.id()).isEqualTo(-1);
        assertThat(with1Input.Difficulty()).isEqualTo(-1);
        assertThat(with1Input.capacity()).isEqualTo(-1);

        // test for 6 input
        assertThat(with6Input.getName()).isEqualTo("Zen");
        assertThat(with6Input.getDescription()).isEqualTo("Vibes");
        assertThat(with6Input.getDate()).isEqualTo("1/4/2022");
        assertThat(with6Input.getTime()).isEqualTo("3:33");
        assertThat(with6Input.id()).isEqualTo(-1);
        assertThat(with6Input.Difficulty()).isEqualTo(2);
        assertThat(with6Input.capacity()).isEqualTo(500);
    }

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

        // test for no input
        assertThat(noInput.getName()).isEqualTo("Hell");
        assertThat(noInput.getDescription()).isEqualTo("Not-A-Vibe");
        assertThat(noInput.getDate()).isEqualTo("");
        assertThat(noInput.getTime()).isEqualTo("");
        assertThat(noInput.id()).isEqualTo(-1);
        assertThat(noInput.Difficulty()).isEqualTo(-1);
        assertThat(noInput.capacity()).isEqualTo(1814);

        // test for 3 input
        assertThat(noInput.getName()).isEqualTo("Hell");
        assertThat(noInput.getDescription()).isEqualTo("Not-A-Vibe");
        assertThat(noInput.getDate()).isEqualTo("");
        assertThat(noInput.getTime()).isEqualTo("");
        assertThat(noInput.id()).isEqualTo(123);
        assertThat(noInput.Difficulty()).isEqualTo(-1);
        assertThat(noInput.capacity()).isEqualTo(1814);

        // test for 2 input
        assertThat(noInput.getName()).isEqualTo("Hell");
        assertThat(noInput.getDescription()).isEqualTo("Not-A-Vibe");
        assertThat(noInput.getDate()).isEqualTo("");
        assertThat(noInput.getTime()).isEqualTo("");
        assertThat(noInput.id()).isEqualTo(-1);
        assertThat(noInput.Difficulty()).isEqualTo(-1);
        assertThat(noInput.capacity()).isEqualTo(1814);

        // test for 1 input
        assertThat(noInput.getName()).isEqualTo("Hell");
        assertThat(noInput.getDescription()).isEqualTo("Not-A-Vibe");
        assertThat(noInput.getDate()).isEqualTo("");
        assertThat(noInput.getTime()).isEqualTo("");
        assertThat(noInput.id()).isEqualTo(-1);
        assertThat(noInput.Difficulty()).isEqualTo(-1);
        assertThat(noInput.capacity()).isEqualTo(1814);

        // test for 6 input
        assertThat(noInput.getName()).isEqualTo("Hell");
        assertThat(noInput.getDescription()).isEqualTo("Not-A-Vibe");
        assertThat(noInput.getDate()).isEqualTo("1/4/2022");
        assertThat(noInput.getTime()).isEqualTo("3:33");
        assertThat(noInput.id()).isEqualTo(-1);
        assertThat(noInput.Difficulty()).isEqualTo(2);
        assertThat(noInput.capacity()).isEqualTo(1814);
    }

}
