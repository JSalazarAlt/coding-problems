/**
 * Solves the "Fibonacci Number" problem
 * (https://leetcode.com/problems/fibonacci-number/).
 *
 * The Fibonacci numbers, commonly denoted F(n), form a sequence where each number
 * is the sum of the two preceding ones, starting from 0 and 1. Given n, calculates F(n).
 * The Fibonacci sequence is defined as: F(0) = 0, F(1) = 1, F(n) = F(n-1) + F(n-2) for n > 1.
 *
 * Approach (Iterative Bottom-Up):
 * 1. Handle base cases F(0) = 0 and F(1) = 1 directly.
 * 2. Use two variables to track the previous two Fibonacci numbers.
 * 3. Iterate from 2 to n, calculating each Fibonacci number.
 * 4. Update the two tracking variables for the next iteration.
 * 5. Return the final calculated Fibonacci number.
 *
 * Time Complexity: O(n)
 * - Single loop from 2 to n with constant time operations.
 *
 * Space Complexity: O(1)
 * - Only using constant extra space for variables.
 *
 * @param {number} n The position in the Fibonacci sequence (non-negative integer).
 * @returns {number} The nth Fibonacci number.
 */
var fib = function(n) {
    
    // Base cases - first two Fibonacci numbers
    if (n === 0) return 0; // F(0) = 0 by definition
    if (n === 1) return 1; // F(1) = 1 by definition

    // Iterative calculation using two variables to track previous values
    let prev = 0;  // F(n-2)
    let curr = 1;  // F(n-1)
    
    // Calculate F(2) through F(n)
    for (let i = 2; i <= n; i++) {
        const next = prev + curr; // F(i) = F(i-1) + F(i-2)
        prev = curr;              // Update F(i-2) for next iteration
        curr = next;              // Update F(i-1) for next iteration
    }

    return curr;
};

/**
 * Main function to run Fibonacci Number test cases.
 * 
 * Reads test cases from file, processes each case, and displays results
 * showing the nth Fibonacci number for each input.
 */
function main() {
    const fs = require('fs');
    
    // Read test cases from file
    const data = fs.readFileSync('test_cases.txt', 'utf8').trim().split('\n');
    const numTests = parseInt(data[0]);
    
    // Run each test case
    for (let i = 1; i <= numTests; i++) {
        const n = parseInt(data[i]);
        const result = fib(n);
        
        console.log(`Test ${i}: n = ${n}`);
        console.log(`The term ${n} of the Fibonacci series: fib(${n}) = ${result}`);
    }
}

// Execute main function
main();