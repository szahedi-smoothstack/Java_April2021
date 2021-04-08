/**
 * 
 */
package com.ss.jb.three;

import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Append text to an existing file 'text.txt' that is in the directory
 * Text to be appended is given via user input
 * 
 * @author Zahedi
 *
 */
public class AppendToFile {
	// The path points to a file to be created in the root of the project folder, i.e "Java_Week1
	private String path = "text.txt";
	
	
	public void Append(String input) {
		try (FileWriter fw = new FileWriter(this.path, true)) {
			fw.write(input);
			
		} catch (IOException e) {
			System.out.println("Cannot find the file!");
		}
	}

	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Please enter some text you would like to append to the file: ");
		
			String input = scanner.nextLine();
			AppendToFile af = new AppendToFile();
			af.Append(input);
			System.out.println("Appended to file. Goodbye.");
		} catch (NoSuchElementException ex) {
			System.out.println("You didn't enter anything!");
		}
		

	}

}
