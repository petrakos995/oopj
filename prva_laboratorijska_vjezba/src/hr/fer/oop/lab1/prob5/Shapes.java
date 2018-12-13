package hr.fer.oop.lab1.prob5;

public class Shapes {
	public static void kriz() {
		System.out.println("+--------+");
	}
	
	public static void dole() {
		System.out.println("\\        /\n \\______/");	
	}
	
	public static void gore() {
		System.out.println("  ______  \n /      \\ \n/        \\");
	}
	
	public static void sat() {
		kriz();
		dole();
		kapa();
	}
	
	public static void oblik() {
		gore();
		dole();
	}
	
	public static void salica() {
		dole();
		kriz();
	}

	public static void kapa() {
		gore();
		kriz();
	}
	
	public static void main(String[] args) {
		sat();
		oblik();
		salica();
		kapa();
	}
}
