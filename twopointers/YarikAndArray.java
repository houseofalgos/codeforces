// Yarik And Array: https://codeforces.com/problemset/problem/1899/C

import java.util.Scanner;

public class YarikAndArray {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n)
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int arrayLength = inputReader.nextInt();
            int[] array = readArray(arrayLength);
            int maximumSum = optimalSolution(arrayLength, array);

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
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    private static void naiveSolution(int arrayLength, int[] array) {
        // Try every possible sub-array and keep track of the maximum sum seen so far.
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
    private static int optimalSolution(int arrayLength, int[] array) {
        boolean lastElementEven = array[0] % 2 == 0;
        int currentSum = array[0];
        int maximumSum = array[0];

        for (int index = 1; index < arrayLength; index++) {
            int element = array[index];
            boolean currentElementEven = element % 2 == 0;

            if (currentElementEven != lastElementEven) {
                currentSum = Math.max(element, currentSum + element);
            } else {
                currentSum = element;
            }

            lastElementEven = currentElementEven;
            maximumSum = Math.max(maximumSum, currentSum);
        }

        return maximumSum;
    }
}
