// Interesting Drink: https://codeforces.com/problemset/problem/706/B

import java.util.Scanner;
import java.util.Arrays;

public class InterestingDrink {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * q * lg(n))
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalShops = inputReader.nextInt();
        int[] prices = readArray(totalShops);
        int totalDays = inputReader.nextInt();
        int[] budgets = readArray(totalDays);

        optimalSolution(totalShops, prices, budgets);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int[] readArray(int arrayLength) {
        int[] array = new int[arrayLength];

        for (int index = 0; index < arrayLength; index++) {
            int element = inputReader.nextInt();

            array[index] = element;
        }

        return array;
    }

    // Naive Solution
    // Time Complexity: O(n * q)
    // Space Complexity: O()
    private static void naiveSolution(int totalShops, int[] prices, int[] budgets) {
        // For each day’s budget, iterate through all shops and count how many have a bottle price less than or equal to
        // the given budget.
    }

    // Optimized Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void optimizedSolution(int totalShops, int[] prices, int[] budgets) {
        // -
    }

    // Optimal Solution
    // Time Complexity: O(q * lg(n))
    // Space Complexity: O(1)
    private static void optimalSolution(int totalShops, int[] prices, int[] budgets) {
        Arrays.sort(prices);

        for (int budget : budgets) {
            int left = 0;
            int right = totalShops - 1;
            int shopsVisited = 0;

            while (left <= right) {
                int day = left + (right - left) / 2;
                int price = prices[day];

                if (price <= budget) {
                    left = day + 1;
                    shopsVisited = left;
                } else {
                    right = day - 1;
                }
            }

            System.out.println(shopsVisited);
        }
    }
}
