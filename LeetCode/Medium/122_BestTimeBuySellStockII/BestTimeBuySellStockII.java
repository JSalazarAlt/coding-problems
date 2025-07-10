import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BestTimeBuySellStockII {
    
    /**
     * Solves the "Best Time to Buy and Sell Stock II" problem
     * (https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/).
     *
     * Given an integer array prices where prices[i] is the price of a given stock on the ith day,
     * finds the maximum profit you can achieve. You may complete as many transactions as you like
     * (buy one and sell one share of the stock multiple times).
     *
     * Approach (Greedy - Capture All Positive Differences):
     * 1. Iterate through consecutive days in the price array.
     * 2. For each day, check if price increased from previous day.
     * 3. If price increased, add the difference to total profit.
     * 4. This captures all profitable single-day transactions.
     *
     * Time Complexity: O(n)
     * - Single pass through the array comparing consecutive elements.
     *
     * Space Complexity: O(1)
     * - Only using constant extra space for variables.
     *
     * @param prices Array of stock prices where prices[i] is price on day i.
     * @return Maximum profit achievable with multiple transactions.
     */
    public static int maxProfit(int[] prices) {
        
        // Length of the input array
        int n = prices.length;
        // Initialize total profit to 0
        int profit = 0;

        // Iterate through consecutive days starting from day 1
        for (int i = 1; i < n; i++) {
            // Check if price increased from previous day
            if (prices[i] - prices[i - 1] > 0) {
                // Add the positive difference to total profit
                profit += prices[i] - prices[i - 1];
            }
        }
        // Return the total profit accumulated
        return profit;
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

                // Find the maximum profit from multiple stock transactions
                int maxProfit = maxProfit(prices);

                // Print the maximum profit
                System.out.println("Maximum profit: maxProfit = " + maxProfit);
                System.out.println();

            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open 122_BestTimeBuySellStockII as source directory.");

        }

    }

}
