// Kalindrome Array: https://codeforces.com/problemset/problem/1610/B

import java.util.Scanner;

public class KalindromeArray {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n)
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int arrayLength = inputReader.nextInt();
            int[] array = readArray(arrayLength);

            optimalSolution(arrayLength, array);
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
    private static void naiveSolution(int arrayLength, int[] array) {
        // Try removing all occurrences of each unique element one by one and check if the resulting array forms a
        // palindrome.
    }

    // Optimized Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void optimizedSolution(int arrayLength, int[] array) {
        // -
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static void optimalSolution(int arrayLength, int[] array) {
        int leftIndex = 0;
        int rightIndex = arrayLength - 1;

        while (leftIndex <= rightIndex) {
            int leftElement = array[leftIndex++];
            int rightElement = array[rightIndex--];

            if (leftElement != rightElement) {
                boolean isKalindrome = isKalindrome(arrayLength, array, leftElement) ||
                        isKalindrome(arrayLength, array, rightElement);

                if (isKalindrome) {
                    break;
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static boolean isKalindrome(int arrayLength, int[] array, int deletedElement) {
        int leftIndex = 0;
        int rightIndex = arrayLength - 1;

        while (leftIndex < rightIndex) {
            int leftElement = array[leftIndex];
            int rightElement = array[rightIndex];

            if (leftElement == deletedElement) {
                leftIndex++;
            } else if (rightElement == deletedElement) {
                rightIndex--;
            } else if (leftElement == rightElement) {
                leftIndex++;
                rightIndex--;
            } else {
                return false;
            }
        }

        return true;
    }
}
