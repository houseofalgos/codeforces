// Basketball Together: https://codeforces.com/problemset/problem/1725/B

import java.util.Scanner;
import java.util.Arrays;

public class BasketballTogether {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalPlayers = inputReader.nextInt();
        int targetPower = inputReader.nextInt();
        int[] players = readPlayers(totalPlayers);
        long maximumTeams = optimalSolution(totalPlayers, targetPower, players);

        System.out.println(maximumTeams);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int[] readPlayers(int totalPlayers) {
        int[] players = new int[totalPlayers];

        for (int index = 0; index < totalPlayers; index++) {
            int power = inputReader.nextInt();

            players[index] = power;
        }

        return players;
    }

    // Naive Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void naiveSolution(int totalPlayers, int targetPower, int[] players) {
        // -
    }

    // Optimized Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void optimizedSolution(int totalPlayers, int targetPower, int[] players) {
        // -
    }

    // Optimal Solution
    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(1)
    private static long optimalSolution(int totalPlayers, int targetPower, int[] players) {
        int leftIndex = 0;
        int rightIndex = totalPlayers - 1;
        int maximumTeams = 0;

        targetPower++;
        Arrays.sort(players);

        while (leftIndex <= rightIndex) {
            int power = players[rightIndex];
            int teamSize = (targetPower + power - 1) / power;

            if (rightIndex - leftIndex + 1 < teamSize) {
                break;
            }

            leftIndex += teamSize - 1;
            rightIndex--;
            maximumTeams++;
        }

        return maximumTeams;
    }
}
