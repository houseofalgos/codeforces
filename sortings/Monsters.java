// Monsters: https://codeforces.com/problemset/problem/1849/B

import java.util.Scanner;
import java.util.Arrays;

public class Monsters {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n * lg(n))
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int totalMonsters = inputReader.nextInt();
            int damage = inputReader.nextInt();
            int[][] monsters = readMonsters(totalMonsters);

            optimalSolution(damage, monsters);
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int[][] readMonsters(int totalMonsters) {
        int[][] monsters = new int[totalMonsters][2];

        for (int monsterIndex = 0; monsterIndex < totalMonsters; monsterIndex++) {
            int monsterHealth = inputReader.nextInt();

            monsters[monsterIndex][0] = monsterIndex;
            monsters[monsterIndex][1] = monsterHealth;
        }

        return monsters;
    }

    // Naive Solution
    // Time Complexity: O(n * h)
    // Space Complexity: O(1)
    private static void naiveSolution(int damage, int[][] monsters) {
        // Simulate the game.
        // At each step, find the monster with the highest current health and reduce it by "damage". Remove it when it
        // dies.
    }

    // Optimized Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void optimizedSolution(int damage, int[][] monsters) {
        // -
    }

    // Optimal Solution
    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(1)
    private static void optimalSolution(int damage, int[][] monsters) {
        for (int[] monster : monsters) {
            int monsterHealth = monster[1] % damage;
            int residualHealth = monsterHealth == 0 ? damage : monsterHealth;

            monster[1] = residualHealth;
        }

        sortMonsters(monsters);

        for (int[] monster : monsters) {
            int monsterIndex = monster[0];

            System.out.print((monsterIndex + 1) + " ");
        }

        System.out.println();
    }

    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(1)
    private static void sortMonsters(int[][] monsters) {
        Arrays.sort(
                monsters,
                (monsterOne, monsterTwo) -> {
                    int monsterOneIndex = monsterOne[0];
                    int monsterOneHealth = monsterOne[1];
                    int monsterTwoIndex = monsterTwo[0];
                    int monsterTwoHealth = monsterTwo[1];

                    if (monsterOneHealth == monsterTwoHealth) {
                        return monsterOneIndex - monsterTwoIndex;
                    }

                    return monsterTwoHealth - monsterOneHealth;
                }
        );
    }
}
