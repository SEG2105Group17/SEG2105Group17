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
        assertThat(noInput.getName()).isEqualTo("Zen");
        assertThat(noInput.getDescription()).isEqualTo("Vibes");
        assertThat(noInput.getDate()).isEqualTo("");
        assertThat(noInput.getTime()).isEqualTo("");
        assertThat(noInput.id()).isEqualTo(123);
        assertThat(noInput.Difficulty()).isEqualTo(-1);
        assertThat(noInput.capacity()).isEqualTo(-1);

        // test for 2 input
        assertThat(noInput.getName()).isEqualTo("Zen");
        assertThat(noInput.getDescription()).isEqualTo("Vibes");
        assertThat(noInput.getDate()).isEqualTo("");
        assertThat(noInput.getTime()).isEqualTo("");
        assertThat(noInput.id()).isEqualTo(-1);
        assertThat(noInput.Difficulty()).isEqualTo(-1);
        assertThat(noInput.capacity()).isEqualTo(-1);

        // test for 1 input
        assertThat(noInput.getName()).isEqualTo("Zen");
        assertThat(noInput.getDescription()).isEqualTo("");
        assertThat(noInput.getDate()).isEqualTo("");
        assertThat(noInput.getTime()).isEqualTo("");
        assertThat(noInput.id()).isEqualTo(-1);
        assertThat(noInput.Difficulty()).isEqualTo(-1);
        assertThat(noInput.capacity()).isEqualTo(-1);

        // test for 6 input
        assertThat(noInput.getName()).isEqualTo("Zen");
        assertThat(noInput.getDescription()).isEqualTo("Vibes");
        assertThat(noInput.getDate()).isEqualTo("1/4/2022");
        assertThat(noInput.getTime()).isEqualTo("3:33");
        assertThat(noInput.id()).isEqualTo(-1);
        assertThat(noInput.Difficulty()).isEqualTo(2);
        assertThat(noInput.capacity()).isEqualTo(500);
    }
}
