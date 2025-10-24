// Berland Music: https://codeforces.com/problemset/problem/1622/B

import java.util.Scanner;
import java.util.Arrays;

public class BerlandMusic {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n * lg(n))
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int totalSongs = inputReader.nextInt();
            int[][] songs = readSongs(totalSongs);

            optimalSolution(totalSongs, songs);
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int[][] readSongs(int totalSongs) {
        int[][] songs = new int[totalSongs][3];

        for (int index = 0; index < totalSongs; index++) {
            int rating = inputReader.nextInt();

            songs[index][0] = rating;
            songs[index][2] = index;
        }

        char[] reactions = inputReader.next().toCharArray();

        for (int index = 0; index < totalSongs; index++) {
            int reaction = reactions[index] - '0';

            songs[index][1] = reaction;
        }

        return songs;
    }

    // Naive Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void naiveSolution(int totalSongs, int[][] songs) {
        // -
    }

    // Optimized Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void optimizedSolution(int totalSongs, int[][] songs) {
        // -
    }

    // Optimal Solution
    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(1)
    private static void optimalSolution(int totalSongs, int[][] songs) {
        int totalLikedSongs = countLikedSongs(songs);

        if (totalLikedSongs == totalSongs) {
            printRatings(songs);
            return;
        }

        int rightIndexLimit = totalSongs - totalLikedSongs;
        int leftIndex = rightIndexLimit - 1;
        int rightIndex = totalSongs - 1;

        sortByRating(songs);

        while (0 <= leftIndex && rightIndexLimit <= rightIndex) {
            int[] leftSong = songs[leftIndex];
            int leftReaction = leftSong[1];
            int[] rightSong = songs[rightIndex];
            int rightReaction = rightSong[1];

            if (leftReaction == 0) {
                leftIndex--;
            } else if (rightReaction == 1) {
                rightIndex--;
            } else {
                int leftRating = leftSong[0];
                int rightRating = rightSong[0];

                rightSong[0] = leftRating;
                leftSong[0] = rightRating;
                leftIndex--;
                rightIndex--;
            }
        }

        sortByIndex(songs);
        printRatings(songs);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static int countLikedSongs(int[][] songs) {
        int totalLikedSongs = 0;

        for (int[] song : songs) {
            int reaction = song[1];

            if (reaction == 1) {
                totalLikedSongs++;
            }
        }

        return totalLikedSongs;
    }

    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(1)
    private static void sortByRating(int[][] songs) {
        Arrays.sort(
                songs,
                (songOne, songTwo) -> {
                    int ratingOne = songOne[0];
                    int ratingTwo = songTwo[0];

                    return ratingOne - ratingTwo;
                }
        );
    }

    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(1)
    private static void sortByIndex(int[][] songs) {
        Arrays.sort(
                songs,
                (songOne, songTwo) -> {
                    int indexOne = songOne[2];
                    int indexTwo = songTwo[2];

                    return indexOne - indexTwo;
                }
        );
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static void printRatings(int[][] songs) {
        for (int[] song : songs) {
            int rating = song[0];

            System.out.print(rating + " ");
        }

        System.out.println();
    }
}
