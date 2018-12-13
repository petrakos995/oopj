package hr.fer.oop.lab3.prob2;

import java.util.Set;
import java.util.TreeSet;

public class Paketic{
	
	private TreeSet<Slicica> pohrana;
	
 
	public Paketic() {
		int i =5;
		while(i>0) {
			i--;
			Slicica slic = new Slicica();
			pohrana.add(slic);
		}
	}
	
	public int size() {
		return pohrana.size();
	}
	
}
