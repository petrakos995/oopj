package hr.fer.oop.lab3.prob1;

import hr.fer.oop.lab3.pic.Picture;

/**
 * Simple Drawable implementation that draws a rectangle roughly centered 
 * centered in the given Picture object with sides parallel to the Picture
 * border.
 * <p>This Drawable implementation uses a simple pixel-by-pixel algorithm. To
 * avoid rounding problems this class is implemented using integer arithmetic
 * and should always draw a rectangle of the requested dimensions. Therefore 
 * the basic constructor takes integer arguments.
 * <p>The rectangle is drawn roughly in the middle of the picture - if the 
 * parity of the Picture's (in drawOnPicture method) and Rectangle's instances
 * don't match, the rectangle will be drawn with an extra empty line <b>before
 * </b> the shape itself.
 * <p>The rectangle is defined by two side lengths.No methods to access the 
 * base values are provided, but the class does allow overriding of the 
 * internally kept radius value. Inheriting classes should take care to keep 
 * the radius non-negative at all times (see the copy constructor).
 * 
 * 
 *
 */
public class Rectangle implements Drawable {

	/*
	 * Inheriting classes may need access to base values to implement  
	 * different drawing algorithms, as well as possibly more complex 
	 * operations.
	 */
	private int width, height;
	

	/**
	 * getter to see the width of the rectangle
	 * @return width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * setter for this function 
	 * @param width of the rectangle
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * getter to see the height of the rectangle
	 * @return height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * setter of the height of the rectangle
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * The basic constructor. If any of the side lengths is negative, an 
	 * IllegalArgumentException will be thrown.
	 * 
	 * @param width length of the horizontally drawn side
	 * @param heigth length of the vertically drawn side
	 */
	public Rectangle(int width, int heigth) {
		if( width >= 0 && height >= 0) {
			this.width = width;
			this.height = heigth;
		} else {
			throw new IllegalArgumentException("Can't instatiate rectangles with a negative side length");
		}
	}

	public Rectangle(Rectangle original) { this(original.width, original.height); }

	/* (non-Javadoc)
	 * @see hr.fer.oop.lab3.prob1.Drawable#drawOnPicture(hr.fer.oop.lab3.pic.Picture)
	 */
	@Override
	public void drawOnPicture(Picture pic) {
		for(int y = 0; y < pic.getHeight(); y++ ) {
			for(int x = 0; x < pic.getWidth(); x++ ) {
				if(sadrziTocku(x,y,pic)) {
					pic.turnPixelOn(x, y);					
				}
			}
		}		
	}

	/**
	 * function which returns true if the point is in the picture 
	 * @param x first coordinate of the point
	 * @param y second coordinate of the point
	 * @param pic the picture we are drawing on
	 * @return  boolean value of the said point in correlation to the given picture
	 */
	private boolean sadrziTocku(int x, int y, Picture pic) {
		int emptyHeight = pic.getHeight() / 2 - (getHeight())/ 2, emptyWidth = pic.getWidth() / 2 - (getWidth()) / 2;		
		return y >= emptyHeight && y < emptyHeight + getHeight() && x >= emptyWidth && x < emptyWidth + getWidth();
	}
	
	
	
	public static void main(String[] args) { 
		int [][] tests = new int[][] { 
			{5, 5, 4, 4}
			, {5, 5, 3, 3}
			, {5, 5, 2, 2}
			, {5, 5, 1, 1}
			, {5, 5, 0, 0}
			, {4, 4, 2, 2}
			, {4, 4, 3, 3}
			, {4, 4, 4, 4}
			, {4, 4, 5, 5}
			, {4, 4, 1, 3}
			, {4, 4, 2, 3}
			, {4, 4, 3, 3}
			, {4, 4, 4, 3}
			, {4, 4, 5, 3}
			, {4, 4, 2, 4}
			, {4, 4, 4, 2}
			, {150, 50, 15, 3}
			, {150, 50, 0, 0}
		};
		for(int[] test : tests) {
			System.out.println(new StringBuilder("Picture(w:")
					.append(Integer.toString(test[0]))
					.append(",h:")
					.append(Integer.toString(test[1]))
					.append("), Rectangle(w:")
					.append(Integer.toString(test[2]))
					.append(",h:")
					.append(Integer.toString(test[3]))
					.append("):")
					);
			Picture p = new Picture(test[0], test[1]);
			Rectangle r = new Rectangle(test[2], test[3]);
			r.drawOnPicture(p);
			p.renderImageToStream(System.out);

		}
	}

}
