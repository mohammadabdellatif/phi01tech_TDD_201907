package com.phi01tech.training.matrix;

public class MatrixUtility {

    // production code
    public static int[][] sum(int[][] first, int[][] second) {
        int[][] result = new int[first.length][first[0].length];

        for (int row = 0; row < first.length; row++) {
            for (int col = 0; col < first[row].length; col++) {
                result[row][col] = first[row][col] + second[row][col];
            }
        }

        return result;
    }
}
