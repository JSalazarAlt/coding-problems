from typing import List

def get_min_problem_count(n: int, s: List[int]) -> int:
    """Solve the Score Interference (Chapter I) puzzle from Meta Careers.
    
    A programming contest has n competitors, each trying to independently
    solve the same set of programming problems. Each problem has a point
    value, which is either 1 or 2.
    
    On the scoreboard, the ith competitor has attained a score of s[i],
    which is a positive integer equal to the sum of the point values of all
    the problems they have solved. The scoreboard does not display the
    number of problems in the contest, nor their point values. Using the
    information available, determine the minimum possible number of problems.
    
    Approach (Mathematical Analysis):
    1. Find the maximum score among all contestants.
    2. Check if any contestant has an odd score.
    3. If odd score exists, return (max_score // 2 + 1) for unique maximum.
    4. If all scores are even, return (max_score // 2) for tied maximum.
    
    Time Complexity: O(n)
    - Single pass to find max + single pass to check for odd scores.
    
    Space Complexity: O(1)
    - Only using constant extra space for variables.
    
    Args:
        n: Number of contestants.
        s: List of contestant scores.
        
    Returns:
        Minimum number of problems needed to achieve a winning score.
    """
    # Find the maximum score among all contestants
    max_score = max(s)
    
    # Check if any contestant has an odd score
    for i in range(n):
        # If odd score found, can achieve unique maximum
        if s[i] % 2 == 1:
            # Return problems needed for strictly greater score
            return max_score // 2 + 1
    
    # All scores are even, return problems needed to tie maximum
    return max_score // 2

def read_test_cases(file_path):
    """Read test cases from a file for the Score Interference I problem.
    
    File format:
    - First line: number of test cases
    - For each test case:
      - Line 1: number of contestants n
      - Line 2: n space-separated contestant scores
    
    Args:
        file_path: Path to the test cases file.
        
    Returns:
        List of dictionaries, each containing 'n' and 's' for a test case.
    """
    # Read all lines from the test file
    with open(file_path, 'r') as file:
        lines = file.readlines()

    # Initialize line index for parsing
    index = 0
    # Read number of test cases
    test_cases = int(lines[index].strip())
    index += 2

    # List to store all test case data
    data = []
    # Process each test case
    for _ in range(test_cases):
        # Read number of contestants
        n = int(lines[index].strip())
        index += 1
        # Read contestant scores
        s = list(map(int, lines[index].strip().split()))
        index += 2
        # Store test case data as dictionary
        data.append({'n': n, 's': s})

    return data

def main():
    """Run Score Interference I test cases.
    
    Reads test cases from file, processes each case, and displays results
    showing the minimum number of problems needed for each test case.
    """
    # Path to test cases file
    file_path = "test_cases.txt"
    # Read all test cases from file
    test_cases_data = read_test_cases(file_path)
    
    # Process each test case
    for i, case in enumerate(test_cases_data, 1):
        # Display test case input
        print(f"Test Case #{i}: N = {case['n']} | S = {case['s']}")
        # Calculate minimum problems needed
        min_problems = get_min_problem_count(case['n'], case['s'])
        # Display result
        print(f"The minimum number of problems: min_problems = {min_problems}")
        print()

if __name__ == "__main__":
    main()