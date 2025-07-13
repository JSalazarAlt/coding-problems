import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JumpGame {
    
    /**
     * Solves the "Jump Game" problem
     * (https://leetcode.com/problems/jump-game/).
     *
     * Given an integer array nums, you are initially positioned at the first index.
     * Each element in the array represents your maximum jump length at that position.
     * Returns true if you can reach the last index, false otherwise.
     *
     * Approach (Greedy - Track Maximum Reachable Position):
     * 1. Start from first position and track the farthest reachable index.
     * 2. For each reachable position, update the maximum reachable distance.
     * 3. If we can reach or exceed the last index, return true.
     * 4. If we get stuck (current position > max reachable), return false.
     * 5. Handle edge case of single element array.
     *
     * Time Complexity: O(n)
     * - Single pass through reachable positions in the array.
     *
     * Space Complexity: O(1)
     * - Only using constant extra space for variables.
     *
     * @param nums Array where nums[i] represents max jump length from position i.
     * @return true if the last index is reachable, false otherwise.
     */
    public static boolean canJump(int[] nums) {
        
        // Length of the input array
        int n = nums.length;

        // Current position index
        int i = 0;

        // Maximum reachable index from current position
        int maxReach = nums[0];

        // Continue while current position is within reachable range
        while (i <= maxReach) {
            // Update maximum reachable distance if current position allows farther jump
            if (i + nums[i] > maxReach) {
                maxReach = i + nums[i];
            }
            // Check if we can reach the last index
            if (maxReach >= n - 1) return true;
            // Move to next position
            i++;
        }
        // Handle edge case: single element array is always reachable
        return n == 1;
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
                System.out.print("nums: [");
                for (int i = 0; i < n; i++) {
                    System.out.print(nums[i] + ", ");
                }
                if (n > 0) System.out.print(nums[n - 1]);
                System.out.println("]");

                // Find if we can jump till the end
               boolean canReachEnd = canJump(nums);

                // Print if we can jump till the end
                System.out.println("Can we jump till the end?: " + canReachEnd);
                System.out.println();

            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open 055_JumpGame as source directory.");

        }

    }

}
