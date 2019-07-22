package com.newaeon.training;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        User[] users = new User[]{
                new Talent("t1", "pass123"),
                new ServiceProvider("s1", "pass321")
        };
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter username password:");
        String username = scanner.next();
        String password = scanner.next();
        boolean success = authenticate(username, password, users);
        if (success)
            System.out.println("welcome");
        else
            System.out.println("invalid username/password");
    }

    public static boolean authenticate(String username,
                                       String password,
                                       User[] users) {
        for (User user : users) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password))
                return true;
        }
        return false;
    }

}
