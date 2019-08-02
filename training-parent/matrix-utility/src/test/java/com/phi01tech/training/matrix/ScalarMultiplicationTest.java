package com.phi01tech.training.matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ScalarMultiplicationTest {

    @ParameterizedTest
    @ArgumentsSource(InvalidMatrixProvider.class)
    public void givenInvalidMatrix_whenScale_ThenThrowException(int[][] matrix) {
        int scalar = 19;

        Assertions.assertThrows(InvalidMatrixException.class, () -> MatrixUtility.scale(scalar, matrix));
    }

    // test method (scenario, action, outcome)
    @Test
    public void givenNumberAndValidMatrix_whenDoScalarMultiplication_thenReturnExpectedResult() {
        int scalar = 4;
        int[][] matrix = new int[][]{
                {1, 3, 4},
                {10, 0, 6},
                {11, 33, 24}
        };

        int[][] result = MatrixUtility.scale(scalar, matrix);

        Assertions.assertNotNull(result, "result is null");

        int[][] expected = new int[][]{
                {4, 12, 16},
                {40, 0, 24},
                {44, 132, 96}
        };

        Assertions.assertEquals(expected.length, result.length, "returned matrix has invalid rows count");
        for (int row = 0; row < result.length; row++) {
            Assertions.assertArrayEquals(expected[row], result[row], "rows are not identical");
        }
    }
}
