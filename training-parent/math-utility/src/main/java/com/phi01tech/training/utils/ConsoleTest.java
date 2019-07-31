package com.phi01tech.training.utils;

import java.util.Scanner;

public class ConsoleTest {

    public static void main(String[] args) {
        // simulation for user input
        // Mocking
        Scanner scanner = new Scanner(System.in);
        ComparingConsole console = new ComparingConsole(scanner, System.out);
        console.run();
    }
}
