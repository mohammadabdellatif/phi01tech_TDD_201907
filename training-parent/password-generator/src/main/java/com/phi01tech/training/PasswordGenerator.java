package com.phi01tech.training;

import java.util.Random;

public class PasswordGenerator {

    public String generate() {
        String l = "abcdefghijklmnopqrstuvwxyz";
        String num = "0123456789";
        String s = "?!#_";
        String pass = "";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int i1 = random.nextInt(l.length());
            pass += l.charAt(i1);
            l = l.substring(0, i1) + l.substring(i1 + 1);
        }
        for (int i = 0; i < 2; i++) {
            int i1 = random.nextInt(num.length());
            pass += num.charAt(i1);
            num = num.substring(0, i1) + num.substring(i1 + 1);
        }

        for (int i = 0; i < 2; i++) {
            int i1 = random.nextInt(s.length());
            pass += s.charAt(i1);
            s = s.substring(0, i1) + s.substring(i1 + 1);
        }

        String shuffeled = "";
        for (int i = 0; i < 8; i++) {
            int i1 = random.nextInt(pass.length());
            shuffeled += pass.charAt(i1);
            pass = pass.substring(0, i1) + pass.substring(i1 + 1);
        }

        return shuffeled;
    }
}
