// Dragons: https://codeforces.com/problemset/problem/230/A

import java.util.Scanner;
import java.util.Arrays;

public class Dragons {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static void main(String[] parameters) {
        int playerStrength = inputReader.nextInt();
        int totalDragons = inputReader.nextInt();
        int[][] dragons = readDragons(totalDragons);

        optimalSolution(playerStrength, dragons);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int[][] readDragons(int totalDragons) {
        int[][] dragons = new int[totalDragons][2];

        for (int index = 0; index < totalDragons; index++) {
            int dragonStrength = inputReader.nextInt();
            int killBonus = inputReader.nextInt();

            dragons[index][0] = dragonStrength;
            dragons[index][1] = killBonus;
        }

        return dragons;
    }

    // Naive Solution
    // Time Complexity: O(n! * n)
    // Space Complexity: O(n)
    private static void naiveSolution(int playerStrength, int totalDragons, int[][] dragons) {
        // Generate all permutations and test them.
        // Store intermediate results for later use as optimization.
    }

    // Optimized Solution
    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(1)
    private static void optimizedSolution(int playerStrength, int totalDragons, int[][] dragons) {
        sortDragons(dragons);

        for (int dragonIndex = 0; dragonIndex < totalDragons; dragonIndex++) {
            int dragonStrength = dragons[dragonIndex][0];

            if (dragonStrength < playerStrength) {
                int killBonus = dragons[dragonIndex][1];

                playerStrength += killBonus;
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(1)
    private static void sortDragons(int[][] dragons) {
        Arrays.sort(
                dragons,
                (dragonOne, dragonTwo) -> {
                    int dragonOneStrength = dragonOne[0];
                    int dragonTwoStrength = dragonTwo[0];

                    return dragonOneStrength - dragonTwoStrength;
                }
        );
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static void optimalSolution(int playerStrength, int[][] dragons) {
        int maximumDragonStrength = Integer.MIN_VALUE;
        int[] killBonusSums = new int[10001];

        for (int[] dragon : dragons) {
            int dragonStrength = dragon[0];
            int killBonus = dragon[1];

            maximumDragonStrength = Math.max(maximumDragonStrength, dragonStrength);
            killBonusSums[dragonStrength] += killBonus;
        }

        for (int dragonStrength = 0; dragonStrength <= maximumDragonStrength; dragonStrength++) {
            if (dragonStrength < playerStrength) {
                int killBonusSum = killBonusSums[dragonStrength];

                playerStrength += killBonusSum;
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
