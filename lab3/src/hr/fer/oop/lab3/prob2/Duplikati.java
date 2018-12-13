package hr.fer.oop.lab3.prob2;

public class Duplikati implements ISlicice{

	private SimpleHashtable pohrana;
	private Slicica kljuc;
	
	

	
	public int size() {
		return pohrana.size();
	}
	
	public boolean isFull() {
		return !pohrana.isEmpty();
	}
	
	
	public boolean isEmpty() {
		return pohrana.isEmpty();
	}
	
	
	public boolean add(Slicica s) {
		return pohrana.put(s.getRbr(), s.getNaziv());
	}
	
	
	public boolean remove(Slicica s) {
		if(pohrana.containsKey(s.getRbr()) && pohrana.containsValue(s.getNaziv())) {
			pohrana.remove(s.getRbr());
			return true;
		}
		return false;
	}
	
	
	public boolean contains(Slicica s) {
		return pohrana.containsKey(s.getRbr()) && pohrana.containsValue(s.getNaziv());
	}
	
	
	public void print() {
		
	}
	
}
