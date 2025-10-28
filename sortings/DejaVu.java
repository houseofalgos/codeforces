// Deja Vu: https://codeforces.com/problemset/problem/1891/B

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class DejaVu {
    private static final int MAXIMUM_EXPONENT = 31;
    private static final int[] POWERS = new int[MAXIMUM_EXPONENT];
    private static final Scanner inputReader = new Scanner(System.in);

    static {
        int power = 1;

        for (int exponent = 0; exponent < MAXIMUM_EXPONENT; exponent++) {
            POWERS[exponent] = power;
            power *= 2;
        }
    }

    // Time Complexity: O(t * (n + m))
    // Space Complexity: O(n + m)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int arrayLength = inputReader.nextInt();
            int totalExponents = inputReader.nextInt();
            int[] array = readArray(arrayLength);
            int[] exponents = readArray(totalExponents);

            optimalSolution(arrayLength, array, exponents);
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
    // Time Complexity: O(n * m)
    // Space Complexity: O(1)
    private static void naiveSolution(int arrayLength, int totalExponents, int[] array, int[] exponents) {
        for (int exponentIndex = 0; exponentIndex < totalExponents; exponentIndex++) {
            int exponent = exponents[exponentIndex];
            int power = POWERS[exponent];

            for (int elementIndex = 0; elementIndex < arrayLength; elementIndex++) {
                int element = array[elementIndex];

                if (element % power == 0) {
                    array[elementIndex] += power / 2;
                }
            }
        }

        for (int element : array) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    // Optimized Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void optimizedSolution(int arrayLength, int[] array, int[] exponents) {
        // -
    }

    // Optimal Solution
    // Time Complexity: O(n + m)
    // Space Complexity: O(1)
    private static void optimalSolution(int arrayLength, int[] array, int[] exponents) {
        boolean[] exponentsSeen = new boolean[MAXIMUM_EXPONENT];
        List<Integer> exponentsList = new ArrayList<>();

        for (int exponent : exponents) {
            boolean exponentSeen = exponentsSeen[exponent];

            if (!exponentSeen) {
                exponentsList.add(exponent);
            }

            exponentsSeen[exponent] = true;
        }

        for (int exponent : exponentsList) {
            int power = POWERS[exponent];

            for (int index = 0; index < arrayLength; index++) {
                int element = array[index];

                if (element % power == 0) {
                    array[index] += power / 2;
                }
            }
        }

        for (int element : array) {
            System.out.print(element + " ");
        }

        System.out.println();
    }
}
