package com.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Three {
    public static void main(String[] args) throws IOException {
        PrintWriter writer = new PrintWriter(System.out);
        long n = Long.parseLong(new BufferedReader(
                new InputStreamReader(System.in)).readLine());
        long count = (n / 3) * 2;
        if (n % 3 == 2) {
            count++;
        }
        writer.println(count);
        writer.flush();
    }
}
