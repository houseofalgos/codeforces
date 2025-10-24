// Progressive Square: https://codeforces.com/problemset/problem/1955/B

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class ProgressiveSquare {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n^2)
    // Space Complexity: O(n^2)
    public static void main(String[] parameters) {
        int totalCases = inputReader.nextInt();

        while (0 < totalCases--) {
            int dimension = inputReader.nextInt();
            int downIncrement = inputReader.nextInt();
            int rightIncrement = inputReader.nextInt();
            int arrayLength = dimension * dimension;
            int[] array = readArray(arrayLength);

            if (rightIncrement < downIncrement) {
                int temp = downIncrement;

                downIncrement = rightIncrement;
                rightIncrement = temp;
            }

            optimalSolution(dimension, downIncrement, rightIncrement, arrayLength, array);
        }
    }

    // Time Complexity: O(n^2)
    // Space Complexity: O(n^2)
    private static int[] readArray(int arrayLength) {
        int[] array = new int[arrayLength];

        for (int index = 0; index < arrayLength; index++) {
            int element = inputReader.nextInt();

            array[index] = element;
        }

        return array;
    }

    // Naive Solution
    // Time Complexity: O((n^2)! * n^2)
    // Space Complexity: O(n^2)
    private static void naiveSolution(
            int dimension,
            int downIncrement,
            int rightIncrement,
            int arrayLength,
            int[] array
    ) {
        // Generate all permutations and check if any can form a progressive square.
    }

    // Optimized Solution
    // Time Complexity: O(?)
    // Space Complexity: O(?)
    private static void optimizedSolution(
            int dimension,
            int downIncrement,
            int rightIncrement,
            int arrayLength,
            int[] array
    ) {
        // Generate all permutations and check if any can form a progressive square.
        // Store intermediate results for later use as optimization.
    }

    // Optimal Solution
    // Time Complexity: O(n^2)
    // Space Complexity: O(n^2)
    private static void optimalSolution(
            int dimension,
            int downIncrement,
            int rightIncrement,
            int arrayLength,
            int[] array
    ) {
        Map<Integer, Integer> elementFrequencies = new HashMap<>();
        int minimumElement = Integer.MAX_VALUE;

        for (int index = 0; index < arrayLength; index++) {
            int element = array[index];
            int elementFrequency = elementFrequencies.getOrDefault(element, 0) + 1;

            elementFrequencies.put(element, elementFrequency);
            minimumElement = Math.min(minimumElement, element);
        }

        for (int row = 0; row < dimension; row++) {
            for (int column = 0; column < dimension; column++) {
                int element = minimumElement + (row * downIncrement) + (column * rightIncrement);
                int elementFrequency = elementFrequencies.getOrDefault(element, 0);

                if (elementFrequency == 0) {
                    System.out.println("NO");
                    return;
                }

                elementFrequencies.put(element, elementFrequency - 1);
            }
        }

        System.out.println("YES");
    }
}
