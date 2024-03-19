package com.solution;

import java.util.Scanner;

public class Baghdad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] min = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10};
        int[] max = {1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11};
//        int[] N = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22};
        int n = 0;
        for (int i = 0; i < N; i++) {
            n = i + 3;

            int minHonest = (n + 2) / 3;
            int maxHonest = (n / 2);
            System.out.println(minHonest + " " + maxHonest);
        }
    }
}
