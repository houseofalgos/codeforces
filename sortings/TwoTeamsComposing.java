// TwoTeamsComposing: https://codeforces.com/problemset/problem/1335/C

import java.util.Scanner;

public class TwoTeamsComposing {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n)
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int totalStudents = inputReader.nextInt();
            int[] skills = readSkills(totalStudents);
            int maximumTeamSize = optimalSolution(skills);

            System.out.println(maximumTeamSize);
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int[] readSkills(int totalStudents) {
        int[] skills = new int[totalStudents];

        for (int student = 0; student < totalStudents; student++) {
            int skill = inputReader.nextInt();

            skills[student] = skill;
        }

        return skills;
    }

    // Naive Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void naiveSolution(int[] skills) {
        // -
    }

    // Optimized Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static void optimizedSolution(int[] skills) {
        // Create a frequency map, then iterate over each unique skill to form team 2 and evaluate the team composition.
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static int optimalSolution(int[] skills) {
        int maximumSkill = 200001;
        int[] skillFrequency = new int[maximumSkill];
        int uniqueSkills = 0;
        int maximumFrequency = Integer.MIN_VALUE;

        for (int skill : skills) {
            int currentFrequency = ++skillFrequency[skill];

            if (currentFrequency == 1) {
                uniqueSkills++;
            }

            maximumFrequency = Math.max(maximumFrequency, currentFrequency);
        }

        int optionOne = Math.min(uniqueSkills - 1, maximumFrequency);
        int optionTwo = 0 < maximumFrequency ? Math.min(uniqueSkills, maximumFrequency - 1) : Integer.MIN_VALUE;

        return Math.max(optionOne, optionTwo);
    }
}
