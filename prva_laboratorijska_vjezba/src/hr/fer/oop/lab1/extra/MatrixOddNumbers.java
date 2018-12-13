package hr.fer.oop.lab1.extra;

import java.util.Scanner;

public class MatrixOddNumbers {
	
	public static boolean neparan(Double x) {
		if(x % 2 == 0) {
			return false;
		}
		return true;
	}
	
	public static void ispis(int broj, int matrica[][]) {
		for(int i = 0; i < broj; i++) {
			for(int j=0; j<broj; j++) {
				System.out.print(matrica[i][j] + " ");
			}
			System.out.format("\n");
		}
	}
	
	public static void main(String[] args) {
		//double matrica[][] = new double[][];
		int n = Integer.parseInt(args[0]);
		int matrica[][] = new int[100][100];
		Scanner sc = new Scanner(System.in);
		double element = 0.0;
		
		int i=0;
		int j=0;
		
		while (i < n) {
			
			j = 0;
			while(j < n) {
				System.out.println("upisi element");
				element = sc.nextDouble();
				if(neparan(element)) {
					matrica[i][j]= 0;
				}
				else {
					matrica[i][j]= (int)element;
				}
				j++;
			}
			i++;
		}
		sc.close();
		ispis(n, matrica);
	}
}
