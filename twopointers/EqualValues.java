// Equal Values: https://codeforces.com/problemset/problem/2111/C

import java.util.Scanner;

public class EqualValues {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n)
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int arrayLength = inputReader.nextInt();
            int[] array = readArray(arrayLength);
            long minimumCost = optimalSolution(arrayLength, array);

            System.out.println(minimumCost);
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
        // For each element in the array, calculate the total cost of making all other elements equal to it.
        // Keep track of the minimum total cost across all choices.
    }

    // Optimized Solution
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static long optimizedSolution(int arrayLength, int[] array) {
        boolean[] prefixEquals = getPrefixEquals(arrayLength, array);
        boolean[] suffixEquals = getSuffixEquals(arrayLength, array);
        long minimumCost = Long.MAX_VALUE;

        for (int leftIndex = 0; leftIndex < arrayLength; leftIndex++) {
            int rightIndex = leftIndex;
            long currentElement = array[leftIndex];
            boolean prefixEqual = prefixEquals[leftIndex];
            long currentCost = 0;

            while (rightIndex < arrayLength - 1 && array[rightIndex + 1] == currentElement) {
                rightIndex++;
            }

            boolean suffixEqual = suffixEquals[rightIndex];

            if (!prefixEqual) {
                currentCost += currentElement * leftIndex;
            }

            if (!suffixEqual) {
                currentCost += currentElement * (arrayLength - rightIndex - 1);
            }

            minimumCost = Math.min(minimumCost, currentCost);
            leftIndex = rightIndex;
        }

        return minimumCost;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static boolean[] getPrefixEquals(int arrayLength, int[] array) {
        boolean[] prefixEquals = new boolean[arrayLength];

        prefixEquals[0] = true;

        for (int index = 1; index < arrayLength; index++) {
            int currentElement = array[index];
            int previousElement = array[index - 1];

            prefixEquals[index] = prefixEquals[index - 1] && (currentElement == previousElement);
        }

        return prefixEquals;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static boolean[] getSuffixEquals(int arrayLength, int[] array) {
        boolean[] suffixEquals = new boolean[arrayLength];

        suffixEquals[arrayLength - 1] = true;

        for (int index = arrayLength - 2; 0 <= index; index--) {
            int currentElement = array[index];
            int previousElement = array[index + 1];

            suffixEquals[index] = suffixEquals[index + 1] && (currentElement == previousElement);
        }

        return suffixEquals;
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static long optimalSolution(int arrayLength, int[] array) {
        long previousElement = -1;
        int segmentLength = 0;
        long minimumCost = Long.MAX_VALUE;

        for (int index = 0; index < arrayLength; index++) {
            long currentElement = array[index];

            if (index == 0 || currentElement == previousElement) {
                segmentLength++;
            } else {
                segmentLength = 1;
            }

            long currentCost = (currentElement * (index - segmentLength + 1)) +
                    (currentElement * (arrayLength - index - 1));

            minimumCost = Math.min(minimumCost, currentCost);
            previousElement = currentElement;
        }

        return minimumCost;
    }
}
