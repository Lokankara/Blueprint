package com.solution;

import java.io.PrintWriter;
import java.util.Scanner;

public class CutString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        String s = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count = (count > 0 && s.charAt(count - 1) == s.charAt(i))
                    ? count - 1 : count + 1;
        }
        writer.println(count % 2);
        writer.flush();
    }
}
