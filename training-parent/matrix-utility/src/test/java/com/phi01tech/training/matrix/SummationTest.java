package com.phi01tech.training.matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.ArrayList;
import java.util.stream.Stream;

public class SummationTest {

    @Test
    public void givenTwoValidMatrices_whenSum_thenResultIsReturned() {
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

    @ParameterizedTest
    @ArgumentsSource(InvalidMatrixProvider.class)
    public void givenTwoMatricesSecondIsInvalid_whenSum_thenThrowInvalidInputException(int[][] second) {
        int[][] first = new int[][]{
                {1, 2, 3},
                {3, 4, 5}
        };
        executeSumThenAssert(first, second, "second matrix is invalid");
    }


    @ParameterizedTest
    @ArgumentsSource(InvalidMatrixProvider.class)
    public void givenTwoMatricesFirstIsInvalid_whenSum_thenThrowInvalidInputException(int[][] first) {
        int[][] second = new int[][]{
                {5, 6, 7},// 3
                {9, 0, 8}// 2
        };
        executeSumThenAssert(first, second, "first matrix is invalid");
    }

    public void givenTwoValidMatricesWithDifferentDimensions_whenSum_thenThrowIllegalArgumentException(){
        // TODO implement me
    }

    private void executeSumThenAssert(int[][] first, int[][] second, String s) {
        InvalidMatrixException thrown = Assertions.assertThrows(InvalidMatrixException.class,
                () -> MatrixUtility.sum(first, second));
        Assertions.assertEquals(s, thrown.getMessage());
    }


    public static class InvalidMatrixProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            ArrayList<Arguments> arguments = new ArrayList<>();
            arguments.add(Arguments.of(new Object[]{new int[][]{
                    {1, 3, 4},
                    {1, 4}
            }}));
            arguments.add(Arguments.of(new Object[]{new int[][]{
                    {1, 3, 4},
                    {1, 4, 4, 4},
                    {1, 4, 4, 4}
            }}));

            arguments.add(Arguments.of(new Object[]{new int[][]{
                    {1, 3, 4},
                    null,
                    {1, 4, 4, 4}
            }}));
            arguments.add(Arguments.of(new Object[]{new int[][]{
                    {1, 3, 4, 6},
                    {1, 4, 4, 4},
                    {1, 4, 4, 4},
                    null
            }}));
            arguments.add(Arguments.of(new Object[]{new int[][]{
                    null,
                    {1, 4, 4, 4},
                    {1, 4, 4, 4}
            }}));

            return arguments.stream();
        }
    }

}
