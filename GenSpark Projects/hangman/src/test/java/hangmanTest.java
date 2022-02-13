import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class hangmanTest {
    hangman game;

    @BeforeEach
    void setUp() {
        game = new hangman();
    }

    @Test
    void intro(){
        String first = "John";
        String last = "Cena";
        String introduction = "Thank you" + first + " " + last + " let's play hangman!";
        assertEquals(introduction, hangman.intro(first, last));
    }
    @Test
    void currentScore() throws IOException {
        assertNotEquals(5, hangman.currHighScore());
    }
    @AfterEach
    void tearDown() {
    }
}