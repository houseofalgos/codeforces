// Binary Cut: https://codeforces.com/problemset/problem/1971/D

import java.util.Scanner;

public class BinaryCut {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n)
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            String string = inputReader.next();
            int minimumPieces = optimalSolution(string);

            System.out.println(minimumPieces);
        }
    }

    // Naive Solution
    // Time Complexity: O(2^n)
    // Space Complexity: O(n)
    private static void naiveSolution(String string) {
        // Generate all sequences of cuts and keep track of minimum pieces.
    }

    // Optimized Solution
    // Time Complexity: O(?)
    // Space Complexity: O(?)
    private static void optimizedSolution(String string) {
        // Generate all sequences of cuts and keep track of minimum pieces.
        // Store intermediate results for later use as optimization.
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static int optimalSolution(String string) {
        int stringLength = string.length();
        char lastBit = '-';
        boolean zeroOneFound = false;
        int totalConsecutiveSequences = 0;

        for (int index = 0; index < stringLength; index++) {
            char currentBit = string.charAt(index);

            if (currentBit != lastBit) {
                if (lastBit == '0' && currentBit == '1') {
                    zeroOneFound = true;
                }

                totalConsecutiveSequences++;
            }

            lastBit = currentBit;
        }

        if (zeroOneFound) {
            return totalConsecutiveSequences - 1;
        }

        return totalConsecutiveSequences;
    }
}
