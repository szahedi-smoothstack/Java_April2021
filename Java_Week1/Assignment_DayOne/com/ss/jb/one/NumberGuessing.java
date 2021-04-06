/**
 * 
 */
package com.ss.jb.one;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.Math;
import java.util.InputMismatchException;

/**
 * @author szahedi
 *
 */
public class NumberGuessing {

	/**
	 *  A number guessing game
	 *  
	 * @param args
	 */
	
	public static int input;
	
	public static boolean checkGuess(int guess, int answer) {
		
		if ( Math.abs(answer - guess) <= 10 ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("I am picking a number between 1 - 100.");
		System.out.println("You have 5 chances to guess within +/- 10 of the number");
		System.out.println("Let's being.");
		
		int randomNumber = ThreadLocalRandom.current().nextInt(1, 101);
		int guessesRemaining = 5;
		
		do {
			System.out.println("Pick a number:");
			try {
				input = scanner.nextInt();
			}
			catch (InputMismatchException ex) {
				System.out.println("Please type a number only!");
				scanner.next(); // need this to consume the invalid token in the scanner object
				continue;
			}
			
			if (input < 1 || input > 100 ) {
				System.out.println("Your guess is outside the range. Pleaes guess again!");
				continue;
			}
			
			else if ( checkGuess(input, randomNumber) ) {
				System.out.println("You guessed " + input + " and the number was " + randomNumber + ". Congratulations!");
				scanner.close();
				break;
			}
			
			else if (!checkGuess(input, randomNumber)) {
				guessesRemaining--;
				System.out.println("Incorrect. You have " + guessesRemaining + " guesses remaining.");
			}
		}
		while (guessesRemaining > 0);
		
		if  (guessesRemaining == 0 ) {
			System.out.println("You ran out of guesses. Sorry!");
			scanner.close();
		}
		
		
	}
	
	public static void main(String[] args) {
		run();

	}

}
