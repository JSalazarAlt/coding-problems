import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoStrings {
    
    /**
     * Solves the "Two Strings" problem
     * (https://www.hackerrank.com/challenges/two-strings/problem?isFullScreen=true).
     *
     * Determines if two strings share at least one common character.
     * Returns "YES" if they share a common character, "NO" otherwise.
     *
     * Approach (HashSet of Unique Characters First String):
     * 1. Create a HashSet to store unique characters from the first string.
     * 2. Iterate through the first string and add each character to the set.
     * 3. Iterate through the second string and check if any character exists in the set.
     * 4. Return "YES" immediately when a common character is found.
     * 5. Return "NO" if no common characters are found after checking all characters.
     *
     * Time Complexity: O(n + m)
     * - O(n) to process first string and O(m) to process second string.
     * - Where n and m are the lengths of the two strings.
     *
     * Space Complexity: O(min(n, 26))
     * - HashSet stores at most min(n, 26) unique characters (26 lowercase letters).
     *
     * @param s1 The first string to compare.
     * @param s2 The second string to compare.
     * @return "YES" if strings share a common character, "NO" otherwise.
     */
    public static String twoStrings(String s1, String s2) {
        
        // Create a HashSet to store unique characters from first string
        Set<Character> set = new HashSet<Character>();
        
        // Populate the set with unique characters from first string
        for (int i = 0; i < s1.length(); i++) {
            // Add character to set (HashSet automatically handles duplicates)
            set.add(s1.charAt(i));
        }
        
        // Check if second string contains any character from first string
        for (int i = 0; i < s2.length(); i++) {
            // If common character found, return immediately
            if (set.contains(s2.charAt(i))) {
                return "YES";
            }
        }

        // No common characters found between the two strings
        return "NO";
        
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
                String s1 = scanner.next();

                // Read the string
                String s2 = scanner.next();

                // Print the number of test case
                System.out.print("Test Case #" + test + ": ");

                // Print the first input string
                System.out.print("s1 = " + s1 + " | ");

                // Print the second input string
                System.out.println("s2 = " + s2);

                // Check if the two strings have one common substring
                String commonSubString = twoStrings(s1, s2);
                
                // Print if the two strings have one common substring
                System.out.println(commonSubString);
                System.out.println();

            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open 05_TwoStrings as source directory.");

        }

    }


}