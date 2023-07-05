package com.solution;

import java.util.Scanner;
import java.util.stream.IntStream;

public class PaintBridges {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] matrix = IntStream.range(0, n)
                .mapToObj(i -> IntStream.range(0, n)
                        .map(j -> scanner.nextInt())
                        .toArray())
                .toArray(int[][]::new);

        int[] colors = IntStream.range(0, n)
                .map(i -> scanner.nextInt())
                .toArray();

        long paint = IntStream.range(0, n)
                .flatMap(i -> IntStream.range(i + 1, n)
                        .filter(j -> matrix[i][j] == 1 && colors[i] != colors[j]))
                .count();
        System.out.println(paint);
    }
}
