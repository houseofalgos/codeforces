// Minimize The Thickness: https://codeforces.com/problemset/problem/1741/C

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MinimizeTheThickness {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * sqrt(n) * n)
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int arrayLength = inputReader.nextInt();
            int[] array = readArray(arrayLength);
            int minimumThickness = optimalSolution(arrayLength, array);

            System.out.println(minimumThickness);
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
    // Time Complexity: O(sum(a) * n)
    // Space Complexity: O(1)
    private static void naiveSolution(int arrayLength, int[] array) {
        // Try every possible target sum from 1 to the total array sum.
        // For each possible target sum, check if the array can be divided into contiguous segments having equal sum.
    }

    // Optimized Solution
    // Time Complexity: O((sum(a) - max(a)) * n)
    // Space Complexity: O(1)
    private static void optimizedSolution(int arrayLength, int[] array) {
        // Instead of checking all sums from 1 to total sum, only check target sums in the range [max(a), sum(a)],
        // because smaller targets are impossible (no segment can have sum < max element).
    }

    // Optimal Solution
    // Time Complexity: O(sqrt(n) * n)
    // Space Complexity: O(sqrt(n))
    private static int optimalSolution(int arrayLength, int[] array) {
        int arraySum = 0;

        for (int element : array) {
            arraySum += element;
        }

        List<Integer> targetSums = getDivisors(arraySum);
        int minimumSegmentLength = arrayLength;

        for (int targetSum : targetSums) {
            int runningSum = 0;
            int segmentLength = 0;
            int maximumSegmentLength = Integer.MIN_VALUE;

            for (int element : array) {
                runningSum += element;
                segmentLength++;

                if (runningSum == targetSum) {
                    maximumSegmentLength = Math.max(maximumSegmentLength, segmentLength);
                    runningSum = 0;
                    segmentLength = 0;
                }
            }

            if (runningSum == 0) {
                minimumSegmentLength = Math.min(minimumSegmentLength, maximumSegmentLength);
            }
        }

        return minimumSegmentLength;
    }

    // Time Complexity: O(sqrt(n))
    // Space Complexity: O(sqrt(n))
    private static List<Integer> getDivisors(int number) {
        int divisorLimit = (int) Math.sqrt(number);
        List<Integer> divisors = new ArrayList<>();

        for (int divisor = 1; divisor <= divisorLimit; divisor++) {
            if (number % divisor == 0) {
                int complementaryDivisor = number / divisor;

                divisors.add(divisor);

                if (divisor != complementaryDivisor) {
                    divisors.add(complementaryDivisor);
                }
            }
        }

        return divisors;
    }
}
