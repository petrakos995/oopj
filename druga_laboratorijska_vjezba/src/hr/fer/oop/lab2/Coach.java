package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.Formation;
import hr.fer.oop.lab2.welcomepack.ManageableTeam;
import hr.fer.oop.lab2.welcomepack.Manager;
import hr.fer.oop.lab2.welcomepack.PlayingPosition;

/**
 * @author petra
 *
 */
public class Coach extends Person implements Manager{
	private Integer coachingSkill;
	private Formation formation;
    private ManageableTeam managingTeam;

	
	/**
	 * Constructor
	 * it has default values 
	 */
	public Coach(){
		super();
		general();
	}
	
	/**
	 * Constructor with 2 params
	 * @param name of the player
	 * @param country  where he is from
	 */
	public Coach(String name, String country) { 
		super(name, country); 
		general(); 
	}
	
	/**
	 * constructor with 3 params
	 * @param name of the player
	 * @param country where he is from
	 * @param emotion 
	 */
	public Coach(String name, String country, Integer emotion) { 
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
	public Coach(String name, String country, Integer emotion, Integer coachingSkill, Formation formation) {
		super(name, country, emotion); 
		this.formation = formation;
		if(coachingSkill <= 0 || coachingSkill > 100 ) {
			System.err.println("coachingSkill is out of range [0-100], changing to default" + coachingSkill);
			coachingSkill = Constants.DEFAULT_COACHING_SKILL;
		}
		this.coachingSkill = coachingSkill;
	}
	
	/**
	 * making function for general constructor when we don't change anything
	 */
	private void general() {
		this.coachingSkill = Constants.DEFAULT_COACHING_SKILL;
		this.formation= Constants.DEFAULT_FORMATION;
	}

	
	/**
	 * setter 
	 * @param coachingSkill
	 */
	public void setCoachingSkill(Integer coachingSkill) {
		this.coachingSkill = coachingSkill;
	}
	
	/**
	 * setter
	 * @param formation
	 */
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	
	@Override
	public void pickStartingEleven() {
		int defence = managingTeam.getFormation().getNoDF();
		int attack = managingTeam.getFormation().getNoFW();
		int middle = managingTeam.getFormation().getNoDF();
		int goal = managingTeam.getFormation().getNoGK();
				
		pickTeam(defence, PlayingPosition.DF);
		pickTeam(attack, PlayingPosition.FW);
		pickTeam(middle, PlayingPosition.MF);
		pickTeam(goal, PlayingPosition.GK);
	}
	
	private void pickTeam(int number, PlayingPosition pos) {
		for(FootballPlayer f : managingTeam.getRegisteredPlayers().getPlayers()) {
			if(number > 0 && f != null && f.getPlayingPosition() == pos) {
				managingTeam.addPlayerToStartingEleven(f);
				number--;
			}
		}
	}

	public Integer getCoachingSkill() {
		return coachingSkill;
	}

	public Formation getFormation() {
		return formation;
	}

	public ManageableTeam getManagingTeam() {
		return managingTeam;
	}

	@Override
	public void forceMyFormation() {
		managingTeam.setFormation(formation);
	}
	
	
	@Override
	public void setManagingTeam(ManageableTeam team) {
		if(team != null)
			managingTeam = team;
		else 
			System.err.println("team is null");

	}


}
