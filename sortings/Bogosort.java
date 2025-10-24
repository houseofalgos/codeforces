// Bogosort: https://codeforces.com/problemset/problem/1312/B

import java.util.Scanner;
import java.util.Arrays;

public class Bogosort {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n)
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int arrayLength = inputReader.nextInt();
            int[] array = readArray(arrayLength);

            optimalSolution(array);
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
    // Time Complexity: O(n! * n)
    // Space Complexity: O(n)
    private static void naiveSolution(int arrayLength, int[] array) {
        // Generate all permutations and test.
    }

    // Optimized Solution
    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(1)
    private static void optimizedSolution(int arrayLength, int[] array) {
        Arrays.sort(array);

        for (int index = arrayLength - 1; 0 <= index; index--) {
            int element = array[index];

            System.out.print(element + " ");
        }

        System.out.println();
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static void optimalSolution(int[] array) {
        int maximumElement = 101;
        int[] elementFrequencies = new int[maximumElement];

        for (int element : array) {
            elementFrequencies[element]++;
        }

        for (int element = maximumElement - 1; 0 < element; element--) {
            int elementFrequency = elementFrequencies[element];

            while (0 < elementFrequency--) {
                System.out.print(element + " ");
            }
        }

        System.out.println();
    }
}
