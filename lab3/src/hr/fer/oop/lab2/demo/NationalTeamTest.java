package hr.fer.oop.lab2.demo;

import hr.fer.oop.lab2.NationalTeam;

public class NationalTeamTest {

	public static void main(String[] args){

		NationalTeam defaultTeam = new NationalTeam();
		
		System.out.println(defaultTeam.getFormation());
		
		System.out.println("Creating second team:");
		
		@SuppressWarnings("unused")
		NationalTeam team2 = new NationalTeam(null , null, null);

	}

}
