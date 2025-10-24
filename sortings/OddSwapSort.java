// Odd Swap Sort: https://codeforces.com/problemset/problem/1638/B

import java.util.Scanner;

public class OddSwapSort {
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
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    private static void naiveSolution(int[][] array) {
        // From left to right, bubble each element to its correct position. If it ever meets a same-parity neighbor,
        // sorting becomes impossible.
    }

    // Optimized Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void optimizedSolution(int[][] array) {
        // -
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static void optimalSolution(int[] array) {
        int lastEven = Integer.MIN_VALUE;
        int lastOdd = Integer.MIN_VALUE;

        for (int element : array) {
            if (element % 2 == 0) {
                if (element < lastEven) {
                    System.out.println("NO");
                    return;
                }

                lastEven = element;

            } else {
                if (element < lastOdd) {
                    System.out.println("NO");
                    return;
                }

                lastOdd = element;
            }
        }

        System.out.println("YES");
    }
}
