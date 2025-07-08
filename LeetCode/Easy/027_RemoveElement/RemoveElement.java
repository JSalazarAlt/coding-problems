import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RemoveElement {
    
    /**
     * Solves the "Remove Element" problem
     * (https://leetcode.com/problems/remove-element/).
     *
     * Given an integer array nums and an integer val, removes all occurrences of val
     * in nums in-place. Returns the number of elements in nums which are not equal to val.
     *
     * Approach (Ocurrences Counter - Shift):
     * 1. Iterate through the array with a single pointer.
     * 2. Keep a count of elements that match the target value.
     * 3. For elements that don't match, shift them left by the count of removed elements.
     * 4. Return the new length (original length - count of removed elements).
     *
     * Time Complexity: O(n)
     * - Single pass through the array.
     *
     * Space Complexity: O(1)
     * - Only using constant extra spaces for input array length, counter variable, and k.
     *
     * @param nums The input array of integers to modify in-place.
     * @param val The value to remove from the array.
     * @return The new length of the array after removing all occurrences of val.
     */
    public static int removeElement(int[] nums, int val) {

        // Length of the input array
        int n = nums.length;
        // Counter for elements that match the target value
        int valCounter = 0;
        
        // Iterate through the entire array
        for (int i = 0; i < n; i++) {
            // If current element doesn't match target value
            if (nums[i] != val) {
                // Shift element left by the number of removed elements
                nums[i - valCounter] = nums[i];
            } else {
                // Increment count of elements to remove
                valCounter++;
            }
        }
        
        // Compute k: the array length after removals of val
        int k = n - valCounter;

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

                // Read the target value to remove from the list
                int val = scanner.nextInt();

                // Print the number of test case
                System.out.print("Test Case #" + test + ": ");

                // Print the input array for the test case
                System.out.print("nums = [");
                for (int i = 0; i < n - 1; i++) {
                    System.out.print(nums[i] + ", ");
                }
                System.out.print(nums[n - 1] + "] | ");

                // Print the value to remove from the array for the test case
                System.out.println("val = " + val);

                // Remove val elements from the array
                int k = removeElement(nums, val);

                // Print the array without val ocurrences for the corresponding test case
                System.out.print("Array without " + val + ": nums = [");
                for (int i = 0; i < k - 1; i++) {
                    System.out.print(nums[i] + ", ");
                }
                System.out.print(nums[k - 1] + "] | k = " + k);
                System.out.println("\n");

            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open the project with 027_RemoveElement as source directory.");

        }

    }

}