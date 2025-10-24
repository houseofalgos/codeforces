// Building An Aquarium: https://codeforces.com/problemset/problem/1873/E

import java.util.Scanner;

public class BuildingAnAquarium {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n * lg(m2))
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int totalCorals = inputReader.nextInt();
            int maximumWaterUnits = inputReader.nextInt();
            int[] coralHeights = readCoralHeights(totalCorals);
            long maximumHeight = optimalSolution(totalCorals, maximumWaterUnits, coralHeights);

            System.out.println(maximumHeight);
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int[] readCoralHeights(int totalCoral) {
        int[] coralHeights = new int[totalCoral];

        for (int coral = 0; coral < totalCoral; coral++) {
            int coralHeight = inputReader.nextInt();

            coralHeights[coral] = coralHeight;
        }

        return coralHeights;
    }

    // Naive Solution
    // Time Complexity: O(n * m1)
    // Space Complexity: O(1)
    private static long naiveSolution(int maximumWaterUnits, int[] coralHeights) {
        int maximumCoralHeight = Integer.MIN_VALUE;

        for (int coralHeight : coralHeights) {
            maximumCoralHeight = Math.max(maximumCoralHeight, coralHeight);
        }

        long emptyUnits = 0;

        for (int height = 1; emptyUnits < maximumWaterUnits; height++) {
            for (int coralHeight : coralHeights) {
                if (coralHeight < height) {
                    emptyUnits++;
                }
            }

            if (emptyUnits == maximumWaterUnits) {
                return height;
            } else if (maximumWaterUnits < emptyUnits) {
                return height - 1;
            }
        }

        return maximumCoralHeight;
    }

    // Optimized Solution
    // Time Complexity: O(n * m2)
    // Space Complexity: O(1)
    private static long optimizedSolution(int totalCorals, int maximumWaterUnits, int[] coralHeights) {
        int maximumCoralHeight = Integer.MIN_VALUE;

        for (int coralHeight : coralHeights) {
            maximumCoralHeight = Math.max(maximumCoralHeight, coralHeight);
        }

        long emptyUnits = 0;

        for (int height = 1; height <= maximumCoralHeight; height++) {
            for (int coralHeight : coralHeights) {
                if (coralHeight < height) {
                    emptyUnits++;
                }
            }

            if (emptyUnits == maximumWaterUnits) {
                return height;
            } else if (maximumWaterUnits < emptyUnits) {
                return height - 1;
            }
        }

        long remainingWaterUnits = maximumWaterUnits - emptyUnits;

        return maximumCoralHeight + (remainingWaterUnits / totalCorals);
    }

    // Optimal Solution
    // Time Complexity: O(n * lg(m2))
    // Space Complexity: O(1)
    private static long optimalSolution(int totalCorals, int maximumWaterUnits, int[] coralHeights) {
        int maximumCoralHeight = Integer.MIN_VALUE;

        for (int coralHeight : coralHeights) {
            maximumCoralHeight = Math.max(maximumCoralHeight, coralHeight);
        }

        int heightLeftBound = 1;
        int heightRightBound = maximumCoralHeight;
        long emptyUnits = 0;

        while (heightLeftBound <= heightRightBound) {
            int height = heightLeftBound + (heightRightBound - heightLeftBound) / 2;
            long currentEmptyUnits = 0;

            for (int coralHeight : coralHeights) {
                if (coralHeight < height) {
                    currentEmptyUnits += height - coralHeight;
                }
            }

            if (currentEmptyUnits == maximumWaterUnits) {
                return height;
            } else if (maximumWaterUnits < currentEmptyUnits) {
                heightRightBound = height - 1;
            } else {
                heightLeftBound = height + 1;
                emptyUnits = currentEmptyUnits;
            }
        }

        long remainingWaterUnits = maximumWaterUnits - emptyUnits;

        if (totalCorals <= remainingWaterUnits) {
            return maximumCoralHeight + (remainingWaterUnits / totalCorals);
        }

        return heightLeftBound - 1;
    }
}
