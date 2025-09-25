from typing import List

def simpleArraySum(ar: List[int]) -> int:
    """
    Solves the "Simple Array Sum" problem
    (https://www.hackerrank.com/challenges/simple-array-sum/problem?isFullScreen=true).

    Given an array of integers, calculate and return the sum of all elements.

    Approach:
    1. Use Python's built-in sum() function to calculate the total.
    2. This internally iterates through all elements and accumulates the sum.

    Time Complexity: O(n)
    - The sum() function iterates through the array once, where n is the number of elements.

    Space Complexity: O(1)
    - The sum() function uses constant extra space.

    Args:
        ar: The list of integers to sum.

    Returns:
        The sum of all integers in the array.
    """
    # Return the sum of all elements using Python's built-in sum function
    return sum(ar)

def main():
    # Create a test array
    ar = [1, 2, 3, 4, 5]
    
    # Calculate the sum using our function
    result = simpleArraySum(ar)
    
    # Print the result
    print(f"The sum of the array is: {result}")

if __name__ == "__main__":
    main()