package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.PlayingPosition;
import hr.fer.oop.lab2.SimpleFootballPlayerCollectionImpl;
import hr.fer.oop.lab2.FootballPlayer;
import hr.fer.oop.lab2.welcomepack.SimpleFootballPlayerCollection;

public class SearchUtil {

	
	public static SimpleFootballPlayerCollection retriveAboveMedianSkillPlayers( SimpleFootballPlayerCollection players) {
		double medijan = (double) players.size();
		int ceil = (int) Math.ceil(medijan / 2);
		
		int br = 0;
		for(FootballPlayer p : players.getPlayers()) {
			br++;
			if(br == ceil) {
				br = p.getPlayingSkill();
				break;
			}
		}
		SimpleFootballPlayerCollection collection = new SimpleFootballPlayerCollectionImpl(Constants.MAX_NO_PLAYERS_CLUB);
		for(FootballPlayer p : players.getPlayers()) {
			if(p != null) {
				if(br < p.getPlayingSkill())
					collection.add(p);
			}
		}
		return collection;
	}

	public static FootballPlayer retrieveLowSkilledPlayer(SimpleFootballPlayerCollection players, PlayingPosition playingPos) {
		FootballPlayer ret = null;
		int vje = 100;
		for(FootballPlayer p : players.getPlayers()) {
			if(p != null ) {
				if(p.getPlayingPosition().equals(playingPos)) {
					if( vje > p.getPlayingSkill()) {
						vje = p.getPlayingSkill();
						ret = p;
					}
				}
			}
		}
		return ret;
	}
	
	public static SimpleFootballPlayerCollection retirevePlayingPositionPlayers (SimpleFootballPlayerCollection players, PlayingPosition playingPos) {
		SimpleFootballPlayerCollection collection = new SimpleFootballPlayerCollectionImpl(Constants.MAX_NO_PLAYERS_CLUB);
		for(FootballPlayer p : players.getPlayers()) {
			if(p != null) {
				if(p.getPlayingPosition() == playingPos) {
					collection.add(p);
				}
			}
		}
		return collection;
	}
}
