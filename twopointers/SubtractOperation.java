// Subtract Operation: https://codeforces.com/problemset/problem/1656/B

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class SubtractOperation {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n)
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int arrayLength = inputReader.nextInt();
            int targetElement = inputReader.nextInt();
            int[] array = readArray(arrayLength);

            optimalSolution(targetElement, array);
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
    private static void naiveSolution(int targetElement, int[] array) {
        // Try every possible order of subtraction operations. For each possible sequence of choosing and removing
        // elements, simulate all n − 1 operations and check if the final remaining element equals k.
    }

    // Optimized Solution
    // Time Complexity: O(?)
    // Space Complexity: O(?)
    private static void optimizedSolution(int targetElement, int[] array) {
        // Try every possible order of subtraction operations. For each possible sequence of choosing and removing
        // elements, simulate all n − 1 operations and check if the final remaining element equals k.
        // Store intermediate results for later use as optimization.
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static void optimalSolution(int targetElement, int[] array) {
        Set<Integer> elementsSeen = new HashSet<>();

        for (int element : array) {
            int complementaryElementOne = targetElement + element;
            int complementaryElementTwo = element - targetElement;

            if (
                    elementsSeen.contains(complementaryElementOne) ||
                            elementsSeen.contains(complementaryElementTwo)
            ) {
                System.out.println("YES");
                return;
            }

            elementsSeen.add(element);
        }

        System.out.println("NO");
    }
}
