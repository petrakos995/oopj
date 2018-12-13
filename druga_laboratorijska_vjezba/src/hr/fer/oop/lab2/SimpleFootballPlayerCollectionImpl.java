package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.SimpleFootballPlayerCollection;

public class SimpleFootballPlayerCollectionImpl implements SimpleFootballPlayerCollection{
	private FootballPlayer[] players;
	
	/**
	 * constructor 
	 * @param size is the size of the collection
	 */
	public SimpleFootballPlayerCollectionImpl(Integer size) { 
		players = new FootballPlayer[size]; 
	}
	
	
	@Override
	public boolean add(FootballPlayer player) { 
		if(contains(player) || player == null) return false;
		
		if(size() < getMaxSize() ) {
			for(int i = 0; i < players.length; i++){
				if(players[i] == null) {
					players[i] = player;
					return true;
				}
			}
		}
		return false;
	}
		
	
	@Override
	public int calculateEmotionSum() {
		int sumEmotion = 0;
		for(FootballPlayer p : players) {
			if(p != null) {
				sumEmotion += p.getEmotion();
			}
		}
		return sumEmotion;
	}
	
	
	@Override
	public int calculateSkillSum() {
		int sumSkill = 0;
		for(FootballPlayer p : players) {
			if(p != null) {
				sumSkill += p.getPlayingSkill();
			}
		}
		return sumSkill;
	}
	
	
	@Override
	public void clear() {
		for(int i = 0; i < getMaxSize(); i++) {
			players[i] = null;
		}
	}
	
	@Override
	public boolean contains(FootballPlayer player) {
		//System.out.println(size());
		for(FootballPlayer p : players) {
			
			if(p != null )
				if(p.equals(player))
					return true;
		}
		return false;
	}
	
	@Override
	public int getMaxSize() {
		return players.length;
	}
	
	@Override
	public FootballPlayer[] getPlayers() {
		return players;
	}
	
	@Override
	public int size() {
		int size = 0;
		for(FootballPlayer p : players) {
			if(p != null) {
				size++;
			}
		}
		return size;
	}

}
