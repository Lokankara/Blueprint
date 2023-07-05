package com.solution;

import java.io.IOException;
import java.io.PrintWriter;

public class LetterPattern {
    public static void main(String[] args) throws IOException {
        PrintWriter writer = new PrintWriter(System.out);
        for (int i = 1; i < 4; i++) {
            printPattern(i, writer);
        }
        writer.flush();
    }

    private static void printPattern(int times, PrintWriter writer) {
        for (int i = 0; i < times; i++) {
            writer.print((char) ('a' + times - 1));
        }
        writer.println();
    }
}