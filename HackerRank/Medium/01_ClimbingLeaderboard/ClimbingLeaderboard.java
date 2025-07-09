import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClimbingLeaderboard {
    
    /**
     * Solves the "Climbing the Leaderboard" problem 
     * (https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem?isFullScreen=true).
     *
     * Given a descending list of scores (ranked) with possible duplicates (indicating tied ranks),
     * and a list of player scores (player), we should return a list of the player's ranks
     * after each game.
     *
     * Approach (Remove Duplicates - Modify Binary Search):
     * 1. Remove duplicates of the ranked list to build a list of unique scores (newRanked), 
     *    which represents distinct ranking positions.
     * 2. For each player's score:
     *    - If it's higher than the top score, assign rank 1.
     *    - If it's lower than the lowest score, assign rank = length of unique scores + 1.
     *    - Otherwise, perform a modified binary search to find the correct rank position.
     * 3. Return the list of ranks for each player's score.
     * 
     * The binary search is adapted to work on a descending list and returns the rank
     * where the player's score would fit.
     *
     * Time Complexity: O(n + m log n)
     * - O(n) to build the unique ranked list.
     * - O(m log n) to process m player scores using binary search on n unique scores.
     *
     * Space Complexity: O(n + m)
     * - O(n) to build the ranked list without duplicates.
     * - O(m) to build the result list for each player.
     * 
     * @param ranked The list of integers representing the existing leaderboard scores in descending order.
     * @param player The list of integers representing the player's scores in the order they were achieved.
    * @return The list of integers where each element is the player's rank after each score.
     */
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {

        // Retrieve the size of the lists
        int n = ranked.size();
        int m = player.size();
        
        // Declare the list of players ranks to return
        List<Integer> playersRanks = new ArrayList<Integer>();
        
        // Declare a new list of ranks without duplicates
        List<Integer> newRanked = new ArrayList<Integer>();
        newRanked.add(ranked.get(0));
        
        // Build up the list of ranks without duplicates
        for (int i = 1; i < n; i++) {
            if (!ranked.get(i).equals(ranked.get(i - 1))) {
                newRanked.add(ranked.get(i));
            }
        }
        
        // Iterate over the players' scores
        for (int i = 0; i < m; i++) {
            if (player.get(i) > newRanked.get(0)) {
                playersRanks.add(1);
            } else if (player.get(i) < newRanked.get(newRanked.size() - 1)) {
                playersRanks.add(newRanked.size() + 1);
            } else {
                playersRanks.add(modifiedBinarySearch(newRanked, player.get(i)));
            }
        }
        
        // Return the list of players ranks
        return playersRanks;
        
    }
    
    /**
     * Performs a modified binary search to determine the rank position of the player's score
     * within a list of unique leaderboard scores sorted in descending order.
     *
     * The method returns the rank where the player's score would be inserted
     * to maintain the descending order.
     *
     * @param newRanked The list of unique (no duplicates) leaderboard scores in descending order.
     * @param target The player's score to rank.
     * @return The rank of the player's score within the leaderboard.
     */
    public static int modifiedBinarySearch(List<Integer> newRanked, int target) {
        
        int left = 0;
        int right = newRanked.size() - 1;
        
        while (left <= right) {
            
            int mid = left + (right - left) / 2;
            
            if (newRanked.get(mid).equals(target)) {
                return mid + 1;
            } else if (newRanked.get(mid) > target) {
                left = mid;
            } else {
                right = mid;
            }
            
            if (left == right - 1) {
                return right + 1;
            }
            
        }
        
        return 0;
    }

    public static void main(String[] args) {
        
        try {
            
            // Declare the Scanner object to read the file
            File file = new File("test_cases.txt");
            Scanner scanner = new Scanner(file);

            // Read the number of test cases
            int t = scanner.nextInt();

            for (int test = 1; test <= t; test++) {
                
                // Read the number of elements of "ranked" list
                int n = scanner.nextInt();

                // Read the elements of "ranked" list
                List<Integer> ranked = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    ranked.add(scanner.nextInt());
                }

                // Read the number of elements of "player" list
                int m = scanner.nextInt();
                
                // Read the elements of "player" list
                List<Integer> player = new ArrayList<>();
                for (int i = 0; i < m; i++) {
                    player.add(scanner.nextInt());
                }

                // Print the number of test case
                System.out.print("Test Case #" + test + ": ");

                // Print the input ranked array
                System.out.print("ranked = " + ranked + " | ");

                // Print the input player array
                System.out.println("player = " + player);

                // Compute the list of players ranks
                List<Integer> playersRanks = climbingLeaderboard(ranked, player);
                
                // Print the list of players ranks
                System.out.println(playersRanks);
                System.out.println();

            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open the project with 01_ClimbingLeaderboard as source directory.");

        }

    }
    
}    