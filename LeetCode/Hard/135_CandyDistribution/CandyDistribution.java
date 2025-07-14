import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class CandyDistribution {
    
    /**
     * Solves the "Candy" problem
     * (https://leetcode.com/problems/candy/).
     *
     * There are n children sitting in a line. Each child is assigned a rating value given
     * in the integer array ratings. You are giving candies to these children subjected to
     * the following requirements:
     * 1. Each child must have at least one candy.
     * 2. Children with a higher rating get more candies than their neighbors.
     * Returns the minimum number of candies you need to have to distribute.
     *
     * Approach (Two-Pass Greedy Algorithm):
     * 1. Initialize all children with 1 candy (minimum requirement).
     * 2. Left-to-right pass: ensure higher-rated children have more candies than left neighbor.
     * 3. Right-to-left pass: ensure higher-rated children have more candies than right neighbor.
     * 4. Take maximum of current candies and required candies to satisfy both constraints.
     * 5. Sum all candies to get the minimum total.
     *
     * Time Complexity: O(n)
     * - Three passes through the array: initialization, left-to-right, right-to-left, and sum.
     *
     * Space Complexity: O(n)
     * - Extra array to store candy count for each child.
     *
     * @param ratings Array of ratings for each child.
     * @return Minimum number of candies needed to satisfy all constraints.
     */
    public static int candy(int[] ratings) {
        
        // Length of the input array
        int n = ratings.length;

        // Array to store candy count for each child
        int[] candies = new int[n];
        
        // Variable to store total sum of candies
        int sum = 0;

        // Initialize each child with 1 candy (minimum requirement)
        Arrays.fill(candies, 1);

        // Left-to-right pass: ensure higher-rated children have more candies than left neighbor
        for (int i = 1; i < n; i++) {
            // If current child has higher rating than previous child
            if (ratings[i] > ratings[i - 1]) {
                // Give one more candy than the previous child
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right-to-left pass: ensure higher-rated children have more candies than right neighbor
        for (int i = n - 2; i >= 0; i--) {
            // If current child has higher rating than next child
            if (ratings[i] > ratings[i + 1]) {
                // Take maximum of current candies and (next child's candies + 1)
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Calculate total sum of candies needed
        for (int c : candies) { sum += c; }
        
        // Return the minimum total candies required
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
                
                // Read the number of elements of the list
                int n = scanner.nextInt();

                // Read the elements of the list
                int[] ratings = new int[n];
                for (int i = 0; i < n; i++) {
                    ratings[i] = scanner.nextInt();
                }

                // Print the number of test case
                System.out.print("Test Case #" + test + ": ");

                // Print the input array
                System.out.print("ratings = [");
                for (int i = 0; i < n - 1; i++) {
                    System.out.print(ratings[i] + ", ");
                }
                if (n > 0) System.out.print(ratings[n - 1]);
                System.out.println("]");
                
                // Find the minimum required number of candies
                int minCandies = candy(ratings);
                
                // Print the minimum required number of candies
                System.out.println("The minimum required number of candies: minCandies = " + minCandies);
                System.out.println();

            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open 135_CandyDistribution as source directory.");

        }

    }
    
}
