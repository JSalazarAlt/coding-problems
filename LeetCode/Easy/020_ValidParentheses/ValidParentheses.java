import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
    
    /**
     * Solves the "Valid Parentheses" problem
     * (https://leetcode.com/problems/valid-parentheses/).
     *
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
     * determines if the input string is valid. An input string is valid if:
     * 1. Open brackets must be closed by the same type of brackets.
     * 2. Open brackets must be closed in the correct order.
     *
     * Approach: (Stack - Push Expected Closing Bracket)
     * 1. Use a stack to track expected closing brackets.
     * 2. For opening brackets, push the corresponding closing bracket.
     * 3. For closing brackets, check if it matches the top of stack.
     * 4. String is valid if stack is empty at the end.
     *
     * Time Complexity: O(n)
     * - Single pass through the string with constant time stack operations.
     *
     * Space Complexity: O(n)
     * - Stack can store up to n/2 opening brackets in worst case.
     *
     * @param s The string containing parentheses to validate.
     * @return true if the parentheses are valid, false otherwise.
     */
    public static boolean isValid(String s) {

        // Length of the input string
        int n = s.length();
        
        // Stack to store expected closing brackets
        Stack<Character> stack = new Stack<Character>();

        // Iterate through each character in the string
        for (int i = 0; i < n; i++) {
            // For opening brackets, push corresponding closing bracket
            if (s.charAt(i) == '{') {
                stack.push('}');
            } else if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else {
                // For closing brackets, check if it matches expected closing bracket
                if (stack.isEmpty() || s.charAt(i) != stack.pop()) {
                    return false;
                }
            }
        }

        // Return if stack is empty (if all brackets are properly matched)
        return stack.isEmpty();
        
    }

    public static void main(String[] args) {
        
        try {
            
            // Declare the Scanner object to read the file
            File file = new File("test_cases.txt");
            Scanner scanner = new Scanner(file);

            // Read the number of test cases
            int t = scanner.nextInt();
            scanner.nextLine(); // Consume the newline after the number

            for (int test = 1; test <= t; test++) {
                
                // Read the input string
                String s = scanner.nextLine();
                
                // Print the number of test case
                System.out.print("Test Case #" + test + ": ");

                // Print the input string
                System.out.println("s = " + s);

                // Check if the parentheses is valid
                boolean isValid = isValid(s);

                // Print if the parentheses is valid
                System.out.println("Is valid parentheses?: " + isValid);
                System.out.println();

            }
            
            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: Open 020_ValidParentheses as source directory.");

        }

    }

}
