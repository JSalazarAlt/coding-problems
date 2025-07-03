import java.util.List;

public class SimpleArraySum {

    public static int simpleArraySum(List<Integer> ar) {
        
        // Initialize the sum
        int sum = 0;
        
        // Iterate over the array
        for (int num : ar) {
            sum += num;
        }

        // return the sum
        return sum;

    }

    public static void main(String[] args) {
        List<Integer> array = List.of(1, 2, 3, 4, 5);
        int sum = simpleArraySum(array);
        System.out.println("The sum of the array is: " + sum);
    }

}
