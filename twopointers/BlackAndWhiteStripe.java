// Black And White Stripe: https://codeforces.com/problemset/problem/1690/D

import java.util.Scanner;

public class BlackAndWhiteStripe {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n)
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int stripLength = inputReader.nextInt();
            int segmentLength = inputReader.nextInt();
            String strip = inputReader.next();
            int minimumChangesRequired = optimalSolution(stripLength, segmentLength, strip);

            System.out.println(minimumChangesRequired);
        }
    }

    // Naive Solution
    // Time Complexity: O(n * k)
    // Space Complexity: O(1)
    private static void naiveSolution(int stripLength, int segmentLength, String strip) {
        // Check every possible window of length k and count how many W's are in each.
        // Track and return the minimum number of 'W's among all windows.
    }

    // Optimized Solution
    // Time Complexity: O(n - k)
    // Space Complexity: O(n)
    private static void optimizedSolution(int stripLength, int segmentLength, String strip) {
        // Precompute prefix sums where each index i stores the total number of W cells up to that point.
        // Then, for every window of length k, the number of whites can be obtained in O(1) using the difference of
        // two prefix values.
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static int optimalSolution(int stripLength, int segmentLength, String strip) {
        char black = 'B';
        int blackCount = 0;
        int minimumChangesRequired = Integer.MAX_VALUE;

        for (int index = 0; index < stripLength; index++) {
            char currentColor = strip.charAt(index);
            char previousColor = segmentLength <= index ? strip.charAt(index - segmentLength) : 'W';

            if (currentColor == black) {
                blackCount++;
            }

            if (previousColor == black && 0 < blackCount) {
                blackCount--;
            }

            if (segmentLength - 1 <= index) {
                int currentChangesRequired = segmentLength - blackCount;

                minimumChangesRequired = Math.min(minimumChangesRequired, currentChangesRequired);
            }
        }

        return minimumChangesRequired;
    }
}
