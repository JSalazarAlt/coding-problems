import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FirstLastPositionsSortedArray {
    
    /**
     * Solves the "Find First and Last Position of Element in Sorted Array" problem
     * (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/).
     *
     * Given an array of integers nums sorted in non-decreasing order, finds the starting
     * and ending position of a given target value. If target is not found in the array,
     * returns [-1, -1].
     *
     * Approach (Binary Search - Pointer Forward and Backward):
     * 1. Use binary search to find any occurrence of the target.
     * 2. Once target is found, expand left and right from that position to find boundaries.
     * 3. Move left pointer backwards while elements equal target.
     * 4. Move right pointer forwards while elements equal target.
     * 5. Return the first and last valid positions of the target.
     *
     * Time Complexity: O(log n + k)
     * - O(log n) for binary search to find target.
     * - O(k) to expand and find boundaries, where k is the count of target occurrences.
     *
     * Space Complexity: O(1)
     * - Only using constant extra space for variables.
     *
     * @param nums The sorted array of integers in non-decreasing order.
     * @param target The target value to search for.
     * @return An array containing [first_position, last_position] or [-1, -1] if not found.
     */
    public static int[] searchRange(int[] nums, int target) {
        
        // Initialize binary search pointers
        int left = 0;
        int right = nums.length - 1;

        // Initialize result array with default values [-1, -1]
        int[] range = {-1, -1};

        // Perform binary search to find any occurrence of target
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // If target found, expand to find first and last positions
            if (nums[mid] == target) {
                // Initialize pointers to expand from found position
                int targetLeft = mid - 1;
                int targetRight = mid + 1;
                
                // Expand left to find the first occurrence
                while ((targetLeft >= 0) && (nums[targetLeft] == target)) {
                    targetLeft--;
                }
                
                // Expand right to find the last occurrence
                while ((targetRight < nums.length) && (nums[targetRight] == target)) {
                    targetRight++;
                }
                
                // Set the first and last positions in result array
                range[0] = targetLeft + 1;
                range[1] = targetRight - 1;
                break;
            } else if (nums[mid] < target) {
                // Target is in the right half
                left = mid + 1;
            } else {
                // Target is in the left half
                right = mid - 1;
            }
        }
        
        // Return the range of the target value in the array
        return range;

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
                System.out.println("]");

                // Find the indexes of the range of the target value
                int[] range = searchRange(nums, target);
                
                // Print the range of the target value in the array
                System.out.print("All " + target + "s in the array: range = [");
                for (int i = 0; i < 2; i++) {
                    if (i != 1) {
                        System.out.print(range[i] + " ");
                    } else {
                        System.out.print(range[i]);
                    }
                }         
                System.out.println("]");
                System.out.println();

            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open the project with 034_FirstLastPositionsSortedArray as source directory.");

        }

    }
}
