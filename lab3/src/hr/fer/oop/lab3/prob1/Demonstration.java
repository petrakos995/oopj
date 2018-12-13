package hr.fer.oop.lab3.prob1;

import hr.fer.oop.lab3.pic.Picture;

/**
 * 
 *
 */
public class Demonstration {

	public static void main(String[] args) {
		Picture p = new Picture(100, 50);
		Drawable[] ds = { new Rectangle(40, 40)
				, new RectangleFast(90, 6)
				, new Circle(25)
				, null
				, new EquilateralTriangle(25)
				, new EquilateralTriangleFast(49) 
		};
		ds[3] = new CircleFast((Circle)ds[2]);
		
		for(Drawable d : ds) { 
			p = new Picture(100, 50);
			d.drawOnPicture(p);
			p.renderImageToStream(System.out);
		}
		//p.renderImageToStream(System.out);

	}

}
