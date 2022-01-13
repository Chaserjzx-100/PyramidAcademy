import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Project2Test {

    @BeforeEach
    void setUp(){
        Project2 object = new Project2();
    }

    @Test
    void message() {
        String msg = "Hello! What is your first name?";
        assertEquals(Project2.message().getClass(), String.class);
        assertEquals(Project2.message(), msg);
    }

    @Test
    void name() {
        Project2 guessingGame = new Project2();
        String player = "Devan";
        String newplayer = guessingGame.name(player);
        assertTrue(newplayer.contains(player));
        assertEquals(Project2.name(player).getClass(), String.class);

    }

    @Test
    void randomNum() {
        Project2 game = new Project2();
        int num = game.randomNum();
        assertNotEquals(num , 21);
    }
}