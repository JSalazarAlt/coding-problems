import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ValidPalindrome {
    
    /**
     * Solves the "Valid Palindrome" problem
     * (https://leetcode.com/problems/valid-palindrome/).
     *
     * A phrase is a palindrome if, after converting all uppercase letters into lowercase
     * letters and removing all non-alphanumeric characters, it reads the same forward
     * and backward. Alphanumeric characters include letters and numbers.
     *
     * Approach: (String Preprocessing + Two Pointers)
     * 1. Remove all non-alphanumeric characters using regex.
     * 2. Convert the string to lowercase for case-insensitive comparison.
     * 3. Compare characters from both ends moving towards the center.
     * 4. If all character pairs match, the string is a palindrome.
     *
     * Time Complexity: O(n)
     * - O(n) for preprocessing + O(n/2) for palindrome check.
     *
     * Space Complexity: O(n)
     * - Creating a new processed string takes O(n) space.
     *
     * @param s The string to check for palindrome property.
     * @return true if s is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String s) {

        // Remove all non-alphanumeric characters
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        // Convert to lowercase for case-insensitive comparison
        s = s.toLowerCase();
        
        // Length of the processed string
        int n = s.length();

        // Compare characters from both ends moving towards center
        for (int i = 0; i < n/2; i++) {
            // If characters don't match, it's not a palindrome
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }

        // Return true if all character pairs matched, string is a palindrome
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
                
                // Read the string input
                String s = scanner.nextLine();
                
                // Print the number of test case
                System.out.print("Test Case #" + test + ": ");

                // Print the input string
                System.out.println("s = " + s);

                // Check if the string is a palindrome
                boolean isPalindrome = isPalindrome(s);

                // Print if the string is a palindrome
                System.out.println("Is it a palindrome?: " + isPalindrome);
                System.out.println();

            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open 125_ValidPalindrome as source directory.");

        }

    }

}
