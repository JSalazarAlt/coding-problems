from typing import List

def get_min_code_entry_time(N: int, M: int, C: List[int]) -> int:
    """Solve the "Rotary Lock I" puzzle from Meta Careers.
    
    You're trying to open a lock. The lock comes with a wheel which has N integers
    written around it in a circle. The wheel is initially pointing to 1. It takes
    1 second to rotate the wheel 1 position, and the wheel can rotate in either
    direction. You need to stop the wheel on the numbers specified in the code C
    in order.
    
    Approach (Greedy - Minimum Distance):
    1. Start from position 1 (initial position).
    2. For each target position, calculate distance in both directions.
    3. Choose the minimum distance (clockwise or counterclockwise).
    4. Accumulate total time needed.
    
    Time Complexity: O(M)
    - Single pass through all M code positions.
    
    Space Complexity: O(1)
    - Only using constant extra space for calculations.
    
    Args:
        N: Number of positions on the wheel (1 to N).
        M: Length of the code sequence.
        C: List of M integers representing the code sequence.
        
    Returns:
        Minimum time in seconds to enter the complete code.
    """
    # Total time in seconds to enter the code
    number_of_seconds = 0
    # Insert starting position (1) at the beginning of code sequence
    C.insert(0, 1)
    
    # Process each transition in the code sequence
    for i in range(0, M):
        # Calculate distances in both directions
        if (C[i + 1] > C[i]):
            # Target is ahead: clockwise distance
            seconds_to_right = C[i + 1] - C[i]
            # Counterclockwise distance (going around)
            seconds_to_left = N - (C[i + 1] - C[i])
        else:
            # Target is behind: counterclockwise distance
            seconds_to_left =  C[i] - C[i + 1]
            # Clockwise distance (going around)
            seconds_to_right = N - (C[i] - C[i + 1])
    
        # Add minimum time to reach next position
        number_of_seconds += min(seconds_to_right, seconds_to_left)
  
    return number_of_seconds

def read_test_cases(file_path):
    """Read test cases from a file for the Rotary Lock I problem.
    
    File format:
    - First line: number of test cases
    - For each test case:
      - Line 1: N (number of positions on wheel)
      - Line 2: M (length of code sequence)
      - Line 3: M space-separated integers (code sequence)
    
    Args:
        file_path: Path to the test cases file.
        
    Returns:
        List of dictionaries, each containing 'N', 'M', and 'C' for a test case.
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
        # Read number of positions on the wheel
        N = int(lines[index].strip())
        index += 1
        # Read length of code sequence
        M = int(lines[index].strip())
        index += 1
        # Read code sequence
        C = list(map(int, lines[index].strip().split()))
        index += 1
        # Store test case data as dictionary
        data.append({'N': N, 'M': M, 'C': C})

    return data

def main():
    """Run Rotary Lock I test cases.
    
    Reads test cases from file, processes each case, and displays results
    showing the minimum time needed to enter each code sequence.
    """
    # Path to test cases file
    file_path = "test_cases.txt"
    # Read all test cases from file
    test_cases_data = read_test_cases(file_path)
    
    # Process each test case
    for i, case in enumerate(test_cases_data, 1):
        # Display test case input
        print(f"Test Case #{i}: N = {case['N']} | M = {case['M']} | C = {case['C']}")
        # Calculate minimum time to enter code
        min_time = get_min_code_entry_time(case['N'], case['M'], case['C'].copy())
        # Display result
        print(f"Minimum time to enter code: min_time = {min_time}")
        print()

if __name__ == "__main__":
    main()