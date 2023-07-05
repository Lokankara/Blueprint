package com.solution;

import java.io.PrintWriter;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        writer.println(isPalindrome(in.nextInt()) ? "Yes" : "No");
        writer.close();
    }

    public static boolean isPalindrome(int number) {
        int reversed = 0;
        int original = number;
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return original == reversed;
    }
}
