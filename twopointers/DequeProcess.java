// Deque Process: https://codeforces.com/problemset/problem/2128/B

import java.util.Scanner;

public class DequeProcess {
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
    // Time Complexity: O(2^n)
    // Space Complexity: O(n)
    private static void naiveSolution(int arrayLength, int[] array) {
        // For every possible sequence of n removals (each being L or R), simulate the removals to build q.
        // After all removals, check if the resulting array q is good.
    }

    // Optimized Solution
    // Time Complexity: O(?)
    // Space Complexity: O(?)
    private static void optimizedSolution(int arrayLength, int[] array) {
        // For every possible sequence of n removals (each being L or R), simulate the removals to build q.
        // After all removals, check if the resulting array q is good.
        // Store intermediate results for later use as optimization.
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static void optimalSolution(int arrayLength, int[] array) {
        int leftIndex = 0;
        int rightIndex = arrayLength - 1;
        boolean pickSmaller = true;

        while (leftIndex <= rightIndex) {
            int leftElement = array[leftIndex];
            int rightElement = array[rightIndex];
            boolean pickLeftElement = pickSmaller ? leftElement < rightElement : rightElement < leftElement;

            if (pickLeftElement) {
                System.out.print("L");
                leftIndex++;
            } else {
                System.out.print("R");
                rightIndex--;
            }

            pickSmaller = !pickSmaller;
        }

        System.out.println();
    }
}
