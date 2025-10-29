// Haunted House: https://codeforces.com/problemset/problem/1884/B

import java.util.Scanner;

public class HauntedHouse {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * )
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int stringLength = inputReader.nextInt();
            String string = inputReader.next();

            optimalSolution(stringLength, string);
        }
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
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    private static void naiveSolution() {
        // We need 1 consecutive 0's on the right to be divisible by 2^1, 2 consecutive 0's on the right to be divisible
        // by 2^2 and so on.
        // For every i = 1 to n, keep shifting set bits to the left if possible.
    }

    // Optimized Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void optimizedSolution() {
        // -
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static void optimalSolution(int stringLength, String string) {
        int leftIndex = stringLength - 1;
        int consecutiveZeros = 0;
        long swapsNeeded = 0;
        int exponent = 1;

        for (int rightIndex = stringLength - 1; 0 <= rightIndex && 0 <= leftIndex; rightIndex--) {
            while (0 <= leftIndex && string.charAt(leftIndex) == '1') {
                leftIndex--;
            }

            if (leftIndex < 0) {
                break;
            }

            consecutiveZeros++;
            swapsNeeded += rightIndex - leftIndex--;

            if (exponent == consecutiveZeros) {
                System.out.print(swapsNeeded + " ");
                exponent++;
            }
        }

        while (exponent++ <= stringLength) {
            System.out.print(-1 + " ");
        }

        System.out.println();
    }
}
