/**
 * 
 */
package com.ss.jb.three;

import java.io.File;


/**
 * List all the file/directory names under a given directory
 * 
 * @author Zahedi
 *
 */
public class DirectoryContents {
	
	private String dir;
	
	public DirectoryContents(String dir) {
		this.dir = dir;
	}
	
	
	// Method to get all files and directories in a directory specified
	public void ListContent() {
		File file = new File(this.dir);
		String[] contents = file.list();
		
		try {
			for (String item : contents) {
		
				System.out.println(item);
			}
		} catch (NullPointerException e) {
			System.out.println("Invalid directory");
		}
	}

	/**
	 * @param args
	 * The directory given via command line should be in quotes if it contains a space
	 * ex: "C:\Program Files\" vs C:\Program Files\
	 * The directory path must be absolute
	 */
	public static void main(String[] args) {
		System.out.println(args[0]);
		DirectoryContents dc = new DirectoryContents(args[0]);
		dc.ListContent();
		
	}

}
