// Sum Of Cubes: https://codeforces.com/problemset/problem/1490/C

import java.util.Scanner;

public class SumOfCubes {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * cbrt(n))
    // Space Complexity: O(1)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            long number = inputReader.nextLong();

            optimalSolution(number);
        }
    }

    // Naive Solution
    // Time Complexity: O(n^(2/3))
    // Space Complexity: O(1)
    private static void naiveSolution(long number) {
        long cubeRootLimit = (long) Math.cbrt(number);

        for (long cubeRootOne = 1; cubeRootOne <= cubeRootLimit; cubeRootOne++) {
            long addendOne = cubeRootOne * cubeRootOne * cubeRootOne;

            for (long cubeRootTwo = 1; cubeRootTwo <= cubeRootLimit; cubeRootTwo++) {
                long addendTwo = cubeRootTwo * cubeRootTwo * cubeRootTwo;
                long sum = addendOne + addendTwo;

                if (sum == number) {
                    System.out.println("YES");
                    return;
                }
            }
        }

        System.out.println("NO");
    }

    // Optimized Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void optimizedSolution(long number) {
        // -
    }

    // Optimal Solution
    // Time Complexity: O(cbrt(n))
    // Space Complexity: O(1)
    private static void optimalSolution(long number) {
        long cubeRootOneLimit = (long) Math.cbrt(number);

        for (long cubeRootOne = 1; cubeRootOne <= cubeRootOneLimit; cubeRootOne++) {
            long addendOne = cubeRootOne * cubeRootOne * cubeRootOne;
            long addendTwo = number - addendOne;
            long cubeRootTwo = (long) Math.cbrt(addendTwo);
            boolean isCube = (cubeRootTwo * cubeRootTwo * cubeRootTwo) == addendTwo;

            if (addendTwo <= 0) {
                continue;
            }

            if (isCube) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}
