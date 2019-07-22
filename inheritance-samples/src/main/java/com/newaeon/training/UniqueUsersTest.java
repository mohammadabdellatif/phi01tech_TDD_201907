package com.newaeon.training;

import java.util.Scanner;

public class UniqueUsersTest {

    public static void main(String[] args) {
        User[] users = new User[3];
        Scanner scanner = new Scanner(System.in);

        main:
        for (int i = 0; i < users.length;) {
            String username = scanner.next();
            String password = scanner.next();
            User newUsr = new User(username, password);
            for (int accepted = 0; accepted < i; accepted++) {
                if (users[accepted].equals(newUsr)) {
                    System.out.println("already exists");
                    continue main;
                }
            }
            System.out.println("accepted");
            users[i++] = newUsr;
        }

        for (User user : users) {
            System.out.println(user);
        }
    }
}