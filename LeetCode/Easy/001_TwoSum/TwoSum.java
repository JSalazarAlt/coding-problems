import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {
    
    /**
     * Solves the "Two Sum" problem
     * (https://leetcode.com/problems/two-sum/).
     *
     * Given an array of integers nums and an integer target, returns indices of the two
     * numbers such that they add up to target. Assumes that each input has exactly one solution,
     * and the same element cannot be used twice.
     *
     * Approach (HashMap of Complements):
     * 1. Create a HashMap to store complements (target - current_number) and their indices (index of current_number).
     * 2. For each element, calculate its complement (target - current_element).
     * 3. Check if current element exists in the map (meaning its complement was seen before).
     * 4. If found, return the stored index and current index.
     * 5. If not found, store the complement and current index in the map.
     *
     * Time Complexity: O(n)
     * - Single pass through the array with O(1) HashMap operations.
     *
     * Space Complexity: O(n)
     * - HashMap can store up to n elements in worst case.
     *
     * @param nums The input array of integers.
     * @param target The target sum to find.
     * @return An array containing indices of the two numbers that add up to target.
     */
    public static int[] twoSum(int[] nums, int target) {
        
        // Length of the input array
        int n = nums.length;
        // HashMap to store complements and their indices
        Map<Integer, Integer> diff = new HashMap<Integer,Integer>();
        // Array to store the result indices
        int[] indexes = new int[2];
        
        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Calculate complement needed to reach target
            int num = target - nums[i];
            // Check if current number exists in map (its complement was seen before)
            if (!diff.containsKey(nums[i])) {
                // Store complement and current index for future lookup
                diff.put(num, i);
            } else {
                // Found the pair: retrieve previous index and current index
                indexes[0] = diff.get(nums[i]);
                indexes[1] = i;
                return indexes;
            }
        }
        
        // Should never reach here given problem constraints
        return null;

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

                // Print the input array for the test case
                System.out.print("nums = [");
                for (int i = 0; i < n - 1; i++) {
                    System.out.print(nums[i] + ", ");
                }
                
                // Print the target value for the test case
                System.out.println(nums[n - 1] + "] | target = " + target);

                // Find the indexes of two numbers that add up to target
                int[] indexes = twoSum(nums, target);

                // Print the indexes of the two numbers for the corresponding test case
                System.out.println("Numbers whose sum is " + target + ": indexes = [" + indexes[0] + ", " + indexes[1] + "]");
                System.out.println();
                
            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open the project with 016_ThreeSumClosest as source directory.");

        }

    }

}
