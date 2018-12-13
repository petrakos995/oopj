package hr.fer.oop.lab1.prob4;

public class PrimeFactorization {
	
	public static boolean isPrime(double x) {
		for(int j = 2; j*j <= x; j++) {
			if( x % j == 0) {
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		double broj = Double.parseDouble(args[0]);
		int counter = 1;
		for (int i = 2; i <= broj; i++) {
			if (isPrime(i)) {
				while(broj % i == 0) {
					System.out.println( counter +". " + i);
					counter++;
					broj /= i;
				}
			}
			if(broj == 1) {
				break;
			}
		}
	}
}
