package com.newaeon.training;

public class EqualityTest {

    public static void main(String[] args) {
        User u1 = new User("admin","pass123");
        User u2 = new User("admin","pass123");

        System.out.println(u1.hashCode());
        System.out.println(u2.hashCode());

        System.out.println(u1.equals(u2));

        u1.equals(10);
        u1.equals("dfjdkljf");
    }
}
