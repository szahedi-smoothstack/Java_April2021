package com.ss.jb.weekly;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

// Class which provides methods to check an int for various properties
public class Lambdas {
    public boolean testType(PerformOperation p, int i){
        return p.intTest(i);
    }

    public PerformOperation isOdd() {
        return num -> num % 2 != 0;
    }

    public PerformOperation isPrime() {
        return num -> {
            BigInteger n = new BigInteger(String.valueOf(num));
             return n.isProbablePrime(1);
        };
    }

    public PerformOperation isPalindrome() {
        return num -> {
            String s = String.valueOf(num);
            String reverse = new StringBuffer(s).reverse().toString();
            return s.equals(reverse);
        };
    }

    /**
     * Sample input to use:
     * 5
     * 1 4
     * 2 5
     * 3 898
     * 1 3
     * 2 12
     */
    public static void main(String[] args) {
        Lambdas lam = new Lambdas();

        try {
            System.out.println("Enter the input, beginning with number of test cases: ");
            Scanner scanner = new Scanner(System.in);
            int testCases = Integer.parseInt(scanner.nextLine());
            String result = null;
            List<String> results = new ArrayList<>();

            while (testCases-- > 0) {
                String s = scanner.nextLine().trim();
                StringTokenizer st = new StringTokenizer(s);
                int testType = Integer.parseInt(st.nextToken());
                int numToTest = Integer.parseInt(st.nextToken());

                if (testType == 1) {
                    result = lam.testType(lam.isOdd(), numToTest) ? "ODD" : "EVEN";
                }
                else if (testType == 2) {
                    result = lam.testType(lam.isPrime(), numToTest) ? "PRIME" : "COMPOSITE";
                }
                else if (testType == 3) {
                    result = lam.testType(lam.isPalindrome(), numToTest) ? "PALINDROME" :  "NOT PALINDROME";
                }

                results.add(result);
            }
            results.forEach(System.out::println);

        }
        catch (NumberFormatException e) {
            System.out.println("Please format the input correctly as an integer!");
        }

    }
}


