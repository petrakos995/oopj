package hr.fer.oop.lab1.prob3;

public class PrimeNumbers {
	public static boolean isPrime(double x) {
		
		for(int j = 2; j*j <= x; j++) {
			if( x % j == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int i = 1;
		double broj=3;
		System.out.println(i + ". 2.0");
		while( i < n) {
			if( isPrime(broj) ) {
				i++;
				System.out.println(i + ". " + broj);
			}
			broj++;
		}
	}
}
