// A And B And Compilation Errors: https://codeforces.com/problemset/problem/519/B

import java.util.Scanner;

public class AAndBAndCompilationErrors {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalCompilationErrors = inputReader.nextInt();
        int[] errorListOne = readArray(totalCompilationErrors);
        int[] errorListTwo = readArray(totalCompilationErrors - 1);
        int[] errorListThree = readArray(totalCompilationErrors - 2);

        optimalSolution(totalCompilationErrors, errorListOne, errorListTwo, errorListThree);
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
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void naiveSolution(
            int totalCompilationErrors,
            int[] errorListOne,
            int[] errorListTwo,
            int[] errorListThree
    ) {
        // -
    }

    // Optimized Solution
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static void optimizedSolution(
            int totalCompilationErrors,
            int[] errorListOne,
            int[] errorListTwo,
            int[] errorListThree
    ) {
        // Create a frequency map. Increment the count of errors found in error list one and decrement the count of
        // errors found in error lists two and three.
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static void optimalSolution(
            int totalCompilationErrors,
            int[] errorListOne,
            int[] errorListTwo,
            int[] errorListThree
    ) {
        int errorSumOne = 0;
        int errorSumTwo = 0;
        int errorSumThree = 0;

        for (int errorIndex = 0; errorIndex < totalCompilationErrors; errorIndex++) {
            int errorOne = errorListOne[errorIndex];
            int errorTwo = totalCompilationErrors - 1 <= errorIndex ? 0 : errorListTwo[errorIndex];
            int errorThree = totalCompilationErrors - 2 <= errorIndex ? 0 : errorListThree[errorIndex];

            errorSumOne += errorOne;
            errorSumTwo += errorTwo;
            errorSumThree += errorThree;
        }

        int errorSolvedOne = Math.abs(errorSumOne - errorSumTwo);
        int errorSolvedTwo = Math.abs(errorSumTwo - errorSumThree);

        System.out.println(errorSolvedOne);
        System.out.println(errorSolvedTwo);
    }
}
