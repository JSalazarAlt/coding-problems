import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HackerRankInString {

    /**
     * Solves the "HackerRank in a String!" problem
     * (https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem?isFullScreen=true).
     *
     * Determines if the string "hackerrank" can be formed as a subsequence from the input string.
     * A subsequence maintains the relative order of characters but doesn't need to be contiguous.
     *
     * Approach (Remove chars from Target String when found in Input String):
     * 1. Initialize target string "hackerrank" to match against.
     * 2. Iterate through the input string character by character.
     * 3. When a character matches the first character of remaining target, remove it from target.
     * 4. If target becomes empty (length < 2), all characters have been found in order.
     * 5. Return "YES" if subsequence is found, "NO" otherwise.
     *
     * Time Complexity: O(n)
     * - Single pass through the input string.
     *
     * Space Complexity: O(1)
     * - Only using constant extra spaces for input array length and target string.
     *
     * @param s The input string to search within.
     * @return "YES" if "hackerrank" can be formed as subsequence, "NO" otherwise.
     */
    public static String hackerrankInString(String s) {

        // Length of the input string
        int n = s.length();

        // Initialize the target subsequence to find
        String target = "hackerrank";

        // Iterate through each character in the input string
        for (int i = 0; i < n; i++) {
            // Check if current character matches the next expected character in target
            if (s.charAt(i) == target.charAt(0)) {
                // If more characters remain in target, remove the matched character
                if (target.length() >= 2) {
                    target = target.substring(1);
                } else {
                    // All characters found in correct order
                    return "YES";
                }
            }
        }

        // Target subsequence not completely found
        return "NO";

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

                // Print the number of test case
                System.out.print("Test Case #" + test + ": ");

                // Print the input string
                System.out.println("s = " + s);

                // Check if the string contains hackerrank in it
                String containsWord = hackerrankInString(s);
                
                // Print if the string contains hackerrank in it
                System.out.println(containsWord);
                System.out.println();

            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open 04_HackerRankInString as source directory.");

        }

    }

}
