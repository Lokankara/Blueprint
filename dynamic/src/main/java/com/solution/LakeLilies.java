package com.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LakeLilies {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int n = Integer.parseInt(reader.readLine());
        int day = 0;
        int lilies = 1;

        while (lilies < n) {
            day++;
            lilies *= 2;
        }
        writer.println(day);
        writer.flush();
    }
}