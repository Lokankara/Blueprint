package com.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Permutations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int n = Integer.parseInt(reader.readLine());
        int[] arr = IntStream.range(0, n).map(i -> i + 1).toArray();
        permute(arr, writer);
        writer.flush();
        writer.close();
    }

    private static void permute(int[] arr, PrintWriter writer) {
        int len = arr.length;
        write(arr, writer);
        int i = len - 2;
        while (i >= 0) {
            int j = len - 1;
            while (j > i && arr[j] <= arr[i]) {
                j--;
            }
            if (j > i) {
                swap(arr, i, j);
                reverse(arr, i + 1, len - 1);
                write(arr, writer);
                i = len - 2;
            } else {
                i--;
            }
        }
    }

    private static void write(int[] arr, PrintWriter writer) {
        Arrays.stream(arr)
                .mapToObj(n -> n + " ")
                .forEach(writer::print);
        writer.println();
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }
}