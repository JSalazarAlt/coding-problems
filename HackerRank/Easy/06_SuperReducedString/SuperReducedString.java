import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SuperReducedString {

    /**
     * Solves the "Super Reduced String" problem
     * (https://www.hackerrank.com/challenges/reduced-string/problem?isFullScreen=true).
     *
     * Given a string, repeatedly removes adjacent pairs of identical characters until
     * no more pairs can be removed. Returns the final reduced string, or "Empty String"
     * if the string becomes empty.
     *
     * Approach:
     * 1. Use a pointer to traverse the string from left to right.
     * 2. When adjacent identical characters are found, remove both characters.
     * 3. After removal, backtrack the pointer to check for new adjacent pairs.
     * 4. Continue until no more adjacent pairs exist.
     * 5. Return the reduced string or "Empty String" if completely reduced.
     *
     * Time Complexity: O(n²)
     * - In worst case, each character removal requires O(n) string operations.
     * - Up to n/2 removals possible, leading to O(n²) overall complexity.
     *
     * Space Complexity: O(n)
     * - String operations create new string objects during substring operations.
     *
     * @param s The input string to reduce.
     * @return The super reduced string, or "Empty String" if completely reduced.
     */
    public static String superReducedString(String s) {
        
        // Get initial string length and set pointer to second character
        int n = s.length();
        int i = 1;
        
        // Traverse the string looking for adjacent identical characters
        while (i < n) {
            // Check if current character matches the previous character
            if (s.charAt(i) == s.charAt(i - 1)) {
                // Remove both adjacent identical characters
                s = s.substring(0, i - 1) + s.substring(i + 1);
                
                // Backtrack pointer to check for new adjacent pairs after removal
                if (i > 1) {
                    i -= 2; // Move back two positions if possible
                } else {
                    i--; // Move back one position if at the beginning
                }
                
                // Update string length after removal
                n -= 2;
            }
            
            // Move to next character
            i++;
        }
        
        // Return the reduced string or "Empty String" if completely reduced
        return s.isEmpty() ? "Empty String" : s;
        
    }

    public static void main(String[] args) {
        
        try {
            
            // Declare the Scanner object to read the file
            File file = new File("test_cases.txt");
            Scanner scanner = new Scanner(file);

            // Read the number of test cases
            int t = scanner.nextInt();

            for (int test = 1; test <= t; test++) {

                // Read the string
                String s = scanner.next();

                // Print the result for the corresponding test case. The results should be:
                // Test Case #1: abd
                // Test Case #2: Empty String
                // Test Case #3: Empty String
                // Test Case #4: Empty String
                // Test Case #5: Empty String
                String result = superReducedString(s);
                System.out.println("Test Case #" + test + ":");
                System.out.println("Reduced string = " + result);
                System.out.println();
            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open the project with 05_TwoStrings as source directory.");

        }

    }


}