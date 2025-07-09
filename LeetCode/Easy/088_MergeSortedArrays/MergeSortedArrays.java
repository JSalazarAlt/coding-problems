import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MergeSortedArrays {

    /**
     * Solves the "Merge Sorted Array" problem
     * (https://leetcode.com/problems/merge-sorted-array/).
     *
     * Given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two
     * integers m and n, representing the number of elements in nums1 and nums2 respectively,
     * merges nums2 into nums1 as one sorted array. The final sorted array is stored inside nums1.
     *
     * Approach (Three Pointers - Backward Processing):
     * 1. Use three pointers: i (end of nums1 elements), j (end of nums2), k (end of merged array).
     * 2. Start from the end of both arrays to avoid overwriting unprocessed elements.
     * 3. Compare elements from the end and place the larger one at position k.
     * 4. Move the corresponding pointer backward after each placement.
     * 5. Continue until all elements are processed.
     *
     * Time Complexity: O(m + n)
     * - Single pass through both arrays.
     *
     * Space Complexity: O(1)
     * - In-place merge using existing space in nums1.
     *
     * @param nums1 The first sorted array with extra space to hold nums2 elements.
     * @param m The number of elements in nums1 (excluding extra space).
     * @param nums2 The second sorted array to merge into nums1.
     * @param n The number of elements in nums2.
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        // Initialize pointers: i for nums1, j for nums2, k for merged position
        int i = m - 1;     // Last element in nums1
        int j = n - 1;     // Last element in nums2
        int k = m + n - 1; // Last position in merged array
        
        // Merge arrays from the end to avoid overwriting
        while (k >= 0) {
            // If nums1 is exhausted, copy remaining elements from nums2
            if (i == -1) {
                nums1[k] = nums2[j];
                j--;
            }
            // If both arrays have elements, compare and place the larger one
            if (i >= 0 && j >= 0) {
                if (nums1[i] < nums2[j]) {
                    // nums2 element is larger, place it at position k
                    nums1[k] = nums2[j];
                    j--;
                } else if (nums1[i] >= nums2[j]) {
                    // nums1 element is larger or equal, place it at position k
                    nums1[k] = nums1[i];
                    i--;
                }
            }
            // Move to next position in merged array
            k--;
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
                int m = scanner.nextInt();

                // Read the elements of the list
                int[] nums1 = new int[m];
                for (int i = 0; i < m; i++) {
                    nums1[i] = scanner.nextInt();
                }

                // Read the number of elements of the list
                int n = scanner.nextInt();

                // Read the elements of the list
                int[] nums2 = new int[n];
                for (int i = 0; i < n; i++) {
                    nums2[i] = scanner.nextInt();
                }

                // Print the number of test case
                System.out.print("Test Case #" + test + ": ");
                
                // Print the first input array
                System.out.print("nums1: [");
                for (int i = 0; i < m - n - 1; i++) {
                    System.out.print(nums1[i] + ", ");
                }
                if (m - n > 0) System.out.print(nums1[m - n - 1]);
                System.out.print("] | ");
                
                // Print the second input array
                System.out.print("nums2: [");
                for (int i = 0; i < n - 1; i++) {
                    System.out.print(nums2[i] + ", ");
                }
                if (n > 0) System.out.print(nums2[n - 1]);
                System.out.println("]");
                
                // Merge both sorted arrays
                merge(nums1, m - n, nums2, n);
                
                // Print the merged sorted array
                System.out.print("Merged sorted array: nums1 = [");
                for (int i = 0; i < m - 1; i++) {
                    System.out.print(nums1[i] + ", ");
                }
                System.out.print(nums1[m - 1] + "]");
                System.out.println("\n");

            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open the project with 016_ThreeSumClosest as source directory.");

        }

    }
    
}
