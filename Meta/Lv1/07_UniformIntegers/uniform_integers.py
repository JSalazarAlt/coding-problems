def get_uniform_integer_count_in_interval(A: int, B: int) -> int:
    """Solve the "Uniform Integers" puzzle from Meta Careers.
    
    A uniform integer is a positive integer which consists of only a single repeated
    digit. For example, 111 and 44 are uniform integers, while 123 and 9339 are not.
    Given two positive integers A and B, return the number of uniform integers between
    A and B, inclusive.
    
    Approach (Generate All Uniform Numbers):
    1. For each digit 1-9, generate all uniform numbers of that digit.
    2. Start with single digit, then build longer numbers by appending same digit.
    3. Count numbers that fall within the range [A, B].
    4. Stop when generated number exceeds B.
    
    Time Complexity: O(log B)
    - For each digit, generate at most log10(B) uniform numbers.
    
    Space Complexity: O(1)
    - Only using constant extra space for variables.
    
    Args:
        A: Lower bound of the range (inclusive).
        B: Upper bound of the range (inclusive).
        
    Returns:
        Count of uniform integers in the range [A, B].
    """
    # Counter for uniform integers in the range
    number_of_uniforms = 0
  
    # Generate uniform numbers for each digit 1-9
    for digit in range(1, 10):
        # Start with single digit uniform number
        num = digit
        # Generate longer uniform numbers by appending same digit
        while num <= B:
            # Check if current uniform number is in range [A, B]
            if num >= A:
                number_of_uniforms += 1
            # Build next uniform number (e.g., 1 -> 11 -> 111)
            num = num * 10 + digit
    return number_of_uniforms

def read_test_cases(file_path):
    """Read test cases from a file for the Uniform Integers problem.
    
    File format:
    - First line: number of test cases
    - For each test case:
      - Line 1: A B (space-separated integers representing the range)
    
    Args:
        file_path: Path to the test cases file.
        
    Returns:
        List of dictionaries, each containing 'A' and 'B' for a test case.
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
        # Read range bounds A and B
        A, B = map(int, lines[index].strip().split())
        index += 1
        # Store test case data as dictionary
        data.append({'A': A, 'B': B})

    return data

def main():
    """Run Uniform Integers test cases.
    
    Reads test cases from file, processes each case, and displays results
    showing the count of uniform integers in each range.
    """
    # Path to test cases file
    file_path = "test_cases.txt"
    # Read all test cases from file
    test_cases_data = read_test_cases(file_path)
    
    # Process each test case
    for i, case in enumerate(test_cases_data, 1):
        # Display test case input
        print(f"Test Case #{i}: A = {case['A']} | B = {case['B']}")
        # Calculate count of uniform integers in range
        uniform_count = get_uniform_integer_count_in_interval(case['A'], case['B'])
        # Display result
        print(f"Uniform integers in range [{case['A']}, {case['B']}]: count = {uniform_count}")
        print()

if __name__ == "__main__":
    main()