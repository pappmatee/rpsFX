package rpsFX.state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    Player testPlayer = new Player("testPlayer");

    @Test
    void getName() {
        assertEquals(testPlayer.getName(), "testPlayer");
    }

    @Test
    void setName() {
        testPlayer.setName("testPlayer2");
        assertEquals(testPlayer.getName(), "testPlayer2");
    }

    @Test
    void getChoice() {
        testPlayer.setChoice(Choice.ROCK);
        assertEquals(testPlayer.getChoice(), Choice.ROCK);
    }

    @Test
    void setChoice() {
        testPlayer.setChoice(Choice.ROCK);
        assertEquals(testPlayer.getChoice(), Choice.ROCK);
    }

    @Test
    void getScore() {
        testPlayer.setScore(0);
        assertEquals(testPlayer.getScore(), 0);
    }

    @Test
    void setScore() {
        testPlayer.setScore(0);
        assertEquals(testPlayer.getScore(), 0);
    }
}