import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MinimumSizeSubarraySum {

    /**
     * Solves the "Minimum Size Subarray Sum" problem
     * (https://leetcode.com/problems/minimum-size-subarray-sum/).
     *
     * Given an array of positive integers nums and a positive integer target,
     * returns the minimal length of a contiguous subarray whose sum is greater
     * than or equal to target. If no such subarray exists, returns 0.
     *
     * Approach (Sliding Window):
     * 1. Use two pointers (left and right) to maintain a sliding window.
     * 2. Expand the window by moving right pointer and adding elements to sum.
     * 3. When sum >= target, try to shrink window from left to find minimum length.
     * 4. Continue until right pointer reaches the end of array.
     * 5. Return the minimum length found, or 0 if no valid subarray exists.
     *
     * Time Complexity: O(n)
     * - Each element is visited at most twice (once by right, once by left pointer).
     *
     * Space Complexity: O(1)
     * - Only using constant extra space for variables.
     *
     * @param target The target sum to achieve or exceed.
     * @param nums The array of positive integers.
     * @return The minimum length of subarray with sum >= target, or 0 if none exists.
     */
    public static int minSubArrayLen(int target, int[] nums) {

        // Initialize sliding window pointers
        int left = 0;
        int right = 0;

        // Initialize minimum length to impossible value (array length + 1)
        int minLength = nums.length + 1;

        // Initialize current window sum
        int sum = 0;

        // Expand sliding window using right pointer
        while (right < nums.length) {
            // Add current element to window sum
            sum += nums[right];
            
            // If sum is still less than target, expand window
            if (sum < target) {
                right++;
            } else {
                // Sum >= target, update minimum length and try to shrink window
                minLength = Math.min(minLength, right - left + 1);
                // Remove leftmost element from window
                sum -= nums[left];
                sum -= nums[right];
                left++;
            }
        }

        // Return minimum length found, or 0 if no valid subarray exists
        return minLength == (nums.length + 1) ? 0 : minLength;

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
                int[] nums = new int[n];
                for (int i = 0; i < n; i++) {
                    nums[i] = scanner.nextInt();
                }

                // Read the target
                int target = scanner.nextInt();

                // Print the result for the corresponding test case. The results should be:
                // Test Case #1: 2
                // Test Case #2: 1
                // Test Case #3: 0
                // Test Case #4: 8
                int result = minSubArrayLen(target, nums);
                System.out.println("Test Case #" + test + ":");
                System.out.println(result);   
                System.out.println();
            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open the project with 209_MinimumSizeSubarraySum as source directory.");

        }

    }

}