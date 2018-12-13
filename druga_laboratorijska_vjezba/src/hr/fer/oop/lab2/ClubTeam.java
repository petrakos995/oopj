package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.Formation;

public class ClubTeam extends Team {
	private Integer reputation;
	
	/**
	 * default constructor
	 */
	public ClubTeam() {
		super(Constants.MAX_NO_PLAYERS_CLUB);
		this.reputation = Constants.DEFAULT_REPUTATION;
	}
	/**
	 * constructor with everything written
	 * @param name of the club
	 * @param formation how they play
	 * @param reputation their reputation on the field
	 */
	public ClubTeam(String name, Formation formation, Integer reputation) {
		super(name, formation, Constants.MAX_NO_PLAYERS_CLUB);
		if(reputation <= 0 || reputation > 100 || reputation == null) {
			System.err.println("reputation is out of range [0-100], changing to default" + reputation);
			reputation = Constants.DEFAULT_REPUTATION;
		}
		this.reputation = reputation;
	}
	
	
	public Integer getReputation() {
		return reputation;
	}

	public void setReputation(Integer reputation) {
		if(reputation <=0 || reputation > 100 || reputation == null)
			System.err.println("reputation is out of range [0-100], changing to default  " + reputation);
		else
			this.reputation = Constants.DEFAULT_REPUTATION;
	}

	
	
	@Override 
	public double calculateRating() {
		double sum = getRegisteredPlayers().calculateSkillSum()*0.7 + 0.3*getRegisteredPlayers().calculateEmotionSum();
		return sum;
	}
	
	
	@Override
	public boolean registerPlayer(FootballPlayer player) {
		if( reputation <= player.getPlayingSkill() && getRegisteredPlayers().size() <= getRegisteredPlayers().getMaxSize())  {
			getRegisteredPlayers().add(player);
			return true;
		}
		return false;
	}
	
    	
}
