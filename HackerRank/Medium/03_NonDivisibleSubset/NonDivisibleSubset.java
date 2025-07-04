import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NonDivisibleSubset {
    /**
     * Solves the "Non-Divisible Subset" problem
     * (https://www.hackerrank.com/challenges/non-divisible-subset/problem?isFullScreen=true).
     *
     * Given a set of distinct integers and a positive integer k, finds the size of the largest subset
     * such that the sum of any two integers in the subset is not divisible by k.
     *
     * Approach:
     * 1. Create a frequency map of remainders when each number is divided by k.
     * 2. For remainder 0: at most one number can be included (since 0 + 0 = 0, divisible by k).
     * 3. For remainders i and k-i: they form complementary pairs that sum to k (divisible by k),
     *    so we can only include numbers from one remainder group, choosing the larger frequency.
     * 4. Special case: when k is even and remainder is k/2, at most one number can be included
     *    (since k/2 + k/2 = k, divisible by k).
     *
     * Time Complexity: O(n + k)
     * - O(n) to process all numbers and build the frequency map.
     * - O(k) to iterate through remainder pairs.
     *
     * Space Complexity: O(k)
     * - O(k) to store the frequency map of remainders.
     *
     * @param k The positive integer divisor.
     * @param s The list of distinct integers.
     * @return The size of the largest non-divisible subset.
     */
    public static int nonDivisibleSubset(int k, List<Integer> s) {
    
        // Declare a map to keep track of the frequencies of the remainders of the numbers with respect to k 
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        // Initialize the maximum subset length
        int maximumLength = 0;
        
        // Initialize the map
        for (int i = 0; i < k; i++) {
            map.put(i, 0);
        }
        
        // Populate the map with the corresponding frequencies
        for (int i = 0; i < s.size(); i++) {
            int remainder = s.get(i) % k;
            map.put(remainder, map.get(remainder) + 1);
        }
        
        // Add just one to the maximum length if there are at least one number multiple of k in the subset 
        if (map.get(0) != 0) {
            maximumLength++;
        }
        
        // If the frequency of i is greater than k - i, add the frequency of i to the maximum length
        // otherwise, add the frequency of k - 1
        for (int i = 1; i <= k/2; i++) {
            if (i != k - i){
                if (map.get(i) >= map.get(k - i)) {
                    maximumLength += map.get(i);
                } else {
                    maximumLength += map.get(k - i);
                }
            } else {
                maximumLength++;
            }
        }
        
        // Return the maximum subset length 
        return maximumLength;

    }

    public static void main(String[] args) {
        
        try {
            
            // Declare the Scanner object to read the file
            File file = new File("HackerRank/Medium/03_NonDivisibleSubset/test_cases.txt");
            Scanner scanner = new Scanner(file);

            // Read the number of test cases
            int t = scanner.nextInt();

            for (int test = 1; test <= t; test++) {
                
                // Read the number of elements in the list
                int n = scanner.nextInt();

                // Read the divisor k
                int k = scanner.nextInt();

                // Read the elements of the list
                List<Integer> s = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    s.add(scanner.nextInt());
                }

                // Print the result for the corresponding test case. The results should be:
                // Test Case #1: 3
                // Test Case #2: 11
                int result = nonDivisibleSubset(k, s);
                System.out.println("Test Case #" + test + ":");
                System.out.println(result);
                System.out.println();
            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open the project with Puzzles as source directory.");

        }
        
    }

}
