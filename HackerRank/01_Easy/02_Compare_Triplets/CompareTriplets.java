import java.util.ArrayList;
import java.util.List;

public class CompareTriplets {
    
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        
        // Declare the list of scores to return
        List<Integer> scores = new ArrayList<Integer>();
        
        // Initialize the scores of Alice and Bob
        int scoreA = 0;
        int scoreB = 0;

        // Iterate over the triplets to compute the scores
        for (int i = 0; i < 3; i++) {
            if (a.get(i) < b.get(i)) {
                scoreB++;
            } else if (a.get(i) > b.get(i)) {
                scoreA++;
            }
        }

        // Add the scores of Alice and Bob to the list of scores
        scores.add(scoreA);
        scores.add(scoreB);

        // Return the list of scores
        return scores;
        
    }

    public static void main(String[] args) {
        List<Integer> a = List.of(1, 2, 3);
        List<Integer> b = List.of(3, 2, 1);
        List<Integer> scores = compareTriplets(a, b);
        System.out.println("The final scores of Alice and Bob are: " + scores);
    }

}
