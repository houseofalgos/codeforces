// Tung Tung Sahur: https://codeforces.com/problemset/problem/2094/D

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class TungTungSahur {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * (n + m))
    // Space Complexity: O(n + m)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            String drumsPlayed = inputReader.next();
            String drumsHeard = inputReader.next();

            optimalSolution(drumsPlayed, drumsHeard);
        }
    }

    // Naive Solution
    // Time Complexity: O(2^n)
    // Space Complexity: O(n)
    private static void naiveSolution(String drumsPlayed, String drumsHeard) {
        // Start from the first drum hit and recursively try to match each played drum with one or two heard drums since
        // each “L” can produce “L” or “LL”, and each “R” can produce “R” or “RR”.
    }

    // Optimized Solution
    // Time Complexity: O(?)
    // Space Complexity: O(?)
    private static void improvedSolution(String drumsPlayed, String drumsHeard) {
        // Start from the first drum hit and recursively try to match each played drum with one or two heard drums since
        // each “L” can produce “L” or “LL”, and each “R” can produce “R” or “RR”.
        // Store intermediate results for later use as optimization.
    }

    // Optimal Solution
    // Time Complexity: O(n + m)
    // Space Complexity: O(n + m)
    private static void optimizedSolution(String drumsPlayed, String drumsHeard) {
        List<int[]> playedDrumFrequencies = getDrumFrequencies(drumsPlayed);
        List<int[]> heardDrumFrequencies = getDrumFrequencies(drumsHeard);
        int totalDrumsPlayed = playedDrumFrequencies.size();
        int totalDrumsHeard = heardDrumFrequencies.size();

        if (totalDrumsPlayed != totalDrumsHeard) {
            System.out.println("NO");
            return;
        }

        for (int index = 0; index < totalDrumsPlayed; index++) {
            int[] playedDrumFrequency = playedDrumFrequencies.get(index);
            int[] heardDrumFrequency = heardDrumFrequencies.get(index);
            int playedDrum = playedDrumFrequency[0];
            int heardDrum = heardDrumFrequency[0];
            int heardDrumCount = heardDrumFrequency[1];
            int playedDrumCount = playedDrumFrequency[1];

            if (
                    playedDrum != heardDrum ||
                            heardDrumCount < playedDrumCount ||
                            2 * playedDrumCount < heardDrumCount
            ) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static List<int[]> getDrumFrequencies(String drums) {
        int totalDrums = drums.length();
        List<int[]> drumFrequencies = new ArrayList<>();

        for (int index = 0; index < totalDrums; index++) {
            int drum = drums.charAt(index);

            if (drumFrequencies.isEmpty()) {
                int[] drumFrequency = new int[] {drum, 1};

                drumFrequencies.add(drumFrequency);
            } else {
                int[] previousDrumFrequency = drumFrequencies.getLast();
                int previousDrum = previousDrumFrequency[0];

                if (drum == previousDrum) {
                    previousDrumFrequency[1]++;
                } else {
                    int[] drumFrequency = new int[] {drum, 1};

                    drumFrequencies.add(drumFrequency);
                }
            }
        }

        return drumFrequencies;
    }

    // Time Complexity: O(n + m)
    // Space Complexity: O(1)
    private static void optimalSolution(String drumsPlayed, String drumsHeard) {
        int indexOne = 0;
        int totalDrumsPlayed = drumsPlayed.length();
        int indexTwo = 0;
        int totalDrumsHeard = drumsHeard.length();

        while (indexOne < totalDrumsPlayed && indexTwo < totalDrumsHeard) {
            int drumPlayed = drumsPlayed.charAt(indexOne);
            int drumPlayedFrequency = 0;
            int drumHeard = drumsHeard.charAt(indexTwo);
            int drumHeardFrequency = 0;

            while (indexOne < totalDrumsPlayed && drumsPlayed.charAt(indexOne) == drumPlayed) {
                drumPlayedFrequency++;
                indexOne++;
            }

            while (indexTwo < totalDrumsHeard && drumsHeard.charAt(indexTwo) == drumHeard) {
                drumHeardFrequency++;
                indexTwo++;
            }

            if (
                    drumPlayed != drumHeard ||
                            drumHeardFrequency < drumPlayedFrequency ||
                            2 * drumPlayedFrequency < drumHeardFrequency
            ) {
                System.out.println("NO");
                return;
            }
        }

        if (indexOne == totalDrumsPlayed && indexTwo == totalDrumsHeard) {
            System.out.println("YES");
            return;
        }

        System.out.println("NO");
    }
}
