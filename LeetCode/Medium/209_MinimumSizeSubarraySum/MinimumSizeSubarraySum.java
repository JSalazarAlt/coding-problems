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

        // Length of the input array
        int n = nums.length;

        // Initialize sliding window pointers
        int left = 0;
        int right = 0;

        // Initialize minimum length to impossible value (array length + 1)
        int minLength = n + 1;

        // Initialize current window sum
        int sum = 0;

        // Expand sliding window using right pointer
        while (right < n) {
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
                // Remove rightmost element from window because we will sum it again
                sum -= nums[right];
                left++;
            }
        }

        // Return minimum length or 0 if no valid subarray exists
        return minLength == (n + 1) ? 0 : minLength;

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

                // Print the number of test case
                System.out.print("Test Case #" + test + ": ");

                // Print the input array
                System.out.print("nums = [");
                for (int i = 0; i < n - 1; i++) {
                    System.out.print(nums[i] + ", ");
                }
                if (n > 0) System.out.print(nums[n - 1]);
                System.out.print("] | ");

                // Print the target
                System.out.println("target = " + target);
                
                // Find the minimum size of the subarray that sum up to target
                int minSize = minSubArrayLen(target, nums);

                // Print the minimum size of the subarray
                System.out.println("Minimum size of the subarray: minSize = " + minSize);   
                System.out.println();

            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open the project with 209_MinimumSizeSubarraySum as source directory.");

        }

    }

}