def get_uniform_integer_count_in_interval(a: int, b: int) -> int:
    """Solve the "Uniform Integers" puzzle from Meta Careers.
    
    A uniform integer is a positive integer which consists of only a single repeated
    digit. For example, 111 and 44 are uniform integers, while 123 and 9339 are not.
    Given two positive integers a and b, return the number of uniform integers between
    a and b, inclusive.
    
    Approach (Generate All Uniform Numbers):
    1. For each digit 1-9, generate all uniform numbers of that digit.
    2. Start with single digit, then build longer numbers by appending same digit.
    3. Count numbers that fall within the range [a, b].
    4. Stop when generated number exceeds b.
    
    Time Complexity: O(log b)
    - For each digit, generate at most log10(b) uniform numbers.
    
    Space Complexity: O(1)
    - Only using constant extra space for variables.
    
    Args:
        a: Lower bound of the range (inclusive).
        b: Upper bound of the range (inclusive).
        
    Returns:
        Count of uniform integers in the range [a, b].
    """
    # Counter for uniform integers in the range
    number_of_uniforms = 0
  
    # Generate uniform numbers for each digit 1-9
    for digit in range(1, 10):
        # Start with single digit uniform number
        num = digit
        # Generate longer uniform numbers by appending same digit
        while num <= b:
            # Check if current uniform number is in range [a, b]
            if num >= a:
                number_of_uniforms += 1
            # Build next uniform number (e.g., 1 -> 11 -> 111)
            num = num * 10 + digit
    return number_of_uniforms

def read_test_cases(file_path):
    """Read test cases from a file for the Uniform Integers problem.
    
    File format:
    - First line: number of test cases
    - For each test case:
      - Line 1: a b (space-separated integers representing the range)
    
    Args:
        file_path: Path to the test cases file.
        
    Returns:
        List of dictionaries, each containing 'a' and 'b' for a test case.
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
        # Read range bounds a and b
        a, b = map(int, lines[index].strip().split())
        index += 2
        # Store test case data as dictionary
        data.append({'a': a, 'b': b})

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
        print(f"Test Case #{i}: A = {case['a']} | B = {case['b']}")
        # Calculate count of uniform integers in range
        uniform_count = get_uniform_integer_count_in_interval(case['a'], case['b'])
        # Display result
        print(f"Uniform integers in range [{case['a']}, {case['b']}]: count = {uniform_count}")
        print()

if __name__ == "__main__":
    main()