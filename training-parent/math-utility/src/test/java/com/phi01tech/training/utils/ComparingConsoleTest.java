package com.phi01tech.training.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ComparingConsoleTest {

    @Test
    public void testConsole() {
        String input = "56 50";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printer = new PrintStream(out);
        ComparingConsole console = new ComparingConsole(scanner, printer);
        console.run();
        String message = new String(out.toByteArray());
        Assertions.assertEquals("enter two numbers:\nfirst is greater\n", message);
    }
}
