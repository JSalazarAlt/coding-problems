import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RemoveDuplicatesSortedArray {

    /**
     * Solves the "Remove Duplicates from Sorted Array" problem
     * (https://leetcode.com/problems/remove-duplicates-from-sorted-array/).
     *
     * Given an integer array nums sorted in non-decreasing order, removes duplicates
     * in-place such that each unique element appears only once. Returns the number
     * of unique elements.
     *
     * Approach (Duplicates Counter - Shift):
     * 1. Start from the second element (index 1) since first element is always unique.
     * 2. Compare each element with its previous element.
     * 3. If they are equal, increment duplicate count.
     * 4. If they are different, shift the unique element left by the duplicate count.
     * 5. Return the new length (original length - duplicate count).
     *
     * Time Complexity: O(n)
     * - Single pass through the array starting from index 1.
     *
     * Space Complexity: O(1)
     * - Only using constant extra spaces for input array length, duplicates counter, and k.
     *
     * @param nums The sorted array to remove duplicates from in-place.
     * @return The new length of the array after removing duplicates.
     */
    public static int removeDuplicates(int[] nums) {

        // Length of the sorted array
        int n = nums.length;
        
        // Counter for duplicate elements found
        int duplicatesCounter = 0;
        
        // Start from second element since first is always unique
        for (int i = 1; i < n; i++) {
            // Check if current element is duplicate of previous
            if (nums[i] == nums[i - 1]) {
                // Increment duplicate counter
                duplicatesCounter += 1;
            } else {
                // Current element is unique, shift it left by duplicate count
                nums[i - duplicatesCounter] = nums[i];
            }
        }

        // Compute k: the array length after removing duplicates
        int k = n - duplicatesCounter;
        
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

                // Print the input array for the test case
                System.out.print("nums = [");
                for (int i = 0; i < n - 1; i++) {
                    System.out.print(nums[i] + ", ");
                }
                System.out.println(nums[n - 1] + "]");

                // Remove duplicates from the array
                int k = removeDuplicates(nums);

                // Print the array without duplicates for the corresponding test case
                System.out.print("Array without duplicates: nums = [");
                for (int i = 0; i < k - 1; i++) {
                    System.out.print(nums[i] + ", ");
                }
                System.out.print(nums[k - 1] + "] | k = " + k);
                System.out.println("\n");

            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open the project with 026_RemoveDuplicatesSortedArray as source directory.");

        }
        
    }

}