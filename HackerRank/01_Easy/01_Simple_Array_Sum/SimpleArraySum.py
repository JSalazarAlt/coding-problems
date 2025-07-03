from typing import List

def simpleArraySum (ar: List[int]) -> int:
    # Return the sum of elements
    return sum(ar)

def main():
    ar = [1, 2, 3, 4, 5]
    sum = simpleArraySum(ar)
    print(f"The sum of the arrays is: {sum}")

if __name__ == "__main__":
    main()