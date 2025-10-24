// Counting Orders: https://codeforces.com/problemset/problem/1827/A

import java.util.Scanner;
import java.util.Arrays;

public class CountingOrders {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n * lg(n))
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int arrayLength = inputReader.nextInt();
            int[] arrayOne = readArray(arrayLength);
            int[] arrayTwo = readArray(arrayLength);
            long totalPermutations = optimalSolution(arrayLength, arrayOne, arrayTwo);

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
    // Time Complexity: O(n!)
    // Space Complexity: O(n)
    private static void naiveSolution(int arrayLength, int[] arrayOne, int[] arrayTwo) {
        // Generate all permutations of a, then compare each a_i with b_i, counting how many permutations satisfy the
        // given condition.
    }

    // Optimized Solution
    // Time Complexity: O(?)
    // Space Complexity: O(?)
    private static void optimizedSolution(int arrayLength, int[] arrayOne, int[] arrayTwo) {
        // Generate all permutations of a, then compare each a_i with b_i, counting how many permutations satisfy the
        // given condition.
        // Store intermediate results for later use as optimization.
    }

    // Optimal Solution
    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(1)
    private static long optimalSolution(int arrayLength, int[] arrayOne, int[] arrayTwo) {
        long totalPermutations = 1;
        int mod = 1000000007;

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        for (int index = arrayLength - 1; 0 <= index; index--) {
            int leftIndex = 0;
            int rightIndex = arrayLength - 1;
            int elementTwo = arrayTwo[index];
            int elementOneOptions = 0;

            while (leftIndex <= rightIndex) {
                int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
                int elementOne = arrayOne[middleIndex];

                if (elementTwo < elementOne) {
                    elementOneOptions = arrayLength - middleIndex;
                    rightIndex = middleIndex - 1;
                } else {
                    leftIndex = middleIndex + 1;
                }
            }

            elementOneOptions -= arrayLength - index - 1;

            if (elementOneOptions <= 0) {
                return 0;
            }

            totalPermutations = (totalPermutations * elementOneOptions) % mod;
        }

        return totalPermutations;
    }

}
