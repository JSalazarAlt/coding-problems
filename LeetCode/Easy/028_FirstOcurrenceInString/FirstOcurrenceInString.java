import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FirstOcurrenceInString {
    
    /**
     * Solves the "Find the Index of the First Occurrence in a String" problem
     * (https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/).
     *
     * Given two strings needle and haystack, returns the index of the first occurrence
     * of needle in haystack, or -1 if needle is not part of haystack.
     *
     * Approach: (Built-in String Method)
     * 1. Use Java's built-in indexOf() method to find the first occurrence.
     * 2. The method returns the index if found, or -1 if not found.
     * 3. This leverages optimized string searching algorithms.
     *
     * Time Complexity: O(n * m)
     * - Where n is length of haystack and m is length of needle (worst case).
     *
     * Space Complexity: O(1)
     * - Only using constant extra space for the index variable.
     *
     * @param haystack The string to search within.
     * @param needle The substring to search for.
     * @return The index of first occurrence of needle in haystack, or -1 if not found.
     */
    public static int strStr(String haystack, String needle) {
       // Use built-in method to find first occurrence of needle in haystack
       int index = haystack.indexOf(needle);
       // Return the index (or -1 if not found)
       return index; 
    }

    public static void main(String[] args) {
        
        try {
            
            // Declare the Scanner object to read the file
            File file = new File("test_cases.txt");
            Scanner scanner = new Scanner(file);

            // Read the number of test cases
            int t = scanner.nextInt();
            scanner.nextLine(); // Consume the newline after the number

            for (int test = 1; test <= t; test++) {
                
                // Read the first string input
                String haystack = scanner.next();

                // Read the second string input
                String needle = scanner.next();
                
                // Print the number of test case
                System.out.print("Test Case #" + test + ": ");

                // Print the input string
                System.out.print("haystack = " + haystack + " | ");

                // Print the input string
                System.out.println("needle = " + needle);

                // Find the index of the first occurrence of "needle" in "haystack"
                int index = strStr(haystack, needle);

                // Print the index of first occurrence
                System.out.println("Index of first occurrence: index = " + index);
                System.out.println();

            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open 028_FirstOcurrenceInString as source directory.");

        }

    }
}