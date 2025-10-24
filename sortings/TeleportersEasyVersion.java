// Teleporters (Easy Version): https://codeforces.com/problemset/problem/1791/G1

import java.util.Scanner;
import java.util.Arrays;

public class TeleportersEasyVersion {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n * lg(n))
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int totalPoints = inputReader.nextInt();
            int totalCoins = inputReader.nextInt();
            int[] points = readPoints(totalPoints);
            int maximumTeleports = optimalSolution(totalPoints, totalCoins, points);

            System.out.println(maximumTeleports);
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int[] readPoints(int totalPoints) {
        int[] points = new int[totalPoints];

        for (int point = 0; point < totalPoints; point++) {
            int teleportCost = inputReader.nextInt();

            points[point] = teleportCost;
        }

        return points;
    }

    // Naive Solution
    // Time Complexity: O(2^n)
    // Space Complexity: O(n)
    private static void naiveSolution(int totalPoints, int totalCoins, int[] points) {
        // Generate all sequences of operations and keep track of maximum teleports.
    }

    // Optimized Solution
    // Time Complexity: O(?)
    // Space Complexity: O(?)
    private static void optimizedSolution(int totalPoints, int totalCoins, int[] points) {
        // Generate all sequences of operations and keep track of maximum teleports.
        // Store intermediate results for later use as optimization.
    }

    // Optimal Solution
    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(1)
    private static int optimalSolution(int totalPoints, int totalCoins, int[] points) {
        int maximumTeleports = 0;

        for (int point = 0; point < totalPoints; point++) {
            int actualTeleportCost = points[point] + point + 1;

            points[point] = actualTeleportCost;
        }

        Arrays.sort(points);

        for (int teleportCost : points) {
            if (teleportCost <= totalCoins) {
                totalCoins -= teleportCost;
                maximumTeleports++;
            }
        }

        return maximumTeleports;
    }
}
