import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class hangmanTest {
    hangman game;

    @BeforeEach
    void setUp() {
        game = new hangman();
    }

    @AfterEach
    void tearDown() {
    }
}