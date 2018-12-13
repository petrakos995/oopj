package hr.fer.oop.lab1.prob2;

public class Roots {
	public static void print(Double re, Double im, Integer br) {
		
		System.out.format("%d) %.2f%c%.2fi\n",br , re, (im>0) ? '+' : ' ', im);
	}
	
	
	public static void main(String[] args) {
		double re= Double.parseDouble(args[0]);
		double im = Double.parseDouble(args[1]);
		double korijen = Double.parseDouble(args[2]);
		double r= Math.sqrt(re*re + im*im);
		double angle = Math.atan2(im, re);
		
		double rezultatRealni;
		double rezultatImaginarni;
		
		for(int i =1; i <= korijen; i++) {
			rezultatRealni = Math.pow(r, Math.pow(korijen, -1))*Math.cos((angle + 2*i*Math.PI)/korijen);
			rezultatImaginarni = Math.pow(r, Math.pow(korijen, -1))*Math.sin((angle+ 2*i*Math.PI)/korijen);
			print(rezultatRealni, rezultatImaginarni, i );
		}
	}
}
