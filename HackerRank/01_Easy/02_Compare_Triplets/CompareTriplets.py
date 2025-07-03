from typing import List

def compareTriplets(a: List[int], b: List[int]) -> List[int]:
    """
    Solves the "Compare the Triplets" problem
    (https://www.hackerrank.com/challenges/compare-the-triplets/problem?isFullScreen=true).

    Alice and Bob each created one problem for HackerRank. A reviewer rates the two challenges,
    awarding points on a scale from 1 to 100 for three categories: problem clarity, originality, and difficulty.
    The rating for Alice's challenge is the triplet a = (a[0], a[1], a[2]), and the rating for Bob's challenge is the triplet b = (b[0], b[1], b[2]).
    The task is to find their comparison points by comparing a[0] with b[0], a[1] with b[1], and a[2] with b[2].

    Approach:
    1. Initialize scores for both Alice and Bob to 0.
    2. Use zip() to iterate through corresponding elements of both triplets simultaneously.
    3. Compare each pair of elements and increment the appropriate score.
    4. If Alice's element is greater, increment Alice's score (index 0).
    5. If Bob's element is greater, increment Bob's score (index 1).
    6. If elements are equal, neither gets a point.
    7. Return the final scores as a list [Alice's score, Bob's score].

    Time Complexity: O(1)
    - We always iterate exactly 3 times (constant), regardless of input size.

    Space Complexity: O(1)
    - We use a constant amount of extra space for the scores list.

    Args:
        a: The list of integers representing Alice's ratings.
        b: The list of integers representing Bob's ratings.

    Returns:
        The list of integers [Alice's score, Bob's score].
    """
    
    # Initialize the scores [Alice, Bob]
    scores = [0, 0]
    
    # Iterate over the triplets using zip for simultaneous iteration
    for el_a, el_b in zip(a, b):
        if el_a > el_b:
            scores[0] += 1  # Alice gets a point
        elif el_a < el_b:
            scores[1] += 1  # Bob gets a point
        # If equal, neither gets a point

    # Return the final scores
    return scores

def main():
    # Create test triplets for Alice and Bob
    a = [17, 28, 30]
    b = [99, 16, 8]
    
    # Compare the triplets and get the scores
    result = compareTriplets(a, b)
    
    # Print the result
    print(f"The scores of Alice and Bob are: {result}")

if __name__ == "__main__":
    main()