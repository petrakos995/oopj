package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.PlayingPosition;
import hr.fer.oop.lab3.exceptions.FootballPlayerCreationException;
import hr.fer.oop.lab3.exceptions.FootballPlayerPlayingSkillException;

/**
 * Vježba za studente: dokumentirajte programski kod pisanjem smislenih Javadoc komentara (razred i metode).
 */
public class FootballPlayer extends Person {

    private int playingSkill = Constants.DEFAULT_PLAYING_SKILL;
    private PlayingPosition playingPosition = Constants.DEFAULT_PLAYING_POSITION;

    public FootballPlayer(){
        super();
    }

    public FootballPlayer(String name, String country, int emotion, int playingSkill, PlayingPosition playingPosition){
        super(name, country, emotion);

        setPlayingSkill(playingSkill);
        setPlayingPosition(playingPosition);
    }

    public void setPlayingSkill(int playingSkill){
    	try {
    		if (playingSkill >= Constants.MIN_PLAYING_SKILL && playingSkill <= Constants.MAX_PLAYING_SKILL)
    			this.playingSkill = playingSkill;
    		else
				throw(new FootballPlayerPlayingSkillException("Playing skill is not in the defined interval: ", Constants.MIN_PLAYING_SKILL, Constants.MAX_PLAYING_SKILL));
			} catch (FootballPlayerPlayingSkillException e) {
				e.printStackTrace();
			} finally {
				this.playingSkill = 25; // to nemas po default napisano u Constants
			}
    }

    public void setPlayingPosition(PlayingPosition playingPosition){
    	try {
    		if(playingPosition!=null)
    			this.playingPosition = playingPosition;
    		else
				throw(new FootballPlayerCreationException("Playing position can't be NULL. Set to GK."));
			} catch (FootballPlayerCreationException e) {
				e.printStackTrace();
			} finally {
				this.playingPosition = PlayingPosition.GK;
			}
    }

    public int getPlayingSkill() {
        return playingSkill;
    }

    public PlayingPosition getPlayingPosition() {
        return playingPosition;
    }
}
