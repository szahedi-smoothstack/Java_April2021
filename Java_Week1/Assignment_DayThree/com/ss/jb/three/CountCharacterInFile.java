/**
 * 
 */
package com.ss.jb.three;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Count the number of times a given character appears in a file
 * 
 * @author Zahedi
 *
 */
public class CountCharacterInFile {
	private String path = "DayThree_AssignmentThreeTextFile.txt";
	
	public void Count(String input) {
		System.out.println("Counting how often \"" + input + "\" appears...");
		
		int count = 0;
		
		try (FileReader fr = new FileReader(this.path)) {
			int data = fr.read();
			while (data != -1 ) {
				if ((char) data == input.toCharArray()[0]) {
					count++;
				}
				data = fr.read();
			}
			System.out.println("The character was found " + count + " times");
		} catch (FileNotFoundException ex) {
			System.out.println("Could not find the file!");
		} catch (IOException e) {
			System.out.println("There was an error");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Which character would you like to search the file for? ");
			String input = scanner.next();
			CountCharacterInFile ccif = new CountCharacterInFile();
			ccif.Count(input);
			
		} catch (NoSuchElementException ex) {
			
		}

	}

}
