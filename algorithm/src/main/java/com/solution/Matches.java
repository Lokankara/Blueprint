package com.solution;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Matches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int n = scanner.nextInt();
        int[] arr;
        for (int i = 0; i < n; i++) {
            arr = IntStream.range(0, 12).map(j -> scanner.nextInt()).toArray();
            Arrays.sort(arr);
            writer.println(arr[0] == arr[3] && arr[4] == arr[7] && arr[8] == arr[11] ? "yes" : "no");
        }
        writer.flush();
    }
}
