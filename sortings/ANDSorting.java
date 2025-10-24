// AND Sorting: https://codeforces.com/problemset/problem/1682/B

import java.util.Scanner;

public class ANDSorting {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n)
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int permutationLength = inputReader.nextInt();
            int[] permutation = readPermutation(permutationLength);
            int maximumX = optimalSolution(permutationLength, permutation);

            System.out.println(maximumX);
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int[] readPermutation(int permutationLength) {
        int[] permutation = new int[permutationLength];

        for (int index = 0; index < permutationLength; index++) {
            int element = inputReader.nextInt();

            permutation[index] = element;
        }

        return permutation;
    }

    // Naive Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void naiveSolution(int permutationLength, int[] permutation) {
        // -
    }

    // Optimized Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void optimizedSolution(int permutationLength, int[] permutation) {
        // -
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static int optimalSolution(int permutationLength, int[] permutation) {
        // The largest number within the constraints that has all 1’s in its binary representation.
        int maximumX = 262143;

        for (int index = 0; index < permutationLength; index++) {
            int element = permutation[index];

            if (element != index) {
                maximumX &= element;
            }
        }

        return maximumX;
    }
}
