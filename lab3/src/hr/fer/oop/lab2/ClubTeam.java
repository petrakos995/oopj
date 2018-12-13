package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.Formation;

/**
 * Vježba za studente: dokumentirajte programski kod pisanjem smislenih Javadoc komentara (razred i metode).
 */
public class ClubTeam extends Team {
    private int reputation = Constants.DEFAULT_REPUTATION;

    public ClubTeam(String name, Formation formation, int reputation) {
        super(name, formation, Constants.MAX_NO_PLAYERS_CLUB);
        setReputation(reputation);
    }

    public ClubTeam(){
        super(Constants.MAX_NO_PLAYERS_CLUB);
    }

    public void setReputation(int reputation) {
        if (reputation >= Constants.MIN_REPUTATION && reputation <= Constants.MAX_REPUTATION)
            this.reputation = reputation;
        else System.err.println("Reputacija je izvan raspona! :(");
    }

    public int getReputation() {
        return reputation;
    }

    @Override
    public boolean registerPlayer(FootballPlayer player) {
        if (player == null)
            return false;
        if (player.getPlayingSkill() < reputation || getRegisteredPlayers().size() >= getRegisteredPlayers().getMaxSize())
            return false;

        getRegisteredPlayers().add(player);
        return true;
    }

    @Override
    public double calculateRating() {
        return Constants.THIRTY_PERCENT * getRegisteredPlayers().calculateEmotionSum() + Constants.SEVENTY_PERCENT * getRegisteredPlayers().calculateSkillSum();
    }
}
