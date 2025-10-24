// Middle Class: https://codeforces.com/problemset/problem/1334/B

import java.util.Scanner;
import java.util.Arrays;

public class MiddleClass {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n * lg(n))
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int totalPersons = inputReader.nextInt();
            int minimumSavings = inputReader.nextInt();
            int[] persons = readPersons(totalPersons);
            int maximumWealthyPersons = optimalSolution(totalPersons, minimumSavings, persons);

            System.out.println(maximumWealthyPersons);
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int[] readPersons(int arrayLength) {
        int[] persons = new int[arrayLength];

        for (int person = 0; person < arrayLength; person++) {
            int savings = inputReader.nextInt();

            persons[person] = savings;
        }

        return persons;
    }

    // Naive Solution
    // Time Complexity: O(2^n)
    // Space Complexity: O(n)
    private static void naiveSolution(int totalPersons, int minimumSavings, int[] persons) {
        // Generate all subset of persons and keep track of maximum wealthy persons.
    }

    // Optimized Solution
    // Time Complexity: O(?)
    // Space Complexity: O(?)
    private static void optimizedSolution(int totalPersons, int minimumSavings, int[] persons) {
        // Generate all subset of persons and keep track of maximum wealthy persons.
        // Store intermediate results for later use as optimization.
    }

    // Optimal Solution
    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(1)
    private static int optimalSolution(int totalPersons, int minimumSavings, int[] persons) {
        long surplusSavings = 0;
        int maximumWealthyPersons = 0;

        Arrays.sort(persons);

        for (int person = totalPersons - 1; 0 <= person; person--) {
            int savings = persons[person];

            if (minimumSavings <= savings) {
                surplusSavings += savings - minimumSavings;
                maximumWealthyPersons++;
            } else if (minimumSavings <= savings + surplusSavings) {
                surplusSavings -= minimumSavings - savings;
                maximumWealthyPersons++;
            }
        }

        return maximumWealthyPersons;
    }
}
