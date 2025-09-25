from typing import List

def get_minimum_deflated_discount(N: int, R: List[int]) -> int:
    """Solve the "Stack Stabilization I" puzzle from Meta Careers.
    
    There's a stack of N inflatable discs, with the ith disc from the top having
    an initial radius of R[i] inches. The goal is to deflate some discs such that
    if you were to look at the stack from the side, the outline would be non-decreasing
    from top to bottom. A disc can be deflated to any radius between 1 and its initial
    radius. Return the minimum number of discs that need to be deflated, or -1 if
    it's impossible.
    
    Approach (Greedy - Bottom-Up Processing):
    1. Check if solution is possible (each disc must have radius > its position).
    2. Process discs from bottom to top.
    3. If current disc radius >= disc below, deflate it to (radius_below - 1).
    4. Count total deflations needed.
    
    Time Complexity: O(N)
    - Single pass to check feasibility + single pass to process discs.
    
    Space Complexity: O(1)
    - Only using constant extra space for calculations.
    
    Args:
        N: Number of discs in the stack.
        R: List of initial radii of discs from top to bottom.
        
    Returns:
        Minimum number of discs to deflate, or -1 if impossible.
    """
    # Initialize the number of deflations needed
    minimum_deflations = 0
    
    # Check if solution is possible: each disc must have radius > its position
    for i in range(0, N):
        if (R[i] <= i):
            return -1
    
    # Process discs from second-to-bottom upward
    for i in range(1, N): 
        # If current disc radius >= disc below it
        if (R[N - i] <= R[N - i - 1]):
            # Deflate upper disc to be smaller than lower disc
            R[N - i - 1] = R[N - i] - 1
            # Increment deflation count
            minimum_deflations += 1
        
    return minimum_deflations

def read_test_cases(file_path):
    """Read test cases from a file for the Stack Stabilization I problem.
    
    File format:
    - First line: number of test cases
    - For each test case:
      - Line 1: N (number of discs)
      - Line 2: N space-separated integers (initial radii from top to bottom)
    
    Args:
        file_path: Path to the test cases file.
        
    Returns:
        List of dictionaries, each containing 'N' and 'R' for a test case.
    """
    # Read all lines from the test file
    with open(file_path, 'r') as file:
        lines = file.readlines()

    # Initialize line index for parsing
    index = 0
    # Read number of test cases
    test_cases = int(lines[index].strip())
    index += 1

    # List to store all test case data
    data = []
    # Process each test case
    for _ in range(test_cases):
        # Read number of discs in the stack
        N = int(lines[index].strip())
        index += 1
        # Read initial radii of discs from top to bottom
        R = list(map(int, lines[index].strip().split()))
        index += 1
        # Store test case data as dictionary
        data.append({'N': N, 'R': R})

    return data

def main():
    """Run Stack Stabilization I test cases.
    
    Reads test cases from file, processes each case, and displays results
    showing the minimum number of discs that need to be deflated.
    """
    # Path to test cases file
    file_path = "test_cases.txt"
    # Read all test cases from file
    test_cases_data = read_test_cases(file_path)
    
    # Process each test case
    for i, case in enumerate(test_cases_data, 1):
        # Display test case input
        print(f"Test Case #{i}: N = {case['N']} | R = {case['R']}")
        # Calculate minimum deflations needed
        min_deflations = get_minimum_deflated_discount(case['N'], case['R'].copy())
        # Display result
        print(f"Minimum deflations needed: min_deflations = {min_deflations}")
        print()

if __name__ == "__main__":
    main()