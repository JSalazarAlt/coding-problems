def get_artistic_photograph_count(n: int, c: str, x: int, y: int) -> int:
    """Solve the "Director of Photography" puzzle from Meta Careers.
    
    A photographer is organizing a photo shoot and is searching for artistic photographs.
    She has a long hallway with n cells in a row, numbered from 1 to n from left to right.
    Each cell contains one of the following:
    - A photographer (P)
    - An actor (A) 
    - A backdrop (B)
    - Nothing (.)
    
    A photograph is considered artistic if it consists of a photographer, an actor, and
    a backdrop, such that each are between x and y cells apart from each other.
    
    Approach (Brute Force with Range Constraints):
    1. For each actor position, check all valid photographer and backdrop combinations.
    2. Consider both arrangements: P-A-B and B-A-P.
    3. Use range constraints [x, y] to limit search space.
    4. Count all valid artistic photograph configurations.
    
    Time Complexity: O(n * y^2)
    - For each actor, check at most y positions for P and B in both directions.
    
    Space Complexity: O(1)
    - Only using constant extra space for counters.
    
    Args:
        n: Number of cells in the hallway.
        c: String representing the contents of each cell.
        x: Minimum distance between photographer/actor and actor/backdrop.
        y: Maximum distance between photographer/actor and actor/backdrop.
        
    Returns:
        Total number of artistic photographs possible.
    """
    # Counter for total artistic photographs
    total = 0

    # Check each cell for actors
    for i in range(n):
        # Skip if current cell doesn't contain an actor
        if c[i] != 'A':
            continue
        
        # Configuration 1: Photographer to the left, backdrop to the right (P-A-B)
        for p in range(max(0, i - y), i - x + 1):
            # Check if photographer exists at valid distance to the left
            if c[p] == 'P':
                # Look for backdrops at valid distance to the right
                for b in range(i + x, min(n, i + y + 1)):
                    if c[b] == 'B':
                        total += 1

        # Configuration 2: Backdrop to the left, photographer to the right (B-A-P)
        for b in range(max(0, i - y), i - x + 1):
            # Check if backdrop exists at valid distance to the left
            if c[b] == 'B':
                # Look for photographers at valid distance to the right
                for p in range(i + x, min(n, i + y + 1)):
                    if c[p] == 'P':
                        total += 1
    
    return total

def read_test_cases(file_path):
    """Read test cases from a file for the Director of Photography problem.
    
    File format:
    - First line: number of test cases
    - For each test case:
      - Line 1: n (number of cells in hallway)
      - Line 2: x (minimum distance constraint)
      - Line 3: y (maximum distance constraint)
      - Line 4: String c representing hallway contents
    
    Args:
        file_path: Path to the test cases file.
        
    Returns:
        List of dictionaries, each containing 'n', 'c', 'x', and 'y' for a test case.
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
        # Read number of cells in hallway
        n = int(lines[index].strip())
        index += 1
        # Read hallway configuration string
        c = lines[index].strip()
        index += 1
        # Read minimum distance constraint
        x = int(lines[index].strip())
        index += 1
        # Read maximum distance constraint
        y = int(lines[index].strip())
        index += 2
        # Store test case data as dictionary
        data.append({'n': n, 'c': c, 'x': x, 'y': y})

    return data

def main():
    """Run Director of Photography test cases.
    
    Reads test cases from file, processes each case, and displays results
    showing the total number of artistic photographs possible.
    """
    # Path to test cases file
    file_path = "test_cases.txt"
    # Read all test cases from file
    test_cases_data = read_test_cases(file_path)
    
    # Process each test case
    for i, case in enumerate(test_cases_data, 1):
        # Display test case input
        print(f"Test Case #{i}: N = {case['n']} | X = {case['x']} | Y = {case['y']} | C = {case['c']}")
        # Calculate total artistic photographs
        photo_count = get_artistic_photograph_count(case['n'], case['c'], case['x'], case['y'])
        # Display result
        print(f"Total artistic photographs: photo_count = {photo_count}")
        print()

if __name__ == "__main__":
    main()