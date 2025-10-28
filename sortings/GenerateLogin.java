// Generate Login: https://codeforces.com/problemset/problem/909/A

import java.util.Scanner;

public class GenerateLogin {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static void main(String[] parameters) {
        String firstName = inputReader.next();
        String lastName = inputReader.next();
        String smallestUsername = optimalSolution(firstName, lastName);

        System.out.println(smallestUsername);
    }

    // Naive Solution
    // Time Complexity: O(n * m)
    // Space Complexity: O(n * m)
    private static void naiveSolution(String firstName, String lastName) {
        // Generate all valid usernames, sort them, and select the lexicographically smallest one.
    }

    // Optimized Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void optimizedSolution(String firstName, String lastName) {
        // -
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static String optimalSolution(String firstName, String lastName) {
        int firstNameLength = firstName.length();
        int index = 1;
        char lastCharacter = lastName.charAt(0);

        while (index < firstNameLength) {
            char character = firstName.charAt(index);

            if (character < lastCharacter) {
                index++;
            } else {
                break;
            }
        }

        return firstName.substring(0, index) + lastCharacter;
    }
}
