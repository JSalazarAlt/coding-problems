from typing import List

def compareTriplets(a: List[int], b: List[int]) -> List[int]:
    
    # Itialize the scores
    scores = [0, 0]
    
    # Iterate over the triplets
    for el_a, el_b in zip(a, b):
        if el_a > el_b:
            scores[0] = scores[0] + 1
        elif el_a < el_b:
            scores[1] = scores[1] + 1

    # Return the scores
    return scores

def main():
    a = [17, 28, 30]
    b = [99, 16, 8]
    result = compareTriplets(a, b)
    print(f"The scores of Alice and Bob are: {result}")

if __name__ == "__main__":
    main()