package com.phi01tech.training.utils;

import java.io.PrintStream;
import java.util.Scanner;

public class ComparingConsole {

    private final Scanner scanner;
    private final PrintStream printStream;

    public ComparingConsole(Scanner scanner, PrintStream printStream) {
        this.scanner = scanner;
        this.printStream = printStream;
    }

    public void run() {
        printStream.println("enter two numbers:");
        int first = scanner.nextInt();
        int second = scanner.nextInt();

        if (first > second) {
            printStream.println("first is greater");
        } else if (second > first) {
            printStream.println("second is greater");
        } else {
            printStream.println("equals");
        }
    }
}
