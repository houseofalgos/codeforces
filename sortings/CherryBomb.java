// Cherry Bomb: https://codeforces.com/problemset/problem/2106/C

import java.util.Scanner;

public class CherryBomb {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n)
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int arrayLength = inputReader.nextInt();
            int maximumElementTwo = inputReader.nextInt();
            int[] arrayOne = readArray(arrayLength);
            int[] arrayTwo = readArray(arrayLength);
            int totalPermutations = optimalSolution(arrayLength, maximumElementTwo, arrayOne, arrayTwo);

            System.out.println(totalPermutations);
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
    // Time Complexity: O(m^n)
    // Space Complexity: O(n)
    private static void naiveSolution(int arrayLength, int maximumElementTwo, int[] arrayOne, int[] arrayTwo) {
        // Try all possible values for b_i from 0 to maximumElementTwo and keep track of valid complementary array count.
    }

    // Optimized Solution
    // Time Complexity: O(?)
    // Space Complexity: O(?)
    private static void optimizedSolution(int arrayLength, int maximumElementTwo, int[] arrayOne, int[] arrayTwo) {
        // Try all possible values for b_i from 0 to maximumElementTwo and keep track of valid complementary array count.
        // Store intermediate results for later use as optimization.
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static int optimalSolution(int arrayLength, int maximumElementTwo, int[] arrayOne, int[] arrayTwo) {
        int totalMissingElements = 0;
        int previousSum = -1;
        int largestElement = Integer.MIN_VALUE;
        int smallestElement = Integer.MAX_VALUE;

        for (int index = 0; index < arrayLength; index++) {
            int elementOne = arrayOne[index];
            int elementTwo = arrayTwo[index];

            if (elementTwo == -1) {
                totalMissingElements++;
            } else {
                int currentSum = elementOne + elementTwo;

                if (previousSum != -1 && currentSum != previousSum) {
                    return 0;
                }

                previousSum = currentSum;
            }

            if (largestElement < elementOne) {
                largestElement = elementOne;
            }

            smallestElement = Math.min(smallestElement, elementOne);
        }

        if (totalMissingElements == arrayLength) {
            int maximumComplementCount = (smallestElement + maximumElementTwo) - largestElement + 1;

            return Math.max(maximumComplementCount, 0);
        }

        if (previousSum <= smallestElement + maximumElementTwo && largestElement <= previousSum) {
            return 1;
        }

        return 0;
    }
}
