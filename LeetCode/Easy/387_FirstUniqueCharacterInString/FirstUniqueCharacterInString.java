import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstUniqueCharacterInString {

    /**
     * Solves the "First Unique Character in a String" problem
     * (https://leetcode.com/problems/first-unique-character-in-a-string/).
     *
     * Given a string s, finds the first non-repeating character in it and returns its index.
     * If it does not exist, returns -1.
     *
     * Approach (HashMap of Frequencies)
     * 1. Create a HashMap to count the frequency of each character in the string.
     * 2. First pass: iterate through the string and populate the frequency map.
     * 3. Second pass: iterate through the string again and find the first character
     *    with frequency 1 (unique character).
     * 4. Return the index of the first unique character, or -1 if none exists.
     *
     * Time Complexity: O(n)
     * - Two passes through the string: O(n) + O(n) = O(n).
     *
     * Space Complexity: O(min(n, 26))
     * - HashMap stores at most min(n, 26) unique characters (26 lowercase letters max).
     *
     * @param s The input string containing only lowercase English letters.
     * @return The index of the first unique character, or -1 if no unique character exists.
     */
    public static int firstUniqChar(String s) {
        
        // Length of the input string
        int n = s.length();

        // Create a HashMap to store character frequencies
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        // First pass: count frequency of each character
        for (int i = 0; i < n; i++) {
            // Increment count for current character (default to 0 if not present)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // Second pass: find the first character with frequency 1
        for (int i = 0; i < n; i++) {
            // Check if current character appears exactly once
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        
        // No unique character found
        return -1;

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
                
                // Read the string input
                String s = scanner.nextLine();
                
                // Print the number of test case
                System.out.print("Test Case #" + test + ": ");

                // Print the input string
                System.out.println(s);

                // Find the first unique character of the string
                int indexFirstUniqueChar = firstUniqChar(s);
                
                // Print the first unique character
                System.out.println("First unique character: index = " + indexFirstUniqueChar);
                System.out.println();

            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open 387_FirstUniqueCharacterInString as source directory.");

        }
        
    }

}