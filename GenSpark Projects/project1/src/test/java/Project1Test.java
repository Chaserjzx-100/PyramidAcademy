import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Project1Test {

    @BeforeEach
    void setUp(){
        Project1 object = new Project1();
    }

    @Test
    void message() {
        String intro = "You are in a land full of dragons. In front of you, you see two caves." +
                " In one cave, the dragon is friendly and will share his treasure with you. The other dragon" +
                "is greedy and hungry and will eat you on sight. Which cave will you go into? 1 or 2?";;
        assertEquals(Project1.message().getClass(), String.class);
        assertEquals(Project1.message(), intro);
    }

    @Test
    void cave1() {
        String dragon1 = "You approach the cave... It is dark and spooky... A large dragon jumps out in front of you!" +
                " He opens his jaws and... Sets you ablaze with his fire!!";
        assertEquals(Project1.cave1().getClass(), String.class);
        assertEquals(Project1.cave1(), dragon1);
    }

    @Test
    void cave2() {
        String dragon2 = "You approach the cave... It is dark and spooky... A large dragon jumps out in front of you!" +
                " He opens his jaws and... Asks you if you would like to stay for dinner. Congratulations, you got lucky!";;
        assertEquals(Project1.cave2().getClass(), String.class);
        assertEquals(Project1.cave2(), dragon2);
    }
}