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
     * Approach (Duplicates Counter + Boolean Flag - Shift)
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
     * - Only using constant extra spaces for array length, excess duplicates counter, and boolean variables.
     *
     * @param nums The sorted array to remove excess duplicates from in-place.
     * @return The new length of the array after removing excess duplicates.
     */
    public static int removeExcessDuplicates(int[] nums) {

        // Length of the sorted array
        int n = nums.length;
        // Counter for elements to remove (excess duplicates)
        int excessDuplicatesCount = 0;
        // Flag to track if we've seen one duplicate of current element
        boolean seen = false;
        
        // Start from second element since first is always kept
        for (int i = 1; i < n; i++) {
            // Check if current element equals previous element
            if (nums[i] == nums[i - 1]) {
                // If this is the first duplicate we've seen
                if (!seen){
                    seen = true;
                    // Keep this duplicate (shift left by removal count)
                    nums[i - excessDuplicatesCount] = nums[i];
                } else {
                    // This is an excess duplicate, mark for removal
                    excessDuplicatesCount++;
                }
            } else {
                // Different element, keep it and reset seen flag
                nums[i - excessDuplicatesCount] = nums[i];
                seen = false;
            }
        }

        // Compute k: the array length after removing excess duplicates
        int k = n - excessDuplicatesCount;
        
        // Return k
        return k;

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

                // Print the number of test case
                System.out.print("Test Case #" + test + ": ");

                // Print the input array
                System.out.print("nums = [");
                for (int i = 0; i < n - 1; i++) {
                    System.out.print(nums[i] + ", ");
                }
                System.out.println(nums[n - 1] + "]");

                // Remove excess duplicates from the array
                int k = removeExcessDuplicates(nums);

                // Print the array without excess duplicates
                System.out.print("Array without excess duplicates: nums = [");
                for (int i = 0; i < k - 1; i++) {
                    System.out.print(nums[i] + ", ");
                }
                System.out.print(nums[k - 1] + "] | k = " + k);
                System.out.println("\n");

            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open the project with 080_RemoveDuplicatesSortedArrayII as source directory.");

        }

    }

}
