// Flower City Fence: https://codeforces.com/problemset/problem/1862/C

import java.util.Scanner;
import java.util.Arrays;

public class FlowerCityFence {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n)
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int totalPlanks = inputReader.nextInt();
            int[] verticalHeights = readVerticalHeights(totalPlanks);

            optimalSolution(totalPlanks, verticalHeights);
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int[] readVerticalHeights(int totalPlanks) {
        int[] verticalHeights = new int[totalPlanks];

        for (int index = 0; index < totalPlanks; index++) {
            int verticalHeight = inputReader.nextInt();

            verticalHeights[index] = verticalHeight;
        }

        return verticalHeights;
    }

    // Naive Solution
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    private static void naiveSolution(int totalPlanks, int[] verticalHeights) {
        // For each h_i in verticalHeights for i = 0 to n - 1, increase horizontalHeight of initial h_i planks by 1.
        // Check if the arrays verticalHeights and horizontalHeights are equal.
    }

    // Optimized Solution
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static void optimizedSolution(int totalPlanks, int[] verticalHeights) {
        int[] horizontalHeights = new int[totalPlanks];

        for (int verticalHeight : verticalHeights) {
            int index = verticalHeight - 1;

            if (totalPlanks <= index) {
                System.out.println("NO");
                return;
            }

            horizontalHeights[verticalHeight - 1]++;
        }

        for (int index = totalPlanks - 2; 0 <= index; index--) {
            int previousHeight = horizontalHeights[index + 1];

            horizontalHeights[index] += previousHeight;
        }

        boolean heightsEqual = Arrays.equals(verticalHeights, horizontalHeights);

        if (heightsEqual) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static void optimalSolution(int totalPlanks, int[] verticalHeights) {
        int horizontalHeight = 0;

        for (int indexTwo = totalPlanks; 1 <= indexTwo; indexTwo--) {
            while (horizontalHeight < totalPlanks && indexTwo <= verticalHeights[horizontalHeight]) {
                horizontalHeight++;
            }

            int verticalHeight = verticalHeights[indexTwo - 1];

            if (horizontalHeight != verticalHeight) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
