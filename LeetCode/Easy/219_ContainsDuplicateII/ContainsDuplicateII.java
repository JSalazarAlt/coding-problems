import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContainsDuplicateII {
    
    /**
     * Solves the "Contains Duplicate II" problem
     * (https://leetcode.com/problems/contains-duplicate-ii/).
     *
     * Given an integer array nums and an integer k, returns true if there are two distinct
     * indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
     *
     * Approach (HashMap of Values and Indices):
     * 1. Create a HashMap to store each number's most recent index.
     * 2. For each element, check if it was seen before within distance k.
     * 3. If found within distance k, return true.
     * 4. Update the map with current element and its index.
     * 5. If no nearby duplicates found, return false.
     *
     * Time Complexity: O(n)
     * - Single pass through the array with O(1) HashMap operations.
     *
     * Space Complexity: O(min(n, k))
     * - HashMap stores at most min(n, k) unique elements.
     *
     * @param nums The input array of integers.
     * @param k The maximum allowed distance between duplicate indices.
     * @return true if there are nearby duplicates within distance k, false otherwise.
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        
        // Length of the input array
        int n = nums.length;

        // HashMap to store each number and its most recent index
        Map<Integer, Integer> valueToIndex = new HashMap<Integer, Integer>();

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Check if current number was seen before
            if (!valueToIndex.containsKey(nums[i])) {
                // First occurrence: store number and its index
                valueToIndex.put(nums[i], i);
            } else {
                // If within allowed distance k, return true
                if (i - valueToIndex.get(nums[i]) <= k) return true;
                // Update with current index for future comparisons
                valueToIndex.put(nums[i], i);
            }
        }

        // Return false since no nearby duplicates found
        return false;
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

                // Read the maximum distance k
                int k = scanner.nextInt();
                
                // Print the number of test case
                System.out.print("Test Case #" + test + ": ");

                // Print the input array
                System.out.print("nums = [");
                for (int i = 0; i < n - 1; i++) {
                    System.out.print(nums[i] + ", ");
                }
                System.out.print(nums[n - 1] + "] | ");
                
                // Print the target value
                System.out.println("k = " + k);

                // Check if there are nearby duplicates within distance k
                boolean areNeighborDuplicates = containsNearbyDuplicate(nums, k);

                // Print whether nearby duplicates exist
                System.out.println("Are there any nearby duplicates?: " + areNeighborDuplicates);
                System.out.println();
                
            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open 219_ContainsDuplicateII as source directory.");

        }

    }

}
