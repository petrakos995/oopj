package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.Formation;

public class NationalTeam extends Team{
	private String Country;
	
	/**
	 * Default constructor 
	 * goes to super class with default number of registered players
	 */
	public NationalTeam() {
		super(Constants.MAX_NO_PLAYERS_NATIONAL);
		Country = Constants.DEFAULT_COUNTRY;
	}
	
	/**
	 * constructor with everything written 
	 * @param name of the club
	 * @param formation how they play
	 * @param Country where are they from
	 */
	public NationalTeam(String name, Formation formation, String Country) {
		super(name, formation, Constants.MAX_NO_PLAYERS_NATIONAL);
		this.Country = Country;
	}
	
	
	
	/**
	 * getters 
	 * @return name of the country the player is from
	 */
	public String getCountry() {
		return Country;
	}

	@Override 
	public double calculateRating() {
		//double sum = getRegisteredPlayers().calculateSkillSum()*0.3 + 0.7*getRegisteredPlayers().calculateEmotionSum();
		return getRegisteredPlayers().calculateSkillSum()*Constants.THIRTY_PERCENT + Constants.SEVENTY_PERCENT*getRegisteredPlayers().calculateEmotionSum();
	}
	
	@Override
	public boolean registerPlayer(FootballPlayer player) {
		if(getCountry().equals(player.getCountry())) {
			return getRegisteredPlayers().add(player);
		}
		return false;
	}

}
