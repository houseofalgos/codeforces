// JoJo's Incredible Adventures: https://codeforces.com/problemset/problem/1820/B

import java.util.Scanner;

public class JoJosIncredibleAdventures {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n)
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            String string = inputReader.next();
            long largestArea = optimalSolution(string);

            System.out.println(largestArea);
        }
    }

    // Naive Solution
    // Time Complexity: O(n^3)
    // Space Complexity: O(n^2)
    private static void naiveSolution() {
        // Build the full rotation grid. For every cell containing ‘1’, treat it as the top-left corner of a rectangle
        // and expand downward and rightward to find the largest all-ones rectangle.
        // Track the global maximum area.
    }

    // Optimized Solution
    // Time Complexity: O(n^2)
    // Space Complexity: O(n^2)
    private static void optimizedSolution() {
        // Build the rotation grid. For each cell containing ‘1’, treat it as the bottom-right corner of a rectangle and
        // extend it using top and left rectangles.
        // Maintain the global maximum rectangular area.
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static long optimalSolution(String string) {
        int stringLength = string.length();
        int cyclicStringLength = stringLength * 2;
        int runningConsecutiveOnes = 0;
        int longestConsecutiveOnes = 0;
        int row = 0;
        long largestArea = 0;

        for (int cyclicIndex = 0; cyclicIndex < cyclicStringLength; cyclicIndex++) {
            int index = cyclicIndex % stringLength;
            char currentBit = string.charAt(index);

            if (currentBit == '1') {
                runningConsecutiveOnes++;

                longestConsecutiveOnes = Math.max(
                        longestConsecutiveOnes,
                        Math.min(
                                stringLength,
                                runningConsecutiveOnes
                        )
                );
            } else {
                runningConsecutiveOnes = 0;
            }
        }

        if (longestConsecutiveOnes == stringLength) {
            return (long) stringLength * stringLength;
        }

        while (0 < longestConsecutiveOnes) {
            long currentArea = (long) ++row * longestConsecutiveOnes--;

            largestArea = Math.max(largestArea, currentArea);
        }

        return largestArea;
    }
}
