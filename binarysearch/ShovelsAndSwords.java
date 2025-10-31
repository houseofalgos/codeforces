// Shovels And Swords: https://codeforces.com/problemset/problem/1366/A

import java.util.Scanner;

public class ShovelsAndSwords {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t)
    // Space Complexity: O(1)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int totalSticks = inputReader.nextInt();
            int totalDiamonds = inputReader.nextInt();
            int maximumEmeraldEarned = optimalSolution(totalSticks, totalDiamonds);

            System.out.println(maximumEmeraldEarned);
        }
    }

    // Naive Solution
    // Time Complexity: O(min(n, m))
    // Space Complexity: O(1)
    private static int naiveSolution(int totalSticks, int totalDiamonds) {
        int maximumEmeraldEarned = 0;

        while (
                (
                        0 < totalSticks && 0 < totalDiamonds
                ) && (
                        2 <= totalSticks || 2 <= totalDiamonds
                )
        ) {
            if (totalSticks <= totalDiamonds) {
                totalSticks--;
                totalDiamonds -= 2;
            } else {
                totalDiamonds--;
                totalSticks -= 2;
            }

            maximumEmeraldEarned++;
        }

        return maximumEmeraldEarned;
    }

    // Optimized Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void optimizedSolution(int totalSticks, int totalDiamonds) {
        // -
    }

    // Optimal Solution
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    private static int optimalSolution(int totalSticks, int totalDiamonds) {
        int totalCraftingMaterials = totalSticks + totalDiamonds;

        return Math.min(
                totalCraftingMaterials / 3,
                Math.min(totalSticks, totalDiamonds)
        );
    }
}
