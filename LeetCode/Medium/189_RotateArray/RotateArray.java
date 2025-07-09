import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RotateArray {
    
    /**
     * Solves the "Rotate Array" problem
     * (https://leetcode.com/problems/rotate-array/).
     *
     * Given an integer array nums, rotates the array to the right by k steps,
     * where k is non-negative. The rotation is performed in-place.
     *
     * Approach (Extra Array for Tail Elements):
     * 1. Calculate effective rotation steps using k % n to handle k > n cases.
     * 2. Store the last k elements (tail) that will move to the front.
     * 3. Shift remaining elements to the right by k positions.
     * 4. Place the stored tail elements at the beginning of the array.
     *
     * Time Complexity: O(n)
     * - Single pass to store tail elements + single pass to shift elements.
     *
     * Space Complexity: O(k)
     * - Extra array to store the last k elements temporarily.
     *
     * @param nums The array to be rotated in-place.
     * @param k The number of steps to rotate the array to the right.
     */
    public static void rotate(int[] nums, int k) {
        
        // Length of the input array
        int n = nums.length;

        // No rotation needed if k is multiple of array length
        if (k % n == 0) return;
            
        // Create temporary array to store tail elements that move to front
        int[] tail = new int[k % n];

        // Store the last k elements in temporary array
        for (int i = 0; i < k % n; i++) {
            tail[i] = nums[n - k % n + i];
        }

        // Shift elements to the right by k positions
        for (int i = n - 1; i >= 0; i--) {
            if (i >= k % n) {
                // Move element from position (i - k) to position i
                nums[i] = nums[i - k % n];
            } else {
                // Place tail elements at the beginning
                nums[i] = tail[i];
            }
        }

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

                // Read the number of steps
                int k = scanner.nextInt();

                // Print the number of test case
                System.out.print("Test Case #" + test + ": ");

                // Print the input array
                System.out.print("nums = [");
                for (int i = 0; i < n - 1; i++) {
                    System.out.print(nums[i] + ", ");
                }
                if (n > 0) System.out.print(nums[n - 1]);
                System.out.print("] | ");

                // Print the number of steps
                System.out.println("k = " + k);

                // Rotate the input array
                rotate(nums, k);
                
                // Print the rotated array
                System.out.print("Rotated array by " + k + " steps: nums = [");
                for (int i = 0; i < n - 1; i++) {
                    System.out.print(nums[i] + ", ");
                }
                System.out.print(nums[n - 1] + "]");
                System.out.println("\n");

            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open 189_RotateArray as source directory.");

        }

    }

}
