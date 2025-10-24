// Farmer John's Card Game: https://codeforces.com/problemset/problem/2060/B

import java.util.Scanner;
import java.util.Arrays;

public class FarmerJohnsCardGame {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n * m * lg(m))
    // Space Complexity: O(n * m)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int totalRounds = inputReader.nextInt();
            int cardsDealt = inputReader.nextInt();
            int[][] grid = readGrid(totalRounds, cardsDealt);

            optimalSolution(totalRounds, cardsDealt, grid);
        }
    }

    // Time Complexity: O(n * m)
    // Space Complexity: O(n * m)
    private static int[][] readGrid(int totalRounds, int cardsDealt) {
        int[][] grid = new int[totalRounds][cardsDealt + 1];

        for (int roundIndex = 0; roundIndex < totalRounds; roundIndex++) {
            for (int cardIndex = 0; cardIndex < cardsDealt; cardIndex++) {
                int card = inputReader.nextInt();

                grid[roundIndex][cardIndex] = card;
            }

            grid[roundIndex][cardsDealt] = roundIndex;
        }

        return grid;
    }

    // Naive Solution
    // Time Complexity: O(n! * n * m)
    // Space Complexity: O(n * m)
    private static void naiveSolution(int totalRounds, int cardsDealt, int[][] grid) {
        // Generate all permutations and check if any can form a fair game.
    }

    // Optimized Solution
    // Time Complexity: O(?)
    // Space Complexity: O(?)
    private static void optimizedSolution(int totalRounds, int cardsDealt, int[][] grid) {
        // Generate all permutations and check if any can form a progressive square.
        // Store intermediate results for later use as optimization.
    }

    // Optimal Solution
    // Time Complexity: O(n * m * lg(n))
    // Space Complexity: O(1)
    private static void optimalSolution(int totalRounds, int cardsDealt, int[][] grid) {
        int lastCard = -1;

        sortRounds(cardsDealt, grid);

        for (int cardIndex = 0; cardIndex < cardsDealt; cardIndex++) {
            for (int roundIndex = 0; roundIndex < totalRounds; roundIndex++) {
                int currentCard = grid[roundIndex][cardIndex];

                if (currentCard <= lastCard) {
                    System.out.println(-1);
                    return;
                }

                lastCard = currentCard;
            }
        }

        for (int[] round : grid) {
            int roundIndex = round[cardsDealt];

            System.out.print((roundIndex + 1) + " ");
        }

        System.out.println();
    }

    // Time Complexity: O(n * m * lg(n))
    // Space Complexity: O(1)
    private static void sortRounds(int cardsDealt, int[][] grid) {
        for (int[] round : grid) {
            Arrays.sort(round, 0, cardsDealt);
        }

        Arrays.sort(
                grid,
                (cardsOne, cardsTwo) -> {
                    int smallestCardOne = cardsOne[0];
                    int smallestCardTwo = cardsTwo[0];

                    return smallestCardOne - smallestCardTwo;
                }
        );
    }
}
