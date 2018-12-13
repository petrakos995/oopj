package hr.fer.oop.lab1.prob1;

import java.util.Scanner;

public class Rectangle {
	public static void main(String[] args) {
		if(args.length == 1 || args.length > 2) throw new IllegalArgumentException("Unesen pogresan broj argumenata");
		int i = 0;
		double sirina = 0;
		double visina = 0;
		Scanner sc = new Scanner(System.in);
		if(args.length == 0) {
			while(true) {
				System.out.println("unesite parametar:");
				String scan = sc.nextLine().trim();
				if(scan.isEmpty()) {
					System.out.println("ovo polje ne moze ostat prazno");
					continue;
				}
				if(Double.parseDouble(scan) < 0) {
					System.out.println("unesen megativan broj, unesite ponovo parametar:");
					continue;
				}
				if( i == 0) {
					sirina = Double.parseDouble(scan);
					i++;
				}
				else {
					visina = Double.parseDouble(scan);
					break;
				}
			}
		}
		else {
			sirina =  Double.parseDouble(args[0]);
			visina =  Double.parseDouble(args[1]);
		}
		sc.close();
		System.out.println("sirina pravokutnika je "+ sirina);
		System.out.println("visina pravokutnika je "+ visina);

		System.out.println("opseg pravokutnika je "+ 2*sirina+2*visina);
		System.out.println("povrsina pravokutnika je "+ sirina*visina);
	}
}
