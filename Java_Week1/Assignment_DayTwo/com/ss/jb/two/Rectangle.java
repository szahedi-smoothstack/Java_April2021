/**
 * 
 */
package com.ss.jb.two;

/**
 * A Rectangle class that implements the Shape interface
 * 
 * @author Zahedi
 *
 */
public class Rectangle implements Shape {
	float height;
	float width;
	
	public Rectangle(double h, double w) {
		height = (float) h;
		width = (float) w;
	}
	
	@Override
	public float calculateArea() {
		return (long) this.height * this.width;
	}


	@Override
	public void display() {
		System.out.println("The area of the Rectangle is: " + this.calculateArea());
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Rectangle rec = new Rectangle(2, 6.5);
		rec.display();
		
	}
}
