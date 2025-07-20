// Kefa And First Steps: https://codeforces.com/problemset/problem/580/A

import java.util.Scanner;

public class KefaAndFirstSteps {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int arrayLength = inputReader.nextInt();
        int[] array = readArray(arrayLength);
        int longestSubsegmentLength = slidingWindow(arrayLength, array);

        System.out.println(longestSubsegmentLength);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int[] readArray(int arrayLength) {
        int[] array = new int[arrayLength];

        for (int index = 0; index < arrayLength; index++) {
            array[index] = inputReader.nextInt();
        }

        return array;
    }

    // Naive Solution
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    private static int bruteForce(int arrayLength, int[] array) {
        int longestSubsegmentLength = 1;
        
        for (int leftIndex = 0; leftIndex < arrayLength; leftIndex++) {
            int currentSubsegmentLength = 1;

            for (int rightIndex = leftIndex + 1; rightIndex < arrayLength; rightIndex++) {
                int previousElement = array[rightIndex - 1];
                int currentElement = array[rightIndex];

                if (previousElement <= currentElement) {
                    currentSubsegmentLength++;
                } else {
                    break;
                }
            }

            longestSubsegmentLength = Math.max(longestSubsegmentLength, currentSubsegmentLength);
        }

        return longestSubsegmentLength;
    }

    // Optimized Solution
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int dynamicProgramming(int arrayLength, int[] array) {
        int[] segmentLengthList = new int[arrayLength];
        int longestSubsegmentLength = 1;

        segmentLengthList[0] = 1;

        for (int currentIndex = 1; currentIndex < arrayLength; currentIndex++) {
            int previousIndex = currentIndex - 1;
            int previousElement = array[previousIndex];
            int currentElement = array[currentIndex];

            if (previousElement <= currentElement) {
                segmentLengthList[currentIndex] = segmentLengthList[previousIndex] + 1;
            } else {
                segmentLengthList[currentIndex] = 1;
            }
        }

        for (int index = 1; index < arrayLength; index++) {
            int segmentLength = segmentLengthList[index];

            longestSubsegmentLength = Math.max(longestSubsegmentLength, segmentLength);
        }

        return longestSubsegmentLength;
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static int slidingWindow(int arrayLength, int[] array) {
        int currentSubsegmentLength = 1;
        int longestSubsegmentLength = 1;

        for (int index = 1; index < arrayLength; index++) {
            int previousElement = array[index - 1];
            int currentElement = array[index];

            if (previousElement <= currentElement) {
                currentSubsegmentLength++;
            } else {
                currentSubsegmentLength = 1;
            }

            longestSubsegmentLength = Math.max(longestSubsegmentLength, currentSubsegmentLength);
        }

        return longestSubsegmentLength;
    }
}
