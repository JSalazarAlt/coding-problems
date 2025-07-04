import java.util.ArrayList;
import java.util.List;

public class CompareTriplets {
    
    /**
     * Solves the "Compare the Triplets" problem
     * (https://www.hackerrank.com/challenges/compare-the-triplets/problem?isFullScreen=true).
     *
     * Alice and Bob each created one problem for HackerRank. A reviewer rates the two challenges,
     * awarding points on a scale from 1 to 100 for three categories: problem clarity, originality, and difficulty.
     * The rating for Alice's challenge is the triplet a = (a[0], a[1], a[2]), and the rating for Bob's challenge is the triplet b = (b[0], b[1], b[2]).
     * The task is to find their comparison points by comparing a[0] with b[0], a[1] with b[1], and a[2] with b[2].
     *
     * Approach:
     * 1. Initialize scores for both Alice and Bob to 0.
     * 2. Compare each corresponding element of the two triplets.
     * 3. If Alice's element is greater, increment Alice's score.
     * 4. If Bob's element is greater, increment Bob's score.
     * 5. If elements are equal, neither gets a point.
     * 6. Return the final scores as a list [Alice's score, Bob's score].
     *
     * Time Complexity: O(1)
     * - We always iterate exactly 3 times (constant), regardless of input size.
     *
     * Space Complexity: O(1)
     * - We use a constant amount of extra space for variables and result list.
     *
     * @param a The list of integers representing Alice's ratings.
     * @param b The list of integers representing Bob's ratings.
     * @return The list of integers [Alice's score, Bob's score].
     */
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        
        // Declare the list of scores to return
        List<Integer> scores = new ArrayList<Integer>();
        
        // Initialize the scores of Alice and Bob
        int scoreA = 0;
        int scoreB = 0;

        // Iterate over the triplets to compute the scores
        for (int i = 0; i < 3; i++) {
            if (a.get(i) < b.get(i)) {
                scoreB++;  // Bob gets a point
            } else if (a.get(i) > b.get(i)) {
                scoreA++;  // Alice gets a point
            }
            // If equal, neither gets a point
        }

        // Add the scores of Alice and Bob to the list of scores
        scores.add(scoreA);
        scores.add(scoreB);

        // Return the list of scores
        return scores;
        
    }

    public static void main(String[] args) {
        
        // Create test triplets for Alice and Bob
        List<Integer> a = List.of(1, 2, 3);
        List<Integer> b = List.of(3, 2, 1);
        
        // Compare the triplets and get the scores
        List<Integer> scores = compareTriplets(a, b);
        
        // Print the result
        System.out.println("The final scores of Alice and Bob are: " + scores);
    }

}
