// Mahmoud And A Triangle: https://codeforces.com/problemset/problem/766/B

import java.util.Scanner;
import java.util.Arrays;

public class MahmoudAndATriangle {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalLineSegments = inputReader.nextInt();
        int[] lineSegments = readLineSegments(totalLineSegments);

        optimalSolution(totalLineSegments, lineSegments);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int[] readLineSegments(int totalLineSegments) {
        int[] lineSegments = new int[totalLineSegments];

        for (int lineSegmentIndex = 0; lineSegmentIndex < totalLineSegments; lineSegmentIndex++) {
            int lineSegment = inputReader.nextInt();

            lineSegments[lineSegmentIndex] = lineSegment;
        }

        return lineSegments;
    }

    // Naive Solution
    // Time Complexity: O(n^3)
    // Space Complexity: O(1)
    private static void naiveSolution(int totalLineSegments, int[] lineSegments) {
        // For each line segment from left to right, check every possible pair to its right and verify all three
        // triangle inequalities.
    }

    // Optimized Solution
    // Time Complexity: O(n^2 * lg(n))
    // Space Complexity: O(1)
    private static void optimizedSolution(int totalLineSegments, int[] lineSegments) {
        // Sort the array once, and for each pair of sides, use binary search to find the smallest third side such that
        // all three triangle inequalities are satisfied.
    }

    // Optimal Solution
    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(1)
    private static void optimalSolution(int totalLineSegments, int[] lineSegments) {
        Arrays.sort(lineSegments);

        for (int lineSegmentIndex = 0; lineSegmentIndex < totalLineSegments - 2; lineSegmentIndex++) {
            int shortestLineSegment = lineSegments[lineSegmentIndex];
            int mediumLineSegment = lineSegments[lineSegmentIndex + 1];
            int longestLineSegment = lineSegments[lineSegmentIndex + 2];

            if (longestLineSegment < shortestLineSegment + mediumLineSegment) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}
