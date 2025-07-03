import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {
    
    /**
     * Solves the "Extra Long Factorials" problem
     * (https://www.hackerrank.com/challenges/extra-long-factorials/problem?isFullScreen=true).
     *
     * Calculates and prints the factorial of a given number n, where n can be up to 100.
     * Since factorials grow extremely large, BigInteger is used to handle arbitrary precision arithmetic.
     *
     * Approach:
     * 1. Initialize factorial as BigInteger with value 1.
     * 2. Iterate from 2 to n, multiplying the factorial by each number.
     * 3. Print the final factorial result.
     *
     * Time Complexity: O(n)
     * - Single loop from 2 to n performing multiplication operations.
     *
     * Space Complexity: O(1)
     * - Only using a constant amount of extra space (factorial and factor variables).
     *
     * @param n The number to calculate the factorial for (1 ≤ n ≤ 100).
     */
    public static void extraLongFactorials(int n) {
        
        // Initialize the factorial
        BigInteger factorial = new BigInteger("1");
        
        // Iterate until n
        for (int i = 2; i <= n; i++) {
            BigInteger factor = new BigInteger(String.valueOf(i));
            factorial = factorial.multiply(factor);
        }
        
        // Printing the factorial
        System.out.println(factorial);
        
    }

    public static void main(String[] args) {
        
        try {
            
            // Declare the Scanner object to read the file
            File file = new File("test_cases.txt");
            Scanner scanner = new Scanner(file);

            // Read the number of test cases
            int t = scanner.nextInt();

            for (int test = 1; test <= t; test++) {
                
                // Read the number to compute the factorial
                int n = scanner.nextInt();
                
                // Print the result for the corresponding test case
                System.out.println("Test Case #" + test + ":");
                extraLongFactorials(n);
                System.out.println();
            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found.");

        }

    }

}
