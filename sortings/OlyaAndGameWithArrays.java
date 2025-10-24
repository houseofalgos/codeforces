// Olya And Game With Arrays: https://codeforces.com/problemset/problem/1859/B

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class OlyaAndGameWithArrays {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n)
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int totalArrays = inputReader.nextInt();
            List<Integer>[] arrays = readArrays(totalArrays);
            long maximumBeautyScore = optimalSolution(arrays);

            System.out.println(maximumBeautyScore);
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static List<Integer>[] readArrays(int totalArrays) {
        List<Integer>[] arrays = new List[totalArrays];

        for (int arrayIndex = 0; arrayIndex < totalArrays; arrayIndex++) {
            int arrayLength = inputReader.nextInt();
            List<Integer> array = new ArrayList<>();

            for (int index = 0; index < arrayLength; index++) {
                int element = inputReader.nextInt();

                array.add(element);
            }

            arrays[arrayIndex] = array;
        }

        return arrays;
    }

    // Naive Solution
    // Time Complexity: O((n * m)^n)
    // Space Complexity: O(n)
    private static void naiveSolution(List<Integer>[] arrays) {
        // Generate all move sequences and test them.
    }

    // Optimized Solution
    // Time Complexity: O(n^(n + 1))
    // Space Complexity: O(n)
    private static void optimizedSolution(List<Integer>[] arrays) {
        // Generate all move sequences and test them. Notice that only the smallest two elements of each array matter.
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static long optimalSolution(List<Integer>[] arrays) {
        long maximumBeautyScore = 0;
        int overallMinimumElement = Integer.MAX_VALUE;
        int overallSecondMinimumElement = Integer.MAX_VALUE;

        for (List<Integer> array : arrays) {
            int minimumElement = Integer.MAX_VALUE;
            int secondMinimumElement = Integer.MAX_VALUE;

            for (int element : array) {
                if (element <= minimumElement) {
                    secondMinimumElement = minimumElement;
                    minimumElement = element;
                } else {
                    secondMinimumElement = Math.min(secondMinimumElement, element);
                }
            }

            maximumBeautyScore += secondMinimumElement;
            overallMinimumElement = Math.min(overallMinimumElement, minimumElement);
            overallSecondMinimumElement = Math.min(overallSecondMinimumElement, secondMinimumElement);
        }

        return maximumBeautyScore + overallMinimumElement - overallSecondMinimumElement;
    }
}
