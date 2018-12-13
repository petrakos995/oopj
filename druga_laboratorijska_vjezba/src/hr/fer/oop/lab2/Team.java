package hr.fer.oop.lab2;

/**
 * @author petra
 *
 */
import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.Formation;
import hr.fer.oop.lab2.welcomepack.ManageableTeam;
import hr.fer.oop.lab2.welcomepack.SimpleFootballPlayerCollection;

public abstract class Team implements ManageableTeam{
	private String name;
	private Formation formation;
	private SimpleFootballPlayerCollection registeredPlayers;
	private SimpleFootballPlayerCollection startingEleven;
	
	
	/**
	 * default constructor
	 */
	public Team() {
		this.name = Constants.DEFAULT_TEAM_NAME;
		this.formation = Constants.DEFAULT_FORMATION;
		startingEleven = new SimpleFootballPlayerCollectionImpl(Constants.STARTING_ELEVEN_SIZE);
		
	}
	
	
	/**
	 * Constructor with all params made
	 * @param name of the club
	 * @param formation how they play
	 * @param numberRegistered size of the registered team
	 */
	public Team(String name, Formation formation,Integer numberRegistered ) {
		this.name = name;
		this.formation = formation;
		startingEleven = new SimpleFootballPlayerCollectionImpl(Constants.STARTING_ELEVEN_SIZE);
		registeredPlayers = new SimpleFootballPlayerCollectionImpl(numberRegistered);
	}
	
	/**
	 * constructor with new size for the club
	 * @param numberRegistered is the size of the club
	 */
	public Team(Integer numberRegistered) {
		this.name = Constants.DEFAULT_TEAM_NAME;
		this.formation = Constants.DEFAULT_FORMATION;
		startingEleven = new SimpleFootballPlayerCollectionImpl(Constants.STARTING_ELEVEN_SIZE);
		registeredPlayers = new SimpleFootballPlayerCollectionImpl(numberRegistered);
	}
	
	@Override
	public boolean addPlayerToStartingEleven(FootballPlayer player) {
		if(isPlayerRegistered(player) && startingEleven.size() < Constants.STARTING_ELEVEN_SIZE ) {
			startingEleven.add(player);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isPlayerRegistered(FootballPlayer player) {
		return registeredPlayers.contains(player);
	}
	
	@Override
	public SimpleFootballPlayerCollection getRegisteredPlayers() {
		return registeredPlayers;
	}
	
	@Override
	public SimpleFootballPlayerCollection getStartingEleven() {
		return startingEleven;
	}
	
	@Override
	public void setFormation(Formation formation) {
		if(formation == null)
			System.err.println("formation is null");
		else 
			this.formation = formation;
	}
	
	
	/**
	 * getteri
	 * @return name of the team
	 */
	public String getName() {
		return name;
	}

	

	@Override
	public Formation getFormation() {
		return formation;
	}

	@Override
	public void clearStartingEleven() {
		startingEleven.clear();
	}

}
