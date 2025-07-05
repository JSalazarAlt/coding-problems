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
     * Approach:
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
        int reverse_x = 0;
        
        // Process each digit from right to left
        while (x != 0) {
            if ((reverse_x > Integer.MAX_VALUE / 10) || (reverse_x == Integer.MAX_VALUE / 10 && x % 10 > 7)) {
                return 0; // Positive overflow
            } else if ((reverse_x < Integer.MIN_VALUE / 10) || (reverse_x == Integer.MIN_VALUE / 10 && x % 10 < -8)) {
                return 0; // Negative overflow
            } else {
                reverse_x = 10 * reverse_x + x % 10;
                x = x / 10;
            }
        }
        
        return reverse_x;
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
                
                // Print the result for the corresponding test case. The results should be:
                // Test Case #1: 321
                // Test Case #2: -321
                // Test Case #3: 21
                // Test Case #4: 0
                // Test Case #5: 0
                int result = reverse(x);
                System.out.println("Test Case #" + test + ":");
                System.out.println(result);
                System.out.println();
            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open the project with 007_ReverseInteger as source directory.");

        }

    }
}