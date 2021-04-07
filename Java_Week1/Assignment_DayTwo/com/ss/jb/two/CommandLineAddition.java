/**
 * 
 */
package com.ss.jb.two;

import java.lang.NumberFormatException;

/**
 * Returns the sum of command line arguments
 * 
 * @author szahedi
 *
 */
public class CommandLineAddition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 0;
		int badArguments = 0;
		
		for (String s : args) {
			try {
				sum += Integer.parseInt(s);
			} catch (NumberFormatException e) {
				badArguments++;
				continue;
			}
		}
		
		System.out.println("The sum of the arguments is: " + sum);
		
		if (badArguments == 1) {
			System.out.println("1 argument was skipped.");
		} else {
			System.out.println(badArguments +  " arguments were skipped.");
		}

	}

}
