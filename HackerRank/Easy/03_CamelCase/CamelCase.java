import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CamelCase {

    /**
     * Solves the "CamelCase" problem
     * (https://www.hackerrank.com/challenges/camelcase/problem?isFullScreen=true).
     *
     * Given a string in camelCase format, determines the number of words in the string.
     * A word is defined as a sequence of characters that starts with an uppercase letter
     * (except for the first word which starts with a lowercase letter).
     *
     * Approach:
     * 1. Count the number of uppercase letters in the string.
     * 2. Each uppercase letter indicates the start of a new word.
     * 3. Add 1 to account for the first word (which starts with lowercase).
     * 4. Return the total count of words.
     *
     * Time Complexity: O(n)
     * - Single pass through the string to count uppercase letters.
     *
     * Space Complexity: O(1)
     * - Only using constant extra space for counter variable.
     *
     * @param s The camelCase string to analyze.
     * @return The number of words in the camelCase string.
     */
    public static int camelcase(String s) {

        // Initialize the counter for uppercase letters (new words)
        int numWords = 0;

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            // Check if current character is uppercase by comparing with 'a'
            // If (char - 'a') < 0, then char is uppercase
            if ((s.charAt(i) - 'a') < 0) {
                numWords++;
            }
        }

        // Return total words: uppercase count + 1 (for the first lowercase word)
        return numWords + 1;

    }

    public static void main(String[] args) {

        try {
            
            // Declare the Scanner object to read the file
            File file = new File("test_cases.txt");
            Scanner scanner = new Scanner(file);

            // Read the number of test cases
            int t = scanner.nextInt();

            for (int test = 1; test <= t; test++) {

                // Read the string
                String s = scanner.next();

                // Print the result for the corresponding test case. The results should be:
                // Test Case #1: 5
                int result = camelcase(s);
                System.out.println("Test Case #" + test + ":");
                System.out.println(result);
                System.out.println();
            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open the project with 04_HackerRankInString as source directory.");

        }

    }
    
}