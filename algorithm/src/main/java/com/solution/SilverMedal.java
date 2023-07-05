package com.solution;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SilverMedal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] scores = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
        Arrays.sort(scores);
        IntStream.iterate(n - 1, i -> i >= 0, i -> i - 1)
                .filter(i -> scores[i] != scores[i - 1]).findFirst()
                .ifPresent(i -> System.out.println(scores[i - 1]));
    }
}
