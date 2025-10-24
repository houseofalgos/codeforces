// I Will Definitely Make It: https://codeforces.com/problemset/problem/2126/C

import java.util.Scanner;
import java.util.Arrays;

public class IWillDefinitelyMakeIt {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n * lg(n))
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int totalTowers = inputReader.nextInt();
            int position = inputReader.nextInt() - 1;
            int[][] towers = readTowers(totalTowers);

            optimalSolution(position, towers);
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int[][] readTowers(int totalTowers) {
        int[][] towers = new int[totalTowers][2];

        for (int index = 0; index < totalTowers; index++) {
            int height = inputReader.nextInt();

            towers[index][0] = index;
            towers[index][1] = height;
        }

        return towers;
    }

    // Naive Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void naiveSolution(int position, int[][] towers) {
        // -
    }

    // Optimized Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void optimizedSolution(int position, int[][] towers) {
        // -
    }

    // Optimal Solution
    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(1)
    private static void optimalSolution(int position, int[][] towers) {
        int lastHeight = -1;
        int waterLevel = 0;

        sortTowers(towers);

        for (int[] tower : towers) {
            int index = tower[0];
            int currentHeight = tower[1];

            if (index == position) {
                lastHeight = currentHeight;
            } else if (lastHeight != -1 && lastHeight < currentHeight) {
                int timeToWait = currentHeight - lastHeight;

                if (lastHeight - waterLevel < timeToWait) {
                    System.out.println("NO");
                    return;
                }

                lastHeight = currentHeight;
                waterLevel += timeToWait;
            }
        }

        System.out.println("YES");
    }

    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(1)
    private static void sortTowers(int[][] towers) {
        Arrays.sort(
                towers,
                (towerOne, towerTwo) -> {
                    int heightOne = towerOne[1];
                    int heightTwo = towerTwo[1];

                    return heightOne - heightTwo;
                }
        );
    }
}
