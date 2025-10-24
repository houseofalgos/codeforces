// Towers: https://codeforces.com/problemset/problem/37/A

import java.util.Scanner;

public class Towers {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalBars = inputReader.nextInt();
        int[] barLengths = readBarLengths(totalBars);

        optimalSolution(barLengths);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int[] readBarLengths(int totalBars) {
        int[] barLengths = new int[totalBars];

        for (int barIndex = 0; barIndex < totalBars; barIndex++) {
            int barLength = inputReader.nextInt();

            barLengths[barIndex] = barLength;
        }

        return barLengths;
    }

    // Naive Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void naiveSolution(int[] barLengths) {
        // -
    }

    // Optimized Solution
    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(1)
    private static void optimizedSolution(int[] barLengths) {
        // Sort the array of bar lengths, then find the maximum frequency and total unique lengths.
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static void optimalSolution(int[] barLengths) {
        int maximumBarLength = 1001;
        int[] barLengthCounts = new int[maximumBarLength];
        int totalUniques = 0;
        int maximumCount = Integer.MIN_VALUE;

        for (int barLength : barLengths) {
            barLengthCounts[barLength]++;
        }

        for (int barLength = 0; barLength < maximumBarLength; barLength++) {
            int barLengthCount = barLengthCounts[barLength];

            if (0 < barLengthCount) {
                totalUniques++;
            }

            maximumCount = Math.max(maximumCount, barLengthCount);
        }

        System.out.println(maximumCount + " " + totalUniques);
    }
}
