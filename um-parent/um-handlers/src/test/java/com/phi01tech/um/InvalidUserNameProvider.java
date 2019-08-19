package com.phi01tech.um;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.stream.Stream;

public class InvalidUserNameProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Arrays.asList(
                Arguments.of(new Object[]{null}),
                Arguments.of(""),
                Arguments.of(" "),
                Arguments.of("1user"),
                Arguments.of("user 1"),
                Arguments.of("user#two"),
                Arguments.of("1234;56"))
                .stream();
    }
}
