package com.solution;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Neptune {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int min = 0;
        int max = scanner.nextInt();
        int[][] matrix = new int[max][max];

        IntStream.range(min, max)
                .forEach(i -> IntStream.range(0, max)
                        .forEach(j -> matrix[i][j] =
                                scanner.nextInt()));

        long count = IntStream.range(min, max)
                .flatMap(i -> Arrays.stream(matrix[i], i + 1, max))
                .filter(value -> value == 1)
                .count();

        System.out.println(count);
        scanner.close();
    }
}

