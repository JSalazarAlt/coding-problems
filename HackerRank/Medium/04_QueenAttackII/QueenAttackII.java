import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class QueenAttackII {
    
    /**
     * Solves the "Queen's Attack II" problem
     * (https://www.hackerrank.com/challenges/queens-attack-2/problem?isFullScreen=true).
     *
     * Given an n×n chessboard with a queen at position (r_q, c_q) and k obstacles,
     * calculates the number of squares the queen can attack in all 8 directions
     * (horizontal, vertical, and diagonal).
     *
     * Approach:
     * 1. Calculate maximum possible squares the queen can attack in each of the 8 directions
     *    without considering obstacles (based on board boundaries).
     * 2. For each obstacle, check if it lies on any of the queen's attack paths:
     *    - Same row (horizontal): diff_r == 0
     *    - Same column (vertical): diff_c == 0  
     *    - Same diagonal: |diff_r| == |diff_c|
     * 3. If an obstacle blocks a path, update the maximum attackable squares in that
     *    direction to be one less than the distance to the obstacle.
     * 4. Sum up all attackable squares across the 8 directions.
     *
     * Time Complexity: O(k)
     * - O(k) to iterate through all obstacles and check their impact on attack paths.
     *
     * Space Complexity: O(1)
     * - Only using a constant amount of extra space for direction counters.
     *
     * @param n The size of the chessboard (n×n).
     * @param k The number of obstacles on the board.
     * @param r_q The row position of the queen (1-indexed).
     * @param c_q The column position of the queen (1-indexed).
     * @param obstacles List of obstacle positions, each represented as [row, column].
     * @return The total number of squares the queen can attack.
     */
    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        
        // Initialize variables to count available squares in all 8 possible directions
        int maxSquaresRight = n - c_q;
        int maxSquaresLeft = c_q - 1;
        int maxSquaresUp = n - r_q;
        int maxSquaresDown = r_q - 1;
        int maxSquaresRightUp = Math.min(n - c_q, n - r_q);
        int maxSquaresRightDown = Math.min(n - c_q, r_q - 1);
        int maxSquaresLeftUp = Math.min(c_q - 1, n - r_q);
        int maxSquaresLeftDown = Math.min(c_q - 1, r_q - 1);
        
        // Declare the total available squares in the 8 possible directions
        int totalAttackSquares;
        
        // Iterate over the obstacles to check if they are on the way of the queen
        for (int i = 0; i < k; i++) {
            
            // Retrieve the row and column of the i-th obstacle
            int r_o = obstacles.get(i).get(0);
            int c_o = obstacles.get(i).get(1);
            
            // Compute the difference of rows and columns between the i-th obstacle and queen
            int diff_r = r_q - r_o;
            int diff_c = c_q - c_o;
            
            // Check maximum available squares to right and left
            if (diff_r == 0) {
                if ((diff_c < 0) && (Math.abs(diff_c) < maxSquaresRight)) {
                    maxSquaresRight = Math.abs(diff_c) - 1;
                } else if ((diff_c > 0) && (Math.abs(diff_c) < maxSquaresLeft)) {
                    maxSquaresLeft = Math.abs(diff_c) - 1;
                }
            }
            
            // Check maximum available squares up and down
            if (diff_c == 0) {
                if ((diff_r < 0) && (Math.abs(diff_r) < maxSquaresUp)) {
                    maxSquaresUp = Math.abs(diff_r) - 1;
                } else if ((diff_r > 0) && (Math.abs(diff_r) < maxSquaresDown)) {
                    maxSquaresDown = Math.abs(diff_r) - 1;
                }
            }
            
            // Checks maximum available squares in diagonals
            if (Math.abs(diff_c) == Math.abs(diff_r)) {
                if (diff_c > 0 && diff_r > 0) {
                    maxSquaresLeftDown = Math.min(Math.abs(diff_c) - 1, maxSquaresLeftDown);
                } else if (diff_c > 0 && diff_r < 0) {
                    maxSquaresLeftUp = Math.min(Math.abs(diff_c) - 1, maxSquaresLeftUp);
                } else if (diff_c < 0 && diff_r > 0) {
                    maxSquaresRightDown = Math.min(Math.abs(diff_c) - 1, maxSquaresRightDown);
                } else {
                    maxSquaresRightUp = Math.min(Math.abs(diff_c) - 1, maxSquaresRightUp);
                }
            }
            
        }
        
        // Sum the available squares in the 8 possible directions
        totalAttackSquares = maxSquaresRight + maxSquaresLeft + maxSquaresUp + 
            maxSquaresDown + maxSquaresRightUp + maxSquaresRightDown + maxSquaresLeftUp + maxSquaresLeftDown;
        
        // Return the total available squares in the 8 possible directions
        return totalAttackSquares;
        
    }

    public static void main(String[] args) {
        
        try {
            
            // Declare the Scanner object to read the file
            File file = new File("test_cases.txt");
            Scanner scanner = new Scanner(file);

            // Read the number of test cases
            int t = scanner.nextInt();

            for (int test = 1; test <= t; test++) {
                
                // Read the number of rows and columns
                int n = scanner.nextInt();

                // Read the number of obstacles
                int k = scanner.nextInt();

                // Read the number of row of the queen
                int r_q = scanner.nextInt();

                // Read the number of column of the queen
                int c_q = scanner.nextInt();
                
                // Read the obstacles as a list list
                List<List<Integer>> obstacles = new ArrayList<>();
                for (int i = 0; i < k; i++) {
                    int r_o = scanner.nextInt();
                    int c_o = scanner.nextInt();
                    List<Integer> obstacle = new ArrayList<Integer>();
                    obstacle.add(r_o);
                    obstacle.add(c_o);
                    obstacles.add(obstacle);
                }

                // Print the result for the corresponding test case. The results should be:
                // Test Case #1: 9
                // Test Case #2: 10
                // Test Case #3: 40
                int result = queensAttack(n, k, r_q, c_q, obstacles);
                System.out.println("Test Case #" + test + ":");
                System.out.println(result);
                System.out.println();
            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open the project with 04_QueenAttackII as source directory.");

        }

    }

}
