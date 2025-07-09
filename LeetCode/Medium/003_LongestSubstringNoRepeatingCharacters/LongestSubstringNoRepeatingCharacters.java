import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class LongestSubstringNoRepeatingCharacters {
    /**
     * Solves the "Longest Substring Without Repeating Characters" problem
     * (https://leetcode.com/problems/longest-substring-without-repeating-characters/).
     *
     * Given a string s, finds the length of the longest substring without repeating characters.
     *
     * Approach (HashSet of Unique Characters - Sliding Window):
     * 1. Use two pointers (left and right) to maintain a sliding window.
     * 2. Use a HashSet to track characters in the current window.
     * 3. Expand the window by moving right pointer if character is not in set.
     * 4. Shrink the window by moving left pointer if character is already in set.
     * 5. Keep track of the maximum window size encountered.
     *
     * Time Complexity: O(n)
     * - Each character is visited at most twice (once by right, once by left pointer).
     *
     * Space Complexity: O(m)
     * - Where m is the size of unique characters set.
     * - HashSet stores at most min(m, n) characters.
     *
     * @param s The input string.
     * @return The length of the longest substring without repeating characters.
     */
    public static int lengthOfLongestSubstring(String s) {

        // Length of the input string
        int n = s.length();

        // Initialize the result to track maximum length
        int maxLength = 0;

        // Declare a HashSet for tracking the appearing characters in current window
        Set<Character> set = new HashSet<>();

        // Initialize two pointers for sliding window
        int right = 0;
        int left = 0;

        // Expand the sliding window using the right pointer
        while (right < n) {

            char charRight = s.charAt(right);
            
            // If character is not in current window, expand window
            if (!set.contains(charRight)) {
                set.add(charRight);
                maxLength = Math.max(maxLength, set.size());
                right++;
            } else {
                // If character is duplicate, shrink window from left
                char charLeft= s.charAt(left);
                set.remove(charLeft);
                left++;
            }
            
        }

        // Return the maximum length of the substring with unique characters
        return maxLength;
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
                System.out.println("s = " + s);

                // Find the maximum length of the substring with unique characters
                int maxLength = lengthOfLongestSubstring(s);

                // Print the maximum length of the substring with unique characters
                System.out.println("Maximum length of substring with unique characters: maxLength = " + maxLength);
                System.out.println();
                
            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open 003_LongestSubstringNoRepeatingCharacters as source directory.");

        }

    }

}