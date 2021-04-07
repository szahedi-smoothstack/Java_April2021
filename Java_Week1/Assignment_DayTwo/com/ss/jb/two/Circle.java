/**
 * 
 */
package com.ss.jb.two;

import java.lang.Math;

/**
 * @author Zahedi
 *
 */
public class Circle implements Shape {
	long radius;
	
	public Circle(long rad) {
		radius = (long) rad;
	}
	
	@Override
	public float calculateArea() {
		return (float) ( Math.PI * Math.pow(this.radius, 2));
	}
	
	public void display() {
		System.out.println("The area of the Circle is: " + this.calculateArea());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Circle circle = new Circle(4);
		circle.display();

	}



}
