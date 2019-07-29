package com.phi01tech.training.matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SummationTest {

    @Test
    public void testMatrixSummation() {
        // given
        int[][] first = new int[][]{
                {1, 2, 3},
                {3, 4, 5}
        };
        int[][] second = new int[][]{
                {5, 6, 7},
                {9, 0, 7}
        };

        // when (action to perform)
        int[][] result = MatrixUtility.sum(first, second);

        // then (verification)
        int[][] expected = new int[][]{
                {6, 8, 10},
                {12, 4, 12}
        };

        Assertions.assertNotNull(result, "result shouldn't be null");
        Assertions.assertEquals(expected.length, result.length, "result rows are not as expected");
        for (int row = 0; row < expected.length; row++) {
            Assertions.assertTrue(result[row].length == expected[row].length, "rows length are not as expected: " + row);
            for (int col = 0; col < result[row].length; col++) {
                Assertions.assertEquals(expected[row][col], result[row][col],
                        "cell value is not as expected: " + row + "," + col);
            }
        }
    }
}
