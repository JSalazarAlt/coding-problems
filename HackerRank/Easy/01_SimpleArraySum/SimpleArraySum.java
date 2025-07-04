import java.util.List;

public class SimpleArraySum {

    /**
     * Solves the "Simple Array Sum" problem
     * (https://www.hackerrank.com/challenges/simple-array-sum/problem?isFullScreen=true).
     *
     * Given an array of integers, calculate and return the sum of all elements.
     *
     * Approach:
     * 1. Initialize a sum variable to 0.
     * 2. Iterate through each element in the array.
     * 3. Add each element to the running sum.
     * 4. Return the final sum.
     *
     * Time Complexity: O(n)
     * - We iterate through the array once, where n is the number of elements.
     *
     * Space Complexity: O(1)
     * - We only use a constant amount of extra space for the sum variable.
     *
     * @param ar The list of integers to sum.
     * @return The sum of all integers in the array.
     */
    public static int simpleArraySum(List<Integer> ar) {
        
        // Initialize the sum
        int sum = 0;
        
        // Iterate over the array and accumulate the sum
        for (int num : ar) {
            sum += num;
        }

        // Return the final sum
        return sum;

    }

    public static void main(String[] args) {
        
        // Create a test array
        List<Integer> array = List.of(1, 2, 3, 4, 5);
        
        // Calculate the sum using our function
        int sum = simpleArraySum(array);
        
        // Print the result
        System.out.println("The sum of the array is: " + sum);
    }

}
