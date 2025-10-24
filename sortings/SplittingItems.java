// Splitting Items: https://codeforces.com/problemset/problem/2004/C

import java.util.Scanner;
import java.util.Arrays;

public class SplittingItems {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n * lg(n))
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int totalItems = inputReader.nextInt();
            int maximumIncrement = inputReader.nextInt();
            int[] items = readItems(totalItems);
            long minimumScore = optimalSolution(totalItems, maximumIncrement, items);

            System.out.println(minimumScore);
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int[] readItems(int totalItems) {
        int[] items = new int[totalItems];

        for (int item = 0; item < totalItems; item++) {
            int price = inputReader.nextInt();

            items[item] = price;
        }

        return items;
    }

    // Naive Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void naiveSolution(int totalItems, int maximumIncrement, int[] items) {
        // -
    }

    // Optimized Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void optimizedSolution(int totalItems, int maximumIncrement, int[] items) {
        // -
    }

    // Optimal Solution
    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(1)
    private static long optimalSolution(int totalItems, int maximumIncrement, int[] items) {
        long aliceScore = 0;
        long bobScore = 0;

        Arrays.sort(items);

        for (int item = totalItems - 1; 0 <= item; item -= 2) {
            int bobPrice = item == 0 ? 0 : items[item - 1];
            int alicePrice = items[item];

            if (0 < item && bobPrice < alicePrice && 0 < maximumIncrement) {
                int increment = Math.min(maximumIncrement, alicePrice - bobPrice);

                maximumIncrement -= increment;
                bobPrice += increment;
            }

            aliceScore += alicePrice;
            bobScore += bobPrice;
        }

        return aliceScore - bobScore;
    }
}
