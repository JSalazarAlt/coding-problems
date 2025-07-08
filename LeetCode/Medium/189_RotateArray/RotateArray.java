import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RotateArray {
    
    public static void rotate(int[] nums, int k) {
        
        int n = nums.length;

        if (k % n == 0) return;
            
        int[] tail = new int[k % n];

        for (int i = 0; i < k % n; i++) {
            tail[i] = nums[n - k % n + i];
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i >= k % n) {
                nums[i] = nums[i - k % n];
            } else {
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

                // Print the result for the corresponding test case. The results should be:
                // Test Case #1: [5, 6, 7, 1, 2, 3, 4]
                // Test Case #2: [3, 99, -1, -100]
                // Test Case #3: [-1]
                rotate(nums, k);
                System.out.println("Test Case #" + test + ":");
                System.out.print("[");
                for (int i = 0; i < n - 1; i++) {
                    System.out.print(nums[i] + ", ");
                }
                System.out.print(nums[n - 1] + "]");
                System.out.println("\n");
            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open the project with 016_ThreeSumClosest as source directory.");

        }

    }

}
