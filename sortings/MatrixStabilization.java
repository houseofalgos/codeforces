// Matrix Stabilization: https://codeforces.com/problemset/problem/1986/B

import java.util.Scanner;

public class MatrixStabilization {
    private static final Scanner inputReader = new Scanner(System.in);

    // Time Complexity: O(t * n * m)
    // Space Complexity: O(n * m)
    public static void main(String[] parameters) {
        int totalTestCases = inputReader.nextInt();

        while (0 < totalTestCases--) {
            int totalRows = inputReader.nextInt();
            int totalColumns = inputReader.nextInt();
            int[][] matrix = readMatrix(totalRows, totalColumns);

            optimalSolution(totalRows, totalColumns, matrix);
        }
    }

    // Time Complexity: O(n * m)
    // Space Complexity: O(n * m)
    private static int[][] readMatrix(int totalRows, int totalColumns) {
        int[][] matrix = new int[totalRows][totalColumns];

        for (int row = 0; row < totalRows; row++) {
            for (int column = 0; column < totalColumns; column++) {
                int element = inputReader.nextInt();

                matrix[row][column] = element;
            }
        }

        return matrix;
    }

    // Naive Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void naiveSolution(int totalRows, int totalColumns, int[][] matrix) {
        // -
    }

    // Optimized Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    private static void optimizedSolution(int totalRows, int totalColumns, int[][] matrix) {
        // -
    }

    // Optimal Solution
    // Time Complexity: O(n * m)
    // Space Complexity: O(1)
    private static void optimalSolution(int totalRows, int totalColumns, int[][] matrix) {
        for (int row = 0; row < totalRows; row++) {
            for (int column = 0; column < totalColumns; column++) {
                int leftElement = 0 < column ? matrix[row][column - 1] : Integer.MIN_VALUE;
                int rightElement = column < totalColumns - 1 ? matrix[row][column + 1] : Integer.MIN_VALUE;
                int topElement = 0 < row ? matrix[row - 1][column] : Integer.MIN_VALUE;
                int bottomElement = row < totalRows - 1 ? matrix[row + 1][column] : Integer.MIN_VALUE;
                int maximumHorizontalNeighbor = Math.max(leftElement, rightElement);
                int maximumVerticalNeighbor = Math.max(topElement, bottomElement);
                int currentElement = matrix[row][column];
                int maximumNeighbor = Math.max(maximumHorizontalNeighbor, maximumVerticalNeighbor);

                currentElement = Math.min(currentElement, maximumNeighbor);
                matrix[row][column] = currentElement;
                System.out.print(currentElement + " ");
            }

            System.out.println();
        }
    }
}
