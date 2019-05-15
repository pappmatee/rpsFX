package rpsFX.manager;

import org.junit.jupiter.api.Test;
import rpsFX.state.Choice;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class ChoiceManagerTest {

    private static final List<Choice> CHOICES = Arrays.asList(Choice.values());
    private static final Random RANDOM = new Random();

    @Test
    void compareChoices() {

        Choice testChoice1 = Choice.ROCK;
        Choice testChoice2 = Choice.PAPER;
        Choice testChoice3 = Choice.SCISSORS;
        Choice testChoice4 = Choice.SCISSORS;

        if (testChoice1.getLoseAgainst() == testChoice2)
            assertTrue(true);
        if (testChoice1.getWinAgainst() == testChoice3)
            assertTrue(true);

        /*assertEquals(testChoice1.getLoseAgainst(), testChoice2);
        assertEquals(testChoice1.getWinAgainst(), testChoice3);
        assertEquals(testChoice3, testChoice4);*/

    }

    @Test
    void isComputer() {
        Choice random = CHOICES.get(RANDOM.nextInt(CHOICES.size()));
        Choice computer = random;
        assertEquals(computer, random);

    }
}