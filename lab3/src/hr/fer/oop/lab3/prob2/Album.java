package hr.fer.oop.lab3.prob2;

import java.util.TreeSet;


public class Album extends RuntimeException implements ISlicice{

	private TreeSet<Slicica> pohrana;
	private int kolicina;
	
	
	public Album(int i) {
		kolicina = i; 		
	}
	
	public int size() {
		return kolicina + pohrana.size();
	}
	
	public boolean isFull() {
		try {
    		if (kolicina > 0)
    			return false;
    		else
				throw(new IllegalStateException("Album is full."));
			} catch (Exception e) {
				e.printStackTrace();
			}
		return true;
	}
	
	
	public boolean isEmpty() {
		return pohrana.isEmpty();
	}
	
	
	public boolean add(Slicica s) {
		if(kolicina > 0 && contains(s)){
			kolicina--;
			pohrana.add(s);
			return true;
		}
		return false;
	}
	
	
	public boolean remove(Slicica s) {
		if(pohrana.contains(s)) {
			pohrana.remove(s);
			return true;
		}
		return false;
	}
	
	
	public boolean contains(Slicica s) {
		return pohrana.contains(s);
	}
	
	
	public void print() {
	}
	

}
