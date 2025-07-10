import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BestTimeBuySellStock {
    
    /**
     * Solves the "Best Time to Buy and Sell Stock" problem
     * (https://leetcode.com/problems/best-time-to-buy-and-sell-stock/).
     *
     * Given an array prices where prices[i] is the price of a given stock on the ith day,
     * finds the maximum profit you can achieve. You may complete at most one transaction
     * (buy one and sell one share of the stock).
     *
     * Approach (Two Pointers):
     * 1. Use left pointer as buy day and right pointer as sell day.
     * 2. Calculate profit for each valid buy-sell pair.
     * 3. If current profit is negative, move buy day to current sell day.
     * 4. Track maximum profit throughout the process.
     *
     * Time Complexity: O(n)
     * - Single pass through the array with two pointers.
     *
     * Space Complexity: O(1)
     * - Only using constant extra space for variables.
     *
     * @param prices Array of stock prices where prices[i] is price on day i.
     * @return Maximum profit achievable, or 0 if no profit possible.
     */
    public static int maxProfit(int[] prices) {

        // Length of input array
        int n = prices.length;
        // Initialize maximum profit to 0
        int maxProfit = 0;
        
        // Left pointer represents buy day
        int left = 0;
        // Right pointer represents sell day
        int right = 1;

        // Iterate through all possible sell days
        while (right < n) {
            // Check if selling on right day after buying on left day is profitable
            if (prices[right] - prices[left] > 0) {
                // Update maximum profit if current profit is better
                if (prices[right] - prices[left] > maxProfit) {
                    maxProfit = prices[right] - prices[left];
                }
            } else {
                // Current sell price is lower than buy price, move buy day to current day
                left = right;
            }
            // Move to next potential sell day
            right++;
        }
        // Return the maximum profit found
        return maxProfit;
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
                
                // Read the number of elements of the list
                int n = scanner.nextInt();
                
                // Read the elements of the list
                int[] prices = new int[n];
                for (int i = 0; i < n; i++) {
                    prices[i] = scanner.nextInt();
                }

                // Print the number of test case
                System.out.print("Test Case #" + test + ": ");

                // Print the input array
                System.out.print("prices: [");
                for (int i = 0; i < n; i++) {
                    System.out.print(prices[i] + ", ");
                }
                if (n > 0) System.out.print(prices[n - 1]);
                System.out.println("]");

                // Find the maximum profit from stock prices
                int maxProfit = maxProfit(prices);

                // Print the maximum profit
                System.out.println("Maximum profit: maxProfit = " + maxProfit);
                System.out.println();

            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open 121_BestTimeBuySellStock as source directory.");

        }

    }

}
