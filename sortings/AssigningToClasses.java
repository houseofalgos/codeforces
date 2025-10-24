// Assigning To Classes: https://codeforces.com/problemset/problem/1300/B

import java.util.Scanner;

public class AssigningToClasses {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n)
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int totalStudents = 2 * inputReader.nextInt();
            int[] skillLevels = readSkillLevels(totalStudents);
            int minimumDifference = optimalSolution(totalStudents, skillLevels);

            System.out.println(minimumDifference);
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int[] readSkillLevels(int totalStudents) {
        int[] skillLevels = new int[totalStudents];

        for (int student = 0; student < totalStudents; student++) {
            int skillLevel = inputReader.nextInt();

            skillLevels[student] = skillLevel;
        }

        return skillLevels;
    }

    // Naive Solution
    // Time Complexity: O(2^n)
    // Space Complexity: O(n)
    private static void naiveSolution(int totalStudents, int[] skillLevels) {
        // Generate all possible ways to divide the 2n students into two groups of odd sizes and compute the absolute
        // difference between their medians. Keep track of the smallest such difference across all valid partitions.
    }

    // Optimized Solution
    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(1)
    private static void optimizedSolution(int totalStudents, int[] skillLevels) {
        // Sort the skill levels in non-decreasing order. The minimum median difference occurs between the two middle
        // elements, the right middle element becomes the median of one class, and the left middle element becomes the
        // median of the other.
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static int optimalSolution(int totalStudents, int[] skillLevels) {
        int medianOneIndex = totalStudents / 2 - 1;
        int medianTwoIndex = medianOneIndex + 1;
        int medianTwo = nthOrderStatistic(totalStudents, skillLevels, medianTwoIndex);
        int medianOne = nthOrderStatistic(totalStudents, skillLevels, medianOneIndex);

        return medianTwo - medianOne;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static int nthOrderStatistic(int arrayLength, int[] array, int n) {
        int startIndex = 0;
        int endIndex = arrayLength - 1;

        while (startIndex <= endIndex) {
            int rightIndex = endIndex;
            int leftIndex = startIndex;
            int middleIndex = (rightIndex - leftIndex) / 2 + leftIndex;
            int middleElement = array[middleIndex];

            while (leftIndex <= rightIndex) {
                int leftElement = array[leftIndex];
                int rightElement = array[rightIndex];

                if (leftElement < middleElement) {
                    leftIndex++;
                } else if (middleElement < rightElement) {
                    rightIndex--;
                } else if (leftIndex <= rightIndex) {
                    array[leftIndex++] = rightElement;
                    array[rightIndex--] = leftElement;
                }
            }

            if (n <= rightIndex) {
                endIndex = rightIndex;
            } else if (leftIndex <= n) {
                startIndex = leftIndex;
            } else {
                return middleElement;
            }
        }

        return array[n];
    }
}
