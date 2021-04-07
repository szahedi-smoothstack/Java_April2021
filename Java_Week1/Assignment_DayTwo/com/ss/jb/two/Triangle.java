/**
 * 
 */
package com.ss.jb.two;

import java.lang.Math;

/**
 * A class for Triangle which implements the Shape Interface
 * There are several ways to calculate the area of a triangle, depending on what aspects of the triangle are known.
 * So for this, I just assumed that all the sides were supplied, and then used Heron's Formula to calculate area.
 * A right triangle would have been easier to calculate.
 * 
 * @author Zahedi
 *
 */
public class Triangle implements Shape{
	float sideA;
	float sideB;
	float sideC;
	
	public Triangle(float a, float b, float c) {
		sideA = (float) a;
		sideB =(float) b;
		sideC = (float) c;
	}

	// Using Heron's Formula to calculate area, given the lengths of all sides
	@Override
	public float calculateArea() {
		float s = (sideA + sideB + sideC) / 2;
		float heronArea = (float) Math.pow((s*(s-sideA)*(s-sideB)*(s-sideC)), 0.5);
		return heronArea;
	}

	@Override
	public void display() {
		System.out.println("The area of the Triangle is: " + this.calculateArea());		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Triangle tri = new Triangle(3, 4, 5);
		tri.display();
		
	}
}
