package com.phi01tech.training.matrix;

public class MatrixUtility {

    // production code
    public static int[][] sum(int[][] first, int[][] second) {
        throwIfInvalidMatrix(first, "first matrix is invalid");
        throwIfInvalidMatrix(second, "second matrix is invalid");
        throwIfIncompatibleForSummation(first, second);

        return doSummation(first, second);
    }

    private static void throwIfIncompatibleForSummation(int[][] first, int[][] second) {
        if (first.length != second.length || first[0].length != second[0].length)
            throw new IllegalArgumentException("incompatible matrices");
    }

    private static int[][] doSummation(int[][] first, int[][] second) {
        int[][] result = new int[first.length][first[0].length];

        for (int row = 0; row < first.length; row++) {
            for (int col = 0; col < first[row].length; col++) {
                result[row][col] = first[row][col] + second[row][col];
            }
        }

        return result;
    }

    private static void throwIfInvalidMatrix(int[][] matrix, String failureMessage) {
        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row - 1] == null
                    || matrix[row] == null
                    || matrix[row - 1].length != matrix[row].length)
                throw new InvalidMatrixException(failureMessage);
        }
    }
}
