package com.solution;
import java.util.Scanner;

public class Toasts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int time = n > k
                ? (int) Math.ceil(1.0 * 2 * n / k) * 2
                : n != 0
                ? 4
                : 0;
        System.out.println(time);
    }
}
