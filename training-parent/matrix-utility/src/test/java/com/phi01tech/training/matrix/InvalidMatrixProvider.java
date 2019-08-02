package com.phi01tech.training.matrix;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.ArrayList;
import java.util.stream.Stream;

public class InvalidMatrixProvider implements ArgumentsProvider {

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