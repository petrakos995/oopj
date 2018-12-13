package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.PlayingPosition;

/**
 * @author petra
 *
 */

public class FootballPlayer extends Person {
	private Integer playingSkill;
	private PlayingPosition playingPosition;
	
	/**
	 * Constructor
	 * it has default values 
	 */
	public FootballPlayer() {
		super();
		general();
	}
	
	/**
	 * Constructor with 2 params
	 * @param name of the player
	 * @param country  where he is from
	 */
	public FootballPlayer(String name, String country) { 
		super(name, country); 
		general(); 
	}
	
	/**
	 * constructor with 3 params
	 * @param name of the player
	 * @param country where he is from
	 * @param emotion 
	 */
	public FootballPlayer(String name, String country, Integer emotion) { 
		super(name, country, emotion); 
		general(); 
	}
	
	/**
	 * constructor with 5 params
	 * @param name of the player
	 * @param country where he is from
	 * @param emotion
	 * @param playingSkill 
	 * @param playingPosition
	 */
	public FootballPlayer(String name, String country, Integer emotion, Integer playingSkill, PlayingPosition playingPosition) {
		super(name, country, emotion); 
		if(playingPosition == null )
			playingPosition = Constants.DEFAULT_PLAYING_POSITION;
		this.playingPosition = playingPosition;
		if(playingSkill <= 0 || playingSkill > 100 ) {
			System.err.println("playingSkill is out of range [0-100], changing to default " + playingSkill);
			playingSkill = Constants.DEFAULT_PLAYING_SKILL;
		}
		this.playingSkill = playingSkill;
	}
	
	/**
	 * making function for general constructor when we don't change anything
	 */
	private void general() {
		this.playingSkill = Constants.DEFAULT_PLAYING_SKILL;
		this.playingPosition = Constants.DEFAULT_PLAYING_POSITION;
	}
	
	/**
	 * setter
	 * @param playingSkill
	 */
	public void setPlayingSkill(Integer playingSkill) { 
		this.playingSkill = playingSkill; 
	}

	/**
	 * setter
	 * @param playingPosition
	 */
	public void setPlayingPosition(PlayingPosition playingPosition) {
		this.playingPosition = playingPosition;
	}

	
	public PlayingPosition getPlayingPosition() {
		return playingPosition;
	}

	/**
	 * setter
	 * @return number of skills of the players
	 */
	public Integer getPlayingSkill() {
		return playingSkill;
	}
}
