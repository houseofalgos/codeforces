// Variety Is Discouraged: https://codeforces.com/problemset/problem/2064/B

import java.util.Scanner;

public class VarietyIsDiscouraged {
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
    // Time Complexity: O(n^3)
    // Space Complexity: O(n)
    private static void naiveSolution() {
        // Enumerate all possible sub-arrays to remove and compute the resulting score for each.
        // Track the maximum score along with its corresponding start and end indices.
    }

    // Optimized Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void optimizedSolution() {
        // -
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static void optimalSolution(int arrayLength, int[] array) {
        int[] elementFrequencies = new int[arrayLength + 1];
        int runningSubArrayLength = 0;
        int longestSubArrayLength = 0;
        int endIndex = 0;

        for (int element : array) {
            elementFrequencies[element]++;
        }

        for (int index = 0; index < arrayLength; index++) {
            int element = array[index];
            int elementCount = elementFrequencies[element];

            if (elementCount == 1) {
                runningSubArrayLength++;
            } else {
                runningSubArrayLength = 0;
            }

            if (longestSubArrayLength < runningSubArrayLength) {
                longestSubArrayLength = runningSubArrayLength;
                endIndex = index;
            }
        }

        if (longestSubArrayLength == 0) {
            System.out.println(0);
        } else {
            int startIndex = endIndex - longestSubArrayLength + 2;

            System.out.println(startIndex + " " + ++endIndex);
        }
    }
}
