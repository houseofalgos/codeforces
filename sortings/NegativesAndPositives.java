// Negatives And Positives: https://codeforces.com/problemset/problem/1791/E

import java.util.Scanner;

public class NegativesAndPositives {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n)
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int arrayLength = inputReader.nextInt();
            int[] array = readArray(arrayLength);
            long maximumSum = optimalSolution(array);

            System.out.println(maximumSum);
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
    // Time Complexity: O(2^n)
    // Space Complexity: O(n)
    private static void naiveSolution(int[] array) {
        // Generate all sequences of operations and keep track of their sums.
    }

    // Optimized Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void optimizedSolution(int[] array) {
        // -
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static long optimalSolution(int[] array) {
        int totalNegatives = 0;
        long arraySum = 0;
        int smallestElement = Integer.MAX_VALUE;

        for (int element : array) {
            if (element < 0) {
                totalNegatives++;
            }

            element = Math.abs(element);
            arraySum += element;
            smallestElement = Math.min(smallestElement, element);
        }

        if (totalNegatives % 2 == 0) {
            return arraySum;
        }

        return arraySum - (2L * smallestElement);
    }
}
