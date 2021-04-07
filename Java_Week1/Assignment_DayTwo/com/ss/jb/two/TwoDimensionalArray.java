/**
 * 
 */
package com.ss.jb.two;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A class to find the max number in an array and show it's position
 * 
 * @author Zahedi
 *
 */
public class TwoDimensionalArray {
	/*
	 * There were no instructions about what array to use, so I am making a 3x3 array and filling it with random ints
	 * between 0 and 50
	*/
	int[][] array = new int[3][3];
	
	public TwoDimensionalArray() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				array[i][j] = ThreadLocalRandom.current().nextInt(0, 51);
			}
		}
	}
	
	public void findMax() {
		int row = 0;
		int col = 0;
		int max = array[0][0];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (array[i][j] > max) {
					max = array[i][j];
					row = i;
					col = j;
				}
			}
		}
		
		System.out.println("The max number in the array is: " + max);
		System.out.println("The max number in the " + row + " row.");
		System.out.println("The max number in the " + col + " col.");
	}
	
	public void display() {
		for (int[] row : this.array) {
			System.out.println(Arrays.toString(row));
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TwoDimensionalArray arr = new TwoDimensionalArray();
		
		arr.display();
		arr.findMax();
		
		
		

	}

}
