/**
 * 
 */
package com.ss.jb.one;

/**
 * @author szahedi
 *
 */
public class PrintPattern
{

	/**
	 * Prints predefined patterns
	 * @param args
	 */
	private static String[] patternA = {"*", "**", "***", "****", "........."};
	private static String[] patternB = {"     *", "    ***", "   *****", "..........."};
	
	public static void printPatternOne()
	{
		System.out.println("1)");
		for (String line : patternA)
		{
			System.out.println(line);
		}
	}
	
	public static void printPatternTwo()
	{
		System.out.println("2)");
		for (int i = patternA.length - 1; i >= 0; i--)
		{
			System.out.println(patternA[i]);
		}
	}
	
	public static void printPatternThree()
	{
		System.out.println("3)");
		for (String line : patternB)
		{
			System.out.println(line);
		}
	}
	
	public static void printPatternFour()
	{
		System.out.println("4)");
		for (int i = patternB.length - 1; i >= 0; i--)
		{
			System.out.println(patternB[i]);
		}
	}
	
	public static void main(String[] args)
	{
		printPatternOne();
		System.out.println();
		printPatternTwo();
		System.out.println();
		printPatternThree();
		System.out.println();
		printPatternFour();

	}

}
