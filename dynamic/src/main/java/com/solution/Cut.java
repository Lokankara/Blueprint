package com.solution;

import java.util.Scanner;

public class Cut {

    public static int min(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                i++;
            }
        }
        return count == 0 ? 0 : Math.min(count, 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(min(s));
    }
}