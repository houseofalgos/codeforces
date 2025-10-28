// Eating Candies: https://codeforces.com/problemset/problem/1669/F

import java.util.Scanner;

public class EatingCandies {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n)
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int totalCandies = inputReader.nextInt();
            int[] candies = readCandies(totalCandies);
            int maximumCandiesEaten = optimalSolution(totalCandies, candies);

            System.out.println(maximumCandiesEaten);
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int[] readCandies(int totalCandies) {
        int[] candies = new int[totalCandies];

        for (int index = 0; index < totalCandies; index++) {
            int weight = inputReader.nextInt();

            candies[index] = weight;
        }

        return candies;
    }

    // Naive Solution
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    private static void naiveSolution(int totalCandies, int[] candies) {
        // Try all left and right sub-array pairs. If their sums match, update the maximum (l1 + l2).
    }

    // Optimized Solution
    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(n)
    private static void optimizedSolution(int totalCandies, int[] candies) {
        // Use prefix and suffix sums. For each prefix sum p[i], binary search for the same value in suffix sums beyond
        // i.
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static int optimalSolution(int totalCandies, int[] candies) {
        int leftIndex = 0;
        int rightIndex = totalCandies - 1;
        int aliceCandiesWeight = 0;
        int bobCandiesWeight = 0;
        int maximumCandiesEaten = 0;

        while (leftIndex <= rightIndex) {
            if (aliceCandiesWeight <= bobCandiesWeight) {
                int leftCandyWeight = candies[leftIndex++];

                aliceCandiesWeight += leftCandyWeight;
            } else {
                int rightCandyWeight = candies[rightIndex--];

                bobCandiesWeight += rightCandyWeight;
            }

            if (aliceCandiesWeight == bobCandiesWeight) {
                maximumCandiesEaten = leftIndex + (totalCandies - rightIndex - 1);
            }
        }

        return maximumCandiesEaten;
    }
}
