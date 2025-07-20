// New Year's Number: https://codeforces.com/problemset/problem/1475/B

import java.util.Scanner;

public class NewYearsNumber {
    private static final Scanner inputReader = new Scanner(System.in);
    private static final int twentyTwenty = 2020;
    private static final int twentyTwentyOne = 2021;

    // Time Complexity: O(t)
    // Space Complexity: O(1)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();


        while (0 < totalTestCases--) {
            int number = inputReader.nextInt();

            moduloSolution(number);
        }
    }

    // Naive Solution
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    private static void bruteForce(int number) {
        int multiplicandOneLimit = number / twentyTwenty;

        for (int multiplicandOne = 0; multiplicandOne <= multiplicandOneLimit; multiplicandOne++) {
            int remainder = number - (twentyTwenty * multiplicandOne);
            int multiplicandTwoLimit = remainder / twentyTwentyOne;

            for (int multiplicandTwo = 0; multiplicandTwo <= multiplicandTwoLimit; multiplicandTwo++) {
                int product = twentyTwenty * multiplicandOne + twentyTwentyOne * multiplicandTwo;

                if (product == number) {
                    System.out.println("YES");
                    return;
                }
            }
        }

        System.out.println("NO");
    }

    // Optimized Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static void singlePass(int number) {
        int multiplicand = number / twentyTwenty;

        for (int multipleOne = 0; multipleOne <= multiplicand; multipleOne++) {
            int remainder = number - (twentyTwenty * multipleOne);

            if (remainder % twentyTwentyOne == 0) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }

    // Optimal Solution
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    private static void moduloSolution(int number) {
        int quotient = number / twentyTwenty;
        int remainder = number % twentyTwenty;

        if (remainder <= quotient) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
