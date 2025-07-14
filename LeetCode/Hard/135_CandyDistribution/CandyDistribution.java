import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class CandyDistribution {
    
    public static int candy(int[] ratings) {
        
        int n = ratings.length;

        int[] candies = new int[n];
        
        int sum = 0;

        Arrays.fill(candies, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        for (int c : candies) { sum += c; }
        
        return sum;

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
                int[] ratings = new int[n];
                for (int i = 0; i < n; i++) {
                    ratings[i] = scanner.nextInt();
                }

                // Print the number of test case
                System.out.print("Test Case #" + test + ": ");

                // Print the input array
                System.out.print("ratings = [");
                for (int i = 0; i < n - 1; i++) {
                    System.out.print(ratings[i] + ", ");
                }
                if (n > 0) System.out.print(ratings[n - 1]);
                System.out.println("]");
                
                // Find the minimum required number of candies
                int minCandies = candy(ratings);
                
                // Print the minimum required number of candies
                System.out.println("The minimum required number of candies: minCandies = " + minCandies);
                System.out.println();

            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open 189_RotateArray as source directory.");

        }

    }
    
}
