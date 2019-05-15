package rpsFX.manager;

import rpsFX.state.Player;

/**
 * Class processing the result of the round.
 */
///CLOVER:OFF
public class RoundManager {

    /**
     * Returns the compared choices made by the players.
     * @param player choice made by the specific player
     * @param enemy choice made by the specific player
     * @return the compared choices made by the players
     */
    public static int processRound(Player player, Player enemy) {
        return ChoiceManager.compareChoices(player.getChoice(), enemy.getChoice());
    }
}
///CLOVER:ON
