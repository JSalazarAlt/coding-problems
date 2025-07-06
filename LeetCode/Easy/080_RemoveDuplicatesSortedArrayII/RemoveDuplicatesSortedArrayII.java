import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RemoveDuplicatesSortedArrayII {
    
    /**
     * Solves the "Remove Duplicates from Sorted Array II" problem
     * (https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/).
     *
     * Given an integer array nums sorted in non-decreasing order, removes duplicates
     * in-place such that each unique element appears at most twice. Returns the number
     * of elements after removals.
     *
     * Approach:
     * 1. Start from the second element since first element is always kept.
     * 2. Use a boolean flag to track if we've seen one duplicate of current element.
     * 3. For each element, compare with previous element.
     * 4. If equal and not seen before, keep it and mark as seen.
     * 5. If equal and already seen, increment removal count.
     * 6. If different, keep it and reset the seen flag.
     *
     * Time Complexity: O(n)
     * - Single pass through the array starting from index 1.
     *
     * Space Complexity: O(1)
     * - Only using constant extra space for counter and boolean variables.
     *
     * @param nums The sorted array to remove excess duplicates from in-place.
     * @return The new length of the array after removing excess duplicates.
     */
    public static int removeDuplicates(int[] nums) {
        // Counter for elements to remove (excess duplicates)
        int count = 0;
        // Flag to track if we've seen one duplicate of current element
        boolean seen = false;
        
        // Start from second element since first is always kept
        for (int i = 1; i < nums.length; i++) {
            // Check if current element equals previous element
            if (nums[i] == nums[i - 1]) {
                // If this is the first duplicate we've seen
                if (!seen){
                    seen = true;
                    // Keep this duplicate (shift left by removal count)
                    nums[i - count] = nums[i];
                } else {
                    // This is an excess duplicate, mark for removal
                    count++;
                }
            } else {
                // Different element, keep it and reset seen flag
                nums[i - count] = nums[i];
                seen = false;
            }
        }
        
        // Return new array length after removing excess duplicates
        return nums.length - count;
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
                int[] nums = new int[n];
                for (int i = 0; i < n; i++) {
                    nums[i] = scanner.nextInt();
                }

                // Print the result for the corresponding test case. The results should be:
                // Test Case #1: nums = [1, 1, 2, 2, 3] ; k = 2
                // Test Case #2: nums = [0, 0, 1, 1, 2, 3, 3] ; k = 7
                int k = removeDuplicates(nums);
                System.out.println("Test Case #" + test + ":");
                System.out.print("nums = [");
                for (int i = 0; i < k - 1; i++) {
                    System.out.print(nums[i] + ", ");
                }
                System.out.print(nums[k - 1] + "] ; k = " + k);
                System.out.println("\n");

            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open the project with 080_RemoveDuplicatesSortedArrayII as source directory.");

        }

    }

}
