from typing import List

def get_max_additional_diners_count(n: int, k: int, m: int, s: List[int]) -> int:
    """Solve the "Cafeteria" puzzle from Meta Careers.
    
    A cafeteria table consists of a row of n seats, numbered from 1 to n from left to right.
    Social distancing guidelines require that every diner be seated such that k seats to
    their left and k seats to their right (or all the remaining seats to that side if
    there are fewer than k) remain empty. There are currently m diners seated at the table,
    the ith of whom is in seat s[i]. No two diners are sitting in the same seat, and the
    social distancing guidelines are currently being followed.
    
    Approach (Interval Processing):
    1. Add boundary seats (1 and n) to handle edge cases uniformly.
    2. Sort all occupied seats to process intervals between them.
    3. For each interval, calculate maximum additional diners considering k-distance rule.
    4. Handle boundary intervals differently (no existing diner on one side).
    
    Time Complexity: O(m log m)
    - Sorting m occupied seats dominates the complexity.
    
    Space Complexity: O(m)
    - Modified list with boundary seats.
    
    Args:
        n: Total number of seats in the cafeteria.
        k: Required empty seats on each side of a diner.
        m: Number of currently seated diners.
        s: List of seat numbers where diners are currently seated.
        
    Returns:
        Maximum number of additional diners that can be seated.
    """
    # Add boundary seats to handle edge cases uniformly
    s.append(1)
    s.append(n)
    
    # Sort occupied seats to process intervals sequentially
    s = sorted(s)
    
    # Initialize count of additional diners
    result = 0
    # Process each interval between consecutive occupied seats
    for i in range(m + 1):
        # Handle boundary intervals (start or end of table)
        if ((i == 0) or (i == m)):
            # Calculate available seats in boundary interval
            temp = ((s[i + 1] - s[i]) // (k + 1))
            if (temp > 0):
                result += temp
        else:
            # Handle middle intervals (between two existing diners)
            # Subtract 1 to account for k-distance from both existing diners
            temp = ((s[i + 1] - s[i]) // (k + 1)) - 1
            if (temp > 0):
                result += temp
    return result

def read_test_cases(file_path):
    """Read test cases from a file for the Cafeteria problem.
    
    File format:
    - First line: number of test cases
    - For each test case:
      - Line 1: n (total number of seats)
      - Line 2: k (required empty seats on each side)
      - Line 3: m (number of currently seated diners)
      - Line 4: m space-separated integers (occupied seat numbers)
    
    Args:
        file_path: Path to the test cases file.
        
    Returns:
        List of dictionaries, each containing 'n', 'k', 'm', and 's' for a test case.
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
        # Read total number of seats
        n = int(lines[index].strip())
        index += 1
        # Read required empty seats on each side
        k = int(lines[index].strip())
        index += 1
        # Read number of currently seated diners
        m = int(lines[index].strip())
        index += 1
        # Read occupied seat numbers (if any diners present)
        if m > 0:
            s = list(map(int, lines[index].strip().split()))
            index += 2
        else:
            s = []
        # Store test case data as dictionary
        data.append({'n': n, 'k': k, 'm': m, 's': s})

    return data

def main():
    """Run Cafeteria test cases.
    
    Reads test cases from file, processes each case, and displays results
    showing the maximum number of additional diners that can be seated.
    """
    # Path to test cases file
    file_path = "test_cases.txt"
    # Read all test cases from file
    test_cases_data = read_test_cases(file_path)
    
    # Process each test case
    for i, case in enumerate(test_cases_data, 1):
        # Display test case input
        print(f"Test Case #{i}: N = {case['n']} | K = {case['k']} | M = {case['m']} | S = {case['s']}")
        # Calculate maximum additional diners
        max_additional = get_max_additional_diners_count(case['n'], case['k'], case['m'], case['s'].copy())
        # Display result
        print(f"Maximum additional diners: max_additional = {max_additional}")
        print()

if __name__ == "__main__":
    main()