// Absent Remainder: https://codeforces.com/problemset/problem/1613/B

import java.util.Scanner;

public class AbsentRemainder {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n)
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int arrayLength = inputReader.nextInt();
            int[] array = readArray(arrayLength);

            optimalSolution(arrayLength, array);
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int[] readArray(int arrayLength) {
        int[] array = new int[arrayLength];

        for (int index = 0; index < arrayLength; index++) {
            int element = inputReader.nextInt();

            array[index] = element;
        }

        return array;
    }

    // Naive Solution
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    private static void naiveSolution(int arrayLength, int[] array) {
        // Add all elements of the array to a HashSet.
        // For every possible pair, if their modulo result is not already in the set, increment the counter.
    }

    // Optimized Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void optimizedSolution(int arrayLength, int[] array) {
        // -
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static void optimalSolution(int arrayLength, int[] array) {
        int minimumElement = Integer.MAX_VALUE;
        int pairsFound = 0;
        int targetPairCount = arrayLength / 2;

        for (int element : array) {
            minimumElement = Math.min(minimumElement, element);
        }

        for (int element : array) {
            if (pairsFound == targetPairCount) {
                break;
            } else if (element != minimumElement) {
                System.out.println(element + " " + minimumElement);
                pairsFound++;
            }
        }
    }
}
