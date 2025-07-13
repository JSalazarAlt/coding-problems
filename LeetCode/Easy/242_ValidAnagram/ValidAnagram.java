import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ValidAnagram {
    
    /**
     * Solves the "Valid Anagram" problem
     * (https://leetcode.com/problems/valid-anagram/).
     *
     * Given two strings s and t, returns true if t is an anagram of s, and false otherwise.
     * An Anagram is a word or phrase formed by rearranging the letters of a different
     * word or phrase, typically using all the original letters exactly once.
     *
     * Approach: (Array of Characters Frequency)
     * 1. Check if both strings have the same length (early termination).
     * 2. Use an array to count frequency of each character in first string.
     * 3. Decrement counts for each character in second string.
     * 4. If any count goes negative, strings are not anagrams.
     *
     * Time Complexity: O(n)
     * - Single pass through both strings with constant time array operations.
     *
     * Space Complexity: O(1)
     * - Fixed-size array of 26 elements for lowercase English letters.
     *
     * @param s The first string to compare.
     * @param t The second string to compare.
     * @return true if t is an anagram of s, false otherwise.
     */
    public static boolean isAnagram(String s, String t) {
        
        // Length of first string
        int m = s.length();
        // Length of second string
        int n = t.length();

        // Array to count character frequencies (26 lowercase letters)
        int[] charCount = new int[26];
        
        // Early termination: anagrams must have same length
        if (m != n) { return false; }

        // Count frequency of each character in first string
        for(char c : s.toCharArray()){
            charCount[c - 'a']++;
        }
        
        // Decrement count for each character in second string
        for(char c : t.toCharArray()){
            charCount[c - 'a']--;
            // If count goes negative, second string has more of this character
            if (charCount[c - 'a'] < 0) {
                return false;
            }
        }
        
        // All character frequencies matched, strings are anagrams
        return true;
        
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
                
                // Read the first input string
                String s1 = scanner.nextLine();

                // Read the second input string
                String s2 = scanner.nextLine();
                
                // Print the number of test case
                System.out.print("Test Case #" + test + ": ");

                // Print the input string
                System.out.print("s = " + s1 + " | ");

                // Print the input string
                System.out.println("t = " + s2);

                // Check if the two strings are anagrams
                boolean isAnagram = isAnagram(s1, s2);

                // Print if the two strings are anagrams
                System.out.println("Are both strings anagrams?: " + isAnagram);
                System.out.println();

            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open 242_ValidAnagram as source directory.");

        }

    }

}
