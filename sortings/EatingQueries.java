// Eating Queries: https://codeforces.com/problemset/problem/1676/E

import java.util.Scanner;
import java.util.Arrays;

public class EatingQueries {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * (n * lg(n) + q * lg(n)))
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int totalCandies = inputReader.nextInt();
            int totalQueries = inputReader.nextInt();
            int[] candies = readCandies(totalCandies);

            optimalSolution(totalCandies, totalQueries, candies);
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int[] readCandies(int totalCandies) {
        int[] candies = new int[totalCandies];

        for (int candy = 0; candy < totalCandies; candy++) {
            int sugarContent = inputReader.nextInt();

            candies[candy] = sugarContent;
        }

        return candies;
    }

    // Naive Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void naiveSolution(int totalCandies, int totalQueries, int[] candies) {
        // -
    }

    // Optimized Solution
    // Time Complexity: O(q * n)
    // Space Complexity: O(1)
    private static void optimizedSolution(int totalCandies, int totalQueries, int[] candies) {
        // Sort the candies in descending order, then for each query accumulate sugar from left to right until the
        // required amount is reached.
    }

    // Optimal Solution
    // Time Complexity: O(n * lg(n) + q * lg(n))
    // Space Complexity: O(n)
    private static void optimalSolution(int totalCandies, int totalQueries, int[] candies) {
        Arrays.sort(candies);

        for (int candy = totalCandies - 2; 0 <= candy; candy--) {
            candies[candy] += candies[candy + 1];
        }

        while (0 < totalQueries--) {
            int minimumSugarContent = inputReader.nextInt();
            int leftIndex = 0;
            int rightIndex = totalCandies - 1;
            int minimumCandies = -1;

            while (leftIndex <= rightIndex) {
                int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;

                if (minimumSugarContent <= candies[middleIndex]) {
                    leftIndex = middleIndex + 1;
                    minimumCandies = middleIndex;
                } else {
                    rightIndex = middleIndex - 1;
                }
            }

            if (minimumCandies == -1) {
                System.out.println(minimumCandies);
            } else {
                System.out.println(totalCandies - minimumCandies);
            }
        }
    }
}
