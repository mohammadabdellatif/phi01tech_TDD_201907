package com.phi01tech.training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.EmptyStackException;

public class StackTest {


    // Stack
    // Has fixed capacity
    // push
    // pop
    // size number of pushed elements
    // capacity method to read capacity
    @ParameterizedTest
    @ValueSource(ints = {-1, -10, -100, -5})
    public void givenMinusCapacity_whenConstructingStack_thenIllegalArgumentExceptionIsThrown(int capacity) {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> new Stack(capacity));
        Assertions.assertEquals("minus capacity [" + capacity + "]", thrown.getMessage());
    }

    @Test
    public void givenCapacity_whenConstructingStack_thenStackIsCreatedWithSize0andWithCapacity() {
        int capacity = 4;
        Stack stack = new Stack(capacity);
        Assertions.assertEquals(capacity, stack.capacity(), "invalid stack capacity");
        Assertions.assertEquals(0, stack.size(), "stack stize should be zero");
    }

    @Test
    public void givenAnEmptyStack_whenPushAndPop_thenExceptionIsThrown() {
        Stack stack = new Stack(0);
        Assertions.assertThrows(EmptyStackException.class, () -> stack.pop());
        Assertions.assertThrows(FullStackException.class, () -> stack.push(null));
    }

    @Test
    public void givenAStack_whenPushMultipleValuesUntilFull_thenAllValuesAreAcceptedExceptLastOne() {
        Stack stack = new Stack(3);
        Assertions.assertDoesNotThrow(() -> stack.push("first"));
        Assertions.assertEquals(1, stack.size());

        Assertions.assertDoesNotThrow(() -> stack.push("second"));
        Assertions.assertEquals(2, stack.size());

        Assertions.assertDoesNotThrow(() -> stack.push("third"));
        Assertions.assertEquals(3, stack.size());

        Assertions.assertThrows(FullStackException.class, () -> stack.push("forth to fail"));
        Assertions.assertEquals(3, stack.size());
    }

    @Test
    public void givenAStackPushedWithValue_whenPopUntilEnd_thenAllValuesAreReturnedInCorrectOrderThenExceptionIsThrownForLastPop() {
        Stack stack = new Stack(4);
        Assertions.assertDoesNotThrow(() -> stack.push("1"));
        Assertions.assertEquals(1, stack.size());

        Assertions.assertDoesNotThrow(() -> stack.push("2"));
        Assertions.assertEquals(2, stack.size());

        Assertions.assertEquals("2", stack.pop());
        Assertions.assertEquals(1, stack.size());


        Assertions.assertDoesNotThrow(() -> stack.push(3));
        Assertions.assertEquals(2, stack.size());

        Assertions.assertDoesNotThrow(() -> stack.push(4l));
        Assertions.assertEquals(3, stack.size());

        Assertions.assertEquals(4l, stack.pop());
        Assertions.assertEquals(2, stack.size());

        Assertions.assertEquals(3, stack.pop());
        Assertions.assertEquals(1, stack.size());

        Assertions.assertEquals("1", stack.pop());
        Assertions.assertEquals(0, stack.size());

        Assertions.assertThrows(EmptyStackException.class, () -> stack.pop());

        Assertions.assertEquals(0, stack.size());
    }
}
