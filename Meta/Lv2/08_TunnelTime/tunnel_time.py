from typing import List

def get_seconds_elapsed(c: int, n: int, a: List[int], b: List[int], k: int) -> int:
    """Solve the Tunnel Time problem from Meta coding challenges:
    https://www.metacareers.com/profile/coding_puzzles?puzzle=1492699897743843
    
    A train travels around a circular track of length c. There are n tunnels
    on the track, where the ith tunnel covers the segment from a[i] to b[i].
    The train travels at 1 unit per second and wants to spend exactly k
    seconds inside tunnels. Find the position where the train should be when
    it has spent exactly k seconds in tunnels.
    
    Approach (Simulation with Optimization):
    1. Sort tunnel positions to process them in order.
    2. Calculate total tunnel time per complete lap.
    3. Use integer division to skip complete laps efficiently.
    4. Simulate the remaining partial lap to find exact position.
    5. Handle edge case where k is exactly divisible by tunnel time per lap.
    
    Time Complexity: O(n log n)
    - Sorting dominates the complexity, simulation is O(n).
    
    Space Complexity: O(n)
    - Space for sorted arrays and tunnel lengths.
    
    Args:
        c: Length of the circular track.
        n: Number of tunnels on the track.
        a: List of tunnel start positions.
        b: List of tunnel end positions.
        k: Target time to spend in tunnels.
        
    Returns:
        Position on track when exactly k seconds have been spent in tunnels.
    """
    # Sort tunnel start and end positions for ordered processing
    a_sorted = sorted(a)
    b_sorted = sorted(b)
    
    # Calculate length of each tunnel
    lengths = [y - x for x, y in zip(a_sorted, b_sorted)]
    
    # Calculate total time spent in tunnels per complete lap
    tunnel_time_per_lap = sum(lengths)
    
    # Calculate number of complete laps we can skip
    number_of_laps = k // tunnel_time_per_lap
    # Calculate tunnel time accumulated from complete laps
    train_tunnel_time = tunnel_time_per_lap * number_of_laps
    
    # Handle exact case: k is exactly divisible by tunnel time per lap
    if train_tunnel_time == k:
        # Train completes exactly at the end of last tunnel in final lap
        return c * number_of_laps - c + b_sorted[n - 1]
    
    # Simulate the remaining partial lap to find exact position
    for i in range(n):
        # Add time for current tunnel
        train_tunnel_time += b_sorted[i] - a_sorted[i]
        # Check if we've reached or exceeded target time k
        if train_tunnel_time >= k:
            # Calculate exact position within current tunnel
            return c * number_of_laps + b_sorted[i] - (train_tunnel_time - k)
    
    # Should never reach here given valid input
    return 0

def read_test_cases(file_path):
    """Read test cases from a file for the Tunnel Time problem.
    
    File format:
    - First line: number of test cases
    - For each test case:
      - Line 1: track length c
      - Line 2: number of tunnels n
      - Line 3: n space-separated tunnel start positions a[i]
      - Line 4: n space-separated tunnel end positions b[i]
      - Line 5: target tunnel time k
    
    Args:
        file_path: Path to the test cases file.
        
    Returns:
        List of dictionaries, each containing test case parameters.
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
        # Read track length
        c = int(lines[index].strip())
        index += 1
        # Read number of tunnels
        n = int(lines[index].strip())
        index += 1
        # Read tunnel start positions
        a = list(map(int, lines[index].strip().split()))
        index += 1
        # Read tunnel end positions
        b = list(map(int, lines[index].strip().split()))
        index += 1
        # Read target tunnel time
        k = int(lines[index].strip())
        index += 1
        # Store test case data as dictionary
        data.append({'c': c, 'n': n, 'a': a, 'b': b, 'k': k})

    return data

def main():
    """Run Tunnel Time test cases.
    
    Reads test cases from file, processes each case, and displays results
    showing the train position when exactly k seconds have been spent in
    tunnels.
    """
    # Path to test cases file
    file_path = "test_cases.txt"
    # Read all test cases from file
    test_cases_data = read_test_cases(file_path)
    
    # Process each test case
    for i, case in enumerate(test_cases_data, 1):
        # Display test case input
        print(f"Test Case {i}: C = {case['c']} | N = {case['n']} | "
              f"A = {case['a']} | B = {case['b']} | K = {case['k']}")
        # Calculate train position after k seconds in tunnels
        position = get_seconds_elapsed(
            case['c'], case['n'], case['a'], case['b'], case['k']
        )
        # Display result
        print(f"Train position after {case['k']} seconds in tunnels: "
              f"position = {position}")
        print()

if __name__ == "__main__":
    main()