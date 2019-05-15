package rpsFX.state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChoiceTest {

    @Test
    void getLoseAgainst() {
        assertEquals(Choice.ROCK.getLoseAgainst(), Choice.PAPER);
    }

    @Test
    void getWinAgainst() {
        assertEquals(Choice.ROCK.getWinAgainst(), Choice.SCISSORS);
    }
}