// Very Different Array: https://codeforces.com/problemset/problem/1921/D

import java.util.Scanner;
import java.util.Arrays;

public class VeryDifferentArray {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n * lg(n))
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int arrayOneLength = inputReader.nextInt();
            int arrayTwoLength = inputReader.nextInt();
            int[] arrayOne = readArray(arrayOneLength);
            int[] arrayTwo = readArray(arrayTwoLength);
            long maximumDifference = optimalSolution(arrayOneLength, arrayTwoLength, arrayOne, arrayTwo);

            System.out.println(maximumDifference);
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
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void naiveSolution() {
        // -
    }

    // Optimized Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void optimizedSolution() {
        // -
    }

    // Optimal Solution
    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(1)
    private static long optimalSolution(int arrayOneLength, int arrayTwoLength, int[] arrayOne, int[] arrayTwo) {
        int rightIndexOne = arrayOneLength - 1;
        int leftIndexTwo = 0;
        int leftIndexOne = 0;
        int rightIndexTwo = arrayTwoLength - 1;
        long maximumDifference = 0;

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        for (int iteration = 0; iteration < arrayOneLength; iteration++) {
            int rightElementOne = arrayOne[rightIndexOne];
            int leftElementTwo = arrayTwo[leftIndexTwo];
            int leftElementOne = arrayOne[leftIndexOne];
            int rightElementTwo = arrayTwo[rightIndexTwo];
            long differenceTwo = Math.abs(rightElementOne - leftElementTwo);
            long differenceOne = Math.abs(leftElementOne - rightElementTwo);

            if (differenceTwo < differenceOne) {
                leftIndexOne++;
                rightIndexTwo--;
                maximumDifference += differenceOne;
            } else {
                rightIndexOne--;
                leftIndexTwo++;
                maximumDifference += differenceTwo;
            }
        }

        return maximumDifference;
    }
}
