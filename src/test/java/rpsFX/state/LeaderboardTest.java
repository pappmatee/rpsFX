package rpsFX.state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeaderboardTest {

    Leaderboard testLB = new Leaderboard();

    @Test
    void getNickname() {
        testLB.setNickname("testPlayer");
        assertEquals(testLB.getNickname(), "testPlayer");
    }

    @Test
    void setNickname() {
        testLB.setNickname("testPlayer");
        assertEquals(testLB.nickname.get(), "testPlayer");
    }

    @Test
    void getScore() {
        testLB.setScore(0);
        assertEquals(testLB.getScore(), 0);
    }

    @Test
    void setScore() {
        testLB.setScore(0);
        assertEquals(testLB.score.get(), 0);
    }
}