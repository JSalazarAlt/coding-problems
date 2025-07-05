import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReverseString {
    
    /**
     * Solves the "Reverse String" problem
     * (https://leetcode.com/problems/reverse-string/).
     *
     * Reverses the input string in-place with O(1) extra memory.
     * The input string is given as an array of characters s.
     *
     * Approach:
     * 1. Use two pointers technique with left and right pointers.
     * 2. Swap characters at positions i and n-1-i.
     * 3. Continue until reaching the middle of the array.
     * 4. The array is modified in-place, no return value needed.
     *
     * Time Complexity: O(n)
     * - Single pass through half of the array to perform swaps.
     *
     * Space Complexity: O(1)
     * - Only using three constant extra spaces for temporary variable (n, i, and temp).
     *
     * @param s The array of characters to reverse in-place.
     */
    public static void reverseString(char[] s) {
        // Get the length of the character array
        int n = s.length;
        
        // Iterate through the first half of the array
        for (int i = 0; i < n/2; i++) {
            // Store the character at position i temporarily
            char temp = s[i];
            // Swap character at position i with character at position n-1-i
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = temp;
        }
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
                String input = scanner.next();
                
                // Convert string to character array
                char[] s = input.toCharArray();
                
                // Apply the reverse function
                reverseString(s);
                
                // Print the result for the corresponding test case. The results should be:
                // Test Case #1: olleh
                // Test Case #2: hannaH
                System.out.println("Test Case #" + test + ":");
                System.out.println(new String(s));
                System.out.println();
            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open the project with 344_ReverseString as source directory.");

        }
        
    }

}
