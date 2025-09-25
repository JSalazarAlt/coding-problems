from typing import List
from collections import deque

def get_maximum_eaten_dish_count(n: int, d: List[int], k: int) -> int:
    """Solve the "Kaitenzushi" puzzle from Meta Careers.
    
    There are n dishes in a row on a kaiten belt, with the ith dish being of type d[i].
    Some dishes may be of the same type as one another. You're very hungry, so you decide
    to eat along the belt! Initially, your chopsticks are above the first dish (dish 1),
    and it takes 1 second to move your chopsticks to the next or previous dish.
    
    You'll eat a dish if and only if its type is different from the last k dishes you've eaten.
    Since you haven't eaten any dishes initially, you'll eat the first dish you encounter.
    After eating a dish, it takes 1 second to return your chopsticks to the position above
    the next dish on the belt, and you can't eat the same dish twice.
    
    Approach (Sliding Window with Set and Deque):
    1. Use a set to track the last k dish types eaten for O(1) lookup.
    2. Use a deque to maintain the order of the last k dishes eaten.
    3. For each dish, check if its type is in the set of last k eaten dishes.
    4. If not in set, eat the dish and update both set and deque.
    5. If deque exceeds k dishes, remove the oldest dish from both structures.
    
    Time Complexity: O(n)
    - Single pass through all dishes with O(1) set and deque operations.
    
    Space Complexity: O(k)
    - Set and deque store at most k dish types.
    
    Args:
        n: Number of dishes on the belt.
        d: List of dish types.
        k: Number of previously eaten dishes to remember.
        
    Returns:
        Maximum number of dishes that can be eaten.
    """
    # Set to track the last K dish types eaten for O(1) lookup
    eaten_dishes_set = set()
    # Deque to maintain the order of the last K dishes eaten
    eaten_dishes_dq = deque()
    # Counter for total dishes eaten
    total = 0
    # Iterate through each dish on the kaiten belt
    for i in range(n):
        # Check if current dish type is different from last k eaten dishes
        if d[i] not in eaten_dishes_set:
            # Eat the dish (increment total count)
            total += 1
            # Add dish type to the end of deque (most recent)
            eaten_dishes_dq.append(d[i])
            # Add dish type to set for fast future lookups
            eaten_dishes_set.add(d[i])
            # If we've tracked more than k dishes, remove the oldest
            if len(eaten_dishes_dq) > k:
                # Remove the oldest dish type from deque
                oldest = eaten_dishes_dq.popleft()
                # Remove the oldest dish type from set
                eaten_dishes_set.remove(oldest)
  
    return total

def read_test_cases(file_path):
    """Read test cases from a file for the Kaitenzushi problem.
    
    File format:
    - First line: number of test cases
    - For each test case:
      - Line 1: number of dishes n
      - Line 2: n space-separated dish types
      - Line 3: number k (memory of previously eaten dishes)
    
    Args:
        file_path: Path to the test cases file.
        
    Returns:
        List of dictionaries, each containing 'n', 'd', and 'k' for a test case.
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
        # Read number of dishes on the kaiten belt
        n = int(lines[index].strip())
        index += 1
        # Read dish types on the belt
        d = list(map(int, lines[index].strip().split()))
        index += 1
        # Read memory size (number of previously eaten dishes to remember)
        k = int(lines[index].strip())
        index += 2
        # Store test case data as dictionary
        data.append({'n': n, 'd': d, 'k': k})

    return data

def main():
    """Run Kaitenzushi test cases.
    
    Reads test cases from file, processes each case, and displays results
    showing the maximum number of dishes that can be eaten for each test case.
    """
    # Path to test cases file
    file_path = "test_cases.txt"
    # Read all test cases from file
    test_cases_data = read_test_cases(file_path)
    
    # Process each test case
    for i, case in enumerate(test_cases_data, 1):
        # Display test case input
        print(f"Test Case #{i}: N = {case['n']} | D = {case['d']} | K = {case['k']}")
        # Calculate maximum dishes that can be eaten
        dishes_eaten = get_maximum_eaten_dish_count(case['n'], case['d'], case['k'])
        # Display result
        print(f"Maximum dishes eaten: dishes_eaten = {dishes_eaten}")
        print()

if __name__ == "__main__":
    main()