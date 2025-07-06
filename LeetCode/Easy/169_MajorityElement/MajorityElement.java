import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MajorityElement {

    /**
     * Solves the "Majority Element" problem
     * (https://leetcode.com/problems/majority-element/).
     *
     * Given an array nums of size n, returns the majority element. The majority element
     * is the element that appears more than ⌊n/2⌋ times. It is guaranteed that the
     * majority element always exists in the array.
     *
     * Approach (Hash Map):
     * 1. Create a HashMap to count frequency of each element.
     * 2. First pass: iterate through array and populate frequency map.
     * 3. Second pass: iterate through frequency map to find element with count > n/2.
     * 4. Return the majority element.
     *
     * Time Complexity: O(n)
     * - O(n) to build frequency map + O(k) to check frequencies, where k ≤ n.
     *
     * Space Complexity: O(n)
     * - HashMap can store up to n unique elements in worst case.
     *
     * @param nums The input array containing the majority element.
     * @return The majority element that appears more than n/2 times.
     */
    public static int majorityElement(int[] nums) {
        // Create HashMap to store element frequencies
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();

        // First pass: count frequency of each element
        for (int i = 0; i < nums.length; i++) {
            // Increment count for current element (default to 0 if not present)
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        // Second pass: find element with frequency > n/2
        for (int key : freq.keySet()) {
            // Check if current element appears more than half the time
            if (freq.get(key) > nums.length / 2) {
                return key;
            }
        } 
        
        // This should never be reached given problem constraints
        return -1;
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
                // Test Case #1: k = ""
                // Test Case #2: k = 4
                int k = majorityElement(nums);
                System.out.println("Test Case #" + test + ":");
                System.out.println("k = " + k);
                System.out.println();

            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open the project with 169_MajorityElement as source directory.");

        }

    }

}