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
     * Approach: (Temporary Variable - Swap) 
     * 1. Iterate over the array of characters.
     * 2. Swap characters at positions i and n-1-i.
     * 3. Continue until reaching the middle of the array.
     * 4. The array is modified in-place, no return value needed.
     *
     * Time Complexity: O(n)
     * - Single pass through half of the array to perform swaps.
     *
     * Space Complexity: O(1)
     * - Only using three constant extra spaces for array length and temporary variable.
     *
     * @param s The array of characters to reverse in-place.
     */
    public static void reverseString(char[] s) {
        
        // Length of the input array
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
                String s = scanner.next();
                
                // Convert string to character array
                char[] chars = s.toCharArray();
                
                // Print the number of test case
                System.out.print("Test Case #" + test + ": ");

                // Print the input string
                System.out.println("s = " + s);

                // Reverse the string
                reverseString(chars);

                // Print the reverse string
                System.out.println("Reverse string: s = " + new String(chars));
                System.out.println();

            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open 344_ReverseString as source directory.");

        }
        
    }

}
