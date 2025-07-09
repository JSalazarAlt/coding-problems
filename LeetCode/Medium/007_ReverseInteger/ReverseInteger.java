import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ReverseInteger {
    
    /**
     * Solves the "Reverse Integer" problem
     * (https://leetcode.com/problems/reverse-integer/).
     *
     * Given a signed 32-bit integer x, returns x with its digits reversed.
     * If reversing x causes the value to go outside the signed 32-bit integer range
     * [-2³¹, 2³¹ - 1], then return 0.
     *
     * Approach (Backward Processing - Divide x by 10):
     * 1. Initialize result variable to store the reversed number.
     * 2. Extract digits from right to left using modulo operation.
     * 3. Before each multiplication by 10, check for potential overflow.
     * 4. If overflow would occur, return 0 immediately.
     * 5. Otherwise, build the reversed number digit by digit.
     *
     * Time Complexity: O(log x)
     * - The number of digits in x is proportional to log x.
     *
     * Space Complexity: O(1)
     * - Only using constant extra space.
     *
     * @param x The 32-bit signed integer to reverse.
     * @return The reversed integer, or 0 if overflow occurs.
     */
    public static int reverse(int x) {
        
        // Initialize the reversed number
        int reverseX = 0;
        
        // Process each digit from right to left
        while (x != 0) {
            if ((reverseX > Integer.MAX_VALUE / 10) || (reverseX == Integer.MAX_VALUE / 10 && x % 10 > 7)) {
                return 0; // Positive overflow
            } else if ((reverseX < Integer.MIN_VALUE / 10) || (reverseX == Integer.MIN_VALUE / 10 && x % 10 < -8)) {
                return 0; // Negative overflow
            } else {
                reverseX = 10 * reverseX + x % 10;
                x = x / 10;
            }
        }
        
        // Return the reverse integer
        return reverseX;

    }

    public static void main(String[] args) {
        
        try {
            
            // Declare the Scanner object to read the file
            File file = new File("test_cases.txt");
            Scanner scanner = new Scanner(file);

            // Read the number of test cases
            int t = scanner.nextInt();

            for (int test = 1; test <= t; test++) {
                
                // Read the integer to reverse
                int x = scanner.nextInt();
                
                // Print the number of test case
                System.out.print("Test Case #" + test + ": ");

                // Print the integer to reverse
                System.out.println("x = " + x);

                // Compute the reverse integer
                int result = reverse(x);

                // Print the reverse integer
                System.out.println("Reverse integer: x = " + result);
                System.out.println();

            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open the project with 007_ReverseInteger as source directory.");

        }

    }
}