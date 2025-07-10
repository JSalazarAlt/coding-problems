import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HappyNumber {
    
    /**
     * Solves the "Happy Number" problem
     * (https://leetcode.com/problems/happy-number/).
     *
     * A happy number is a number defined by the following process:
     * Starting with any positive integer, replace the number by the sum of the
     * squares of its digits. Repeat the process until the number equals 1
     * (where it will stay), or it loops endlessly in a cycle which does not include 1.
     * Those numbers for which this process ends in 1 are happy.
     *
     * Approach (Cycle Detection):
     * 1. Start with the given number and repeatedly calculate sum of squares of digits.
     * 2. If we reach 1, the number is happy.
     * 3. If we reach 4, we've entered a known cycle and the number is not happy.
     * 4. The key insight is that 4 is part of the only cycle for unhappy numbers.
     *
     * Time Complexity: O(log n)
     * - The number of digits decreases with each iteration.
     *
     * Space Complexity: O(1)
     * - Only using constant extra space.
     *
     * @param n The positive integer to check.
     * @return true if n is a happy number, false otherwise.
     */
    public static boolean isHappy(int n) {
        
        // Start with the given number
        int i = n;
        
        // Continue until we reach 1 (happy) or detect cycle
        while (i != 1) {
            // Calculate sum of squares of digits
            i = squaredSum(i);
            // If we reach 4, we've entered the unhappy cycle
            if (i == 4) return false;
        }
        
        // Reached 1, so the number is happy
        return true;
    }

    /**
     * Calculates the sum of squares of digits of a given number.
     *
     * @param n The number whose digits' squares need to be summed.
     * @return The sum of squares of all digits in n.
     */
    public static int squaredSum(int n) {
        // Initialize sum to store result
        int sum = 0;
        
        // Process each digit from right to left
        while (n != 0) {
            // Add square of current digit to sum
            sum += Math.pow(n % 10, 2);
            // Remove the rightmost digit
            n = n / 10;
        }
        
        // Return the sum of squares
        return sum;
    }

    public static void main(String[] args) {
        
        try {
            
            // Declare the Scanner object to read the file
            File file = new File("test_cases.txt");
            Scanner scanner = new Scanner(file);

            // Read the number of test cases
            int t = scanner.nextInt();

            for (int test = 1; test <= t; test++) {
                
                // Read the integer to check
                int n = scanner.nextInt();
                
                // Print the number of test case
                System.out.print("Test Case #" + test + ": ");

                // Print the integer to reverse
                System.out.println("n = " + n);

                // Find if the number is happy
                boolean isHappy = isHappy(n);

                // Print if the number is happy
                System.out.println("Is " + n + " happy?: " + isHappy);
                System.out.println();

            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open 202_HappyNumber as source directory.");

        }

    }
}
