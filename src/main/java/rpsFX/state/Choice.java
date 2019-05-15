package rpsFX.state;

/**
 * Enum representing the three choices.
 */
public enum Choice {
    /**
     * Choice ROCK.
     */
    ROCK,
    /**
     * Choice PAPER.
     */
    PAPER,
    /**
     * Choice SCISSORS.
     */
    SCISSORS;

    private Choice loseAgainst;
    private Choice winAgainst;

    static {
        ROCK.loseAgainst = PAPER;
        PAPER.loseAgainst = SCISSORS;
        SCISSORS.loseAgainst = ROCK;

        ROCK.winAgainst = SCISSORS;
        PAPER.winAgainst = ROCK;
        SCISSORS.winAgainst = PAPER;
    }


    /**
     * Returns the choice that lose against the choice made by player.
     * @return loseAgainst
     */
    public Choice getLoseAgainst() {
        return loseAgainst;
    }

    /**
     * Returns the choice that win against the choice made by player.
     * @return winAgainst
     */
    public Choice getWinAgainst() {
        return winAgainst;
    }

}
