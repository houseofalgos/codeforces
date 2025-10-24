// Maximum Sum: https://codeforces.com/problemset/problem/1832/B

import java.util.Scanner;
import java.util.Arrays;

public class MaximumSum {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n * lg(n))
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int arrayLength = inputReader.nextInt();
            int totalOperations = inputReader.nextInt();
            int[] array = readArray(arrayLength);
            long maximumSum = optimalSolution(arrayLength, totalOperations, array);

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
    // Time Complexity: O(2^k)
    // Space Complexity: O(k)
    private static void naiveSolution(int arrayLength, int totalOperations, int[] array) {
        // Generate all sequences of operations and keep track of maximum sum.
    }

    // Optimized Solution
    // Time Complexity: O(?)
    // Space Complexity: O(?)
    private static void optimizedSolution(int arrayLength, int totalOperations, int[] array) {
        // Generate all sequences of operations and keep track of maximum sum.
        // Store intermediate results for later use as optimization.
    }

    // Optimal Solution
    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(n)
    private static long optimalSolution(int arrayLength, int totalOperations, int[] array) {
        long[] prefixSum = new long[arrayLength + 1];
        long minimumDeletedSum = Long.MAX_VALUE;

        Arrays.sort(array);

        for (int index = 0; index < arrayLength; index++) {
            long previousPrefixSum = prefixSum[index];
            int element = array[index];

            prefixSum[index + 1] = element + previousPrefixSum;
        }

        for (int leftSubArraySize = 0; leftSubArraySize <= totalOperations; leftSubArraySize++) {
            int rightSubArraySize = totalOperations -  leftSubArraySize;
            long leftSubArraySum = prefixSum[2 * leftSubArraySize];
            long rightSubArraySum = prefixSum[arrayLength] - prefixSum[arrayLength - rightSubArraySize];
            long currentDeletedSum = leftSubArraySum + rightSubArraySum;

            minimumDeletedSum = Math.min(minimumDeletedSum, currentDeletedSum);
        }

        return prefixSum[arrayLength] - minimumDeletedSum;
    }
}
