import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ThreeSumClosest {
    
    /**
     * Solves the "3Sum Closest" problem
     * (https://leetcode.com/problems/3sum-closest/).
     *
     * Given an integer array nums of length n and an integer target, finds three integers
     * in nums such that the sum is closest to target. Returns the sum of the three integers.
     *
     * Approach:
     * 1. Sort the array to enable two-pointer technique.
     * 2. For each element nums[i], use two pointers (left and right) to find the pair
     *    that makes the sum closest to target.
     * 3. Track the minimum distance between current sum and target.
     * 4. If exact match is found (diff == 0), return immediately.
     * 5. If sum > target, move right pointer left to decrease sum.
     * 6. If sum < target, move left pointer right to increase sum.
     *
     * Time Complexity: O(n²)
     * - O(n log n) for sorting + O(n²) for nested iteration with two pointers.
     *
     * Space Complexity: O(1)
     * - Only using constant extra space for variables.
     *
     * @param nums The input array of integers.
     * @param target The target sum to get closest to.
     * @return The sum of three integers closest to target.
     */
    public static int threeSumClosest(int[] nums, int target) {
        
        // Sort the array to enable two-pointer technique
        Arrays.sort(nums);

        // Get array length and initialize tracking variables
        int n = nums.length;
        int minDistance = Integer.MAX_VALUE;
        int result = 0;

        // Iterate over the array to establish a reference nums[i]
        for (int i = 0; i < n; i++) {

            // Initialize the left and right pointers for two-pointer technique
            int left = i + 1;
            int right = n - 1;

            // Use two pointers to find the closest sum
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = sum - target;
                
                // Update result if current sum is closer to target
                if (Math.abs(diff) < minDistance) {
                    result = sum;
                    minDistance = Math.abs(diff);
                }
                
                // If exact match found, return immediately
                if (diff == 0) {
                    return sum;
                } else if (diff > 0) {
                    // Sum is greater than target, decrease it
                    right--;
                } else {
                    // Sum is less than target, increase it
                    left++;
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {

        try {
            
            // Declare the Scanner object to read the file
            File file = new File("LeetCode/Medium/016_ThreeSumClosest/test_cases.txt");
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
                // Test Case #2: 0
                int result = threeSumClosest(nums, target);
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
