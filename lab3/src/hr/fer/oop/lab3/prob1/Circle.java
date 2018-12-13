package hr.fer.oop.lab3.prob1;

import hr.fer.oop.lab3.pic.Picture;

/**
 * Simple Drawable implementation that draws a circle roughly 
 * centered in the given Picture object. 
 * <p>This Drawable implementation uses a simple pixel-by-pixel algorithm.
 * Simple roundings are used when converting from reals to integers, so edge 
 * effects are observable, especially when drawing small shapes.
 * <p>No methods to access the radius are provided, but the class
 * does allow overriding of the internally kept radius value.
 * Inheriting classes should take care to keep the radius non-negative
 * at all times (see the copy constructor).
 * 
 * The class supplies a main method with some simple functionality tests.
 * 
 *
 */
public class Circle implements Drawable {	
	
	/*
	 * Inheriting classes may need access to base values to implement  
	 * different drawing algorithms, as well as possibly more complex 
	 * operations.
	 */
	private int r;

	/**
	 * getter for the radius in circle 
	 * @return radius of the circle
	 */
	public int getR() {
		return r;
	}

	/**
	 * setter for the radius in circle
	 * @param r is the said radius
	 */
	public void setR(int r) {
		this.r = r;
	}

	/**
	 * Instantiating with a negative radius is not allowed, the  constructor 
	 * will throw a java.lang.IllegalArgumentException if called with a 
	 * negative constructor.  
	 * 
	 * @param radius The circle's radius
	 */
	public Circle(int radius) { 
		if(radius >=0 ) {
			this.r = radius;
		}
		else 
			throw new IllegalArgumentException("Tried instantiating a negative radius circle");
	}

	/**
	 * Copy constructor won't perform any checks. The original object is 
	 * assumed to be consistent (the radius should be non-negative).
	 * 
	 * @param original The original Circle object.
	 */
	public Circle(Circle original) { 
		this.r = original.getR();
	}

	@Override
	public void drawOnPicture(Picture pic) {
		for( int y = 0; y < pic.getHeight(); y++ ) {
			for(int x = 0; x < pic.getWidth(); x++) {
				if(sadrziTocku(x,y,pic)){
					pic.turnPixelOn(x,  y);
				}
			}
		}
	}

	private boolean sadrziTocku(int x, int y, Picture pic) {
		double p1 = Math.pow(x-pic.getWidth()/2, 2);
		double p2 = Math.pow(y-pic.getHeight()/2, 2);
		return p1+p2 < Math.pow(getR(), 2);
	}
	
	/* 
	 * main method used for simple testing
	 */

	public static void main(String[] args) { 
		int[][] tests = { 
				 {5, 5, 0}
				, {5, 5, 1}
				, {5, 5, 2}
				, {5, 5, 3} // D > pic.get[Height|Width]()
				, {80, 50, 21}
				, {80, 50, 22}
				, {80, 50, 23}
				, {80, 50, 24}
				, {80, 50, 25} // D >= pic.getWidth()
				, {80, 50, 26}
				, {80, 50, 1}
				, {80, 50, 0}
		};

		for(int[] test : tests) { 
			System.out.println(new StringBuilder("Picture(w:")
					.append(test[0])
					.append(", h:")
					.append(test[1])
					.append("), Circle(r:")
					.append(test[2])
					.append("):"));
			try {
				Picture p = new Picture(test[0], test[1]);
				Circle c = new Circle(test[2]);
				c.drawOnPicture(p);
				p.renderImageToStream(System.out);
			}
			catch(Exception e) { 
				e.printStackTrace();
			}
		}

	}

}
