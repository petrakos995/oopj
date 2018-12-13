package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;


public class Person {
	private String name;
	private String country;
	private Integer emotion;
	
	/**
	 * Default constructor
	 */
	public Person() {
		this.name= Constants.DEFAULT_PLAYER_NAME;
		this.country = Constants.DEFAULT_COUNTRY;
		this.emotion = Constants.DEFAULT_EMOTION;
	} 
	
	public Integer getEmotion() {
		return emotion;
	}

	/**
	 * constructor with 2 params
	 * @param name is the name of the player 
	 * @param country is the county where he came from 
	 */
	public Person(String name, String country) {
		this.name = name;
		this.country = country;
		this.emotion = Constants.DEFAULT_EMOTION;
	}
	
	/**
	 * constructor with 3 params
	 * @param name  name of the player
	 * @param country where he came from
	 * @param emotion 
	 */
	public Person(String name, String country, Integer emotion) {
		if(name == null)
			name = Constants.DEFAULT_PLAYER_NAME;
		this.name = name;
		if(country == null) 
			country = Constants.DEFAULT_COUNTRY;
		this.country = country;
		
		if(emotion < 0 || emotion > 100 ) {
			System.err.println("emotion is out of range [0-100], changing to default " + emotion);
			emotion = Constants.DEFAULT_EMOTION;
		}
		this.emotion = emotion;
	}

	
	
	/**getter
	 * @return  name of the player
	 */
	public String getName() {
		return name;
	}

	/**
	 * getter
	 * @return country where he lived at
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * setter
	 * @param emotion
	 */
	public void setEmotion(Integer emotion) {
		this.emotion = emotion;
	}
	
	@Override
    public boolean equals(Object o) {
        //return true;
		if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return !(country != null ? !country.equals(person.country) : person.country != null);

    }

}
