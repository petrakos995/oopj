package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab3.exceptions.FootballPlayerEmotionException;

/**
 * Vježba za studente: dokumentirajte programski kod pisanjem smislenih Javadoc komentara (razred i metode).
 */
public abstract class Person {
    private String name = Constants.DEFAULT_PLAYER_NAME;
    private String country = Constants.DEFAULT_COUNTRY;
    private int emotion = Constants.DEFAULT_EMOTION;

    public Person(String name, String country, int emotion){
        if(name!=null)
            this.name = name;
        else System.err.println("Ime je null! :(");

        if(country!=null)
            this.country = country;
        else System.err.println("Drzava je null! :(");

        setEmotion(emotion);
    }

    public Person(){}

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getEmotion() {
        return emotion;
    }

    public void setEmotion(int emotion){
    	try {
    		if(emotion>=Constants.MIN_EMOTION && emotion<=Constants.MAX_EMOTION)
    			this.emotion = emotion;
    		else
    			throw(new FootballPlayerEmotionException("Emotion is not in the defined interval: ", Constants.MIN_EMOTION, Constants.MAX_EMOTION));
    	} catch (FootballPlayerEmotionException e) {
			e.printStackTrace();
		} finally {
			this.emotion = 25;
		}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return !(country != null ? !country.equals(person.country) : person.country != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
}
