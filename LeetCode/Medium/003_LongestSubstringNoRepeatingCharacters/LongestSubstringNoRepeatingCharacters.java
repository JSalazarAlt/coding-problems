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
     * Approach (Sliding Window):
     * 1. Use two pointers (left and right) to maintain a sliding window.
     * 2. Use a HashSet to track characters in the current window.
     * 3. Expand the window by moving right pointer if character is not in set.
     * 4. Shrink the window by moving left pointer if character is already in set.
     * 5. Keep track of the maximum window size encountered.
     *
     * Time Complexity: O(n)
     * - Each character is visited at most twice (once by right, once by left pointer).
     *
     * Space Complexity: O(min(m, n))
     * - Where m is the size of the character set and n is the length of the string.
     * - HashSet stores at most min(m, n) characters.
     *
     * @param s The input string.
     * @return The length of the longest substring without repeating characters.
     */
    public static int lengthOfLongestSubstring(String s) {

        // Initialize the result to track maximum length
        int max = 0;

        // Declare a HashSet for tracking the appearing characters in current window
        Set<Character> set = new HashSet<>();

        // Initialize two pointers for sliding window
        int right = 0;
        int left = 0;

        // Expand the sliding window using the right pointer
        while (right < s.length()) {

            char charLeft = s.charAt(left);
            char charRight = s.charAt(right);
            
            // If character is not in current window, expand window
            if (!set.contains(charRight)) {
                set.add(charRight);
                max = Math.max(max, set.size());
                right++;
            } else {
                // If character is duplicate, shrink window from left
                set.remove(charLeft);
                left++;
            }
            
        }

        return max;
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
                
                // Print the result for the corresponding test case. The results should be:
                // Test Case #1: 3
                // Test Case #2: 1
                // Test Case #3: 3
                int result = lengthOfLongestSubstring(s);
                System.out.println("Test Case #" + test + ":");
                System.out.println(result);
                System.out.println();
            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open the project with 003_LongestSubstringNoRepeatingCharacters as source directory.");

        }

    }

}