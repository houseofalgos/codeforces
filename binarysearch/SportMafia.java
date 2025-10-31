// Sport Mafia: https://codeforces.com/problemset/problem/1195/B

import java.util.Scanner;

public class SportMafia {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(lg(n))
    // Space Complexity: O(1)
    public static void main(String[] parameters) {
        int totalActions = inputReader.nextInt();
        int totalCandiesLeft = inputReader.nextInt();
        int totalCandiesEaten = optimalSolution(totalActions, totalCandiesLeft);

        System.out.println(totalCandiesEaten);
    }

    // Naive Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static void naiveSolution(int totalActions, int totalCandiesLeft) {
        // Incrementally test each possible number of “eat” actions and compute candiesLeft = (sum of added candies) -
        // (candies eaten) until candiesLeft == k.
    }

    // Optimized Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void optimizedSolution() {
        // -
    }

    // Optimal Solution
    // Time Complexity: O(lg(n))
    // Space Complexity: O(1)
    private static int optimalSolution(int totalActions, int totalCandiesLeft) {
        int left = 0;
        int right = totalActions - 1;

        while (left <= right) {
            int candiesEaten = left + ((right - left) / 2);
            int additionCount = totalActions - candiesEaten;
            long candiesAdded = ((long) additionCount * (additionCount + 1)) / 2;
            long candiesLeft = candiesAdded - candiesEaten;

            if (candiesLeft == totalCandiesLeft) {
                return candiesEaten;
            }

            if (candiesLeft < totalCandiesLeft) {
                right = candiesEaten - 1;
            } else {
                left = candiesEaten + 1;
            }
        }

        return -1;
    }
}
