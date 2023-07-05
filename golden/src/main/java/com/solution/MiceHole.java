package com.solution;

import java.util.Arrays;
import java.util.Scanner;

public class MiceHole {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] mice = new int[n];
        for (int i = 0; i < n; i++) {
            mice[i] = in.nextInt();
        }
        int[] holes = new int[n];
        for (int i = 0; i < n; i++) {
            holes[i] = in.nextInt();
        }
        System.out.println(minTime(mice, holes));
    }

    public static int minTime(int[] mice, int[] holes) {
        Arrays.sort(mice);
        Arrays.sort(holes);
        int maxTime = 0;
        for (int i = 0; i < mice.length; i++) {
            maxTime = Math.max(maxTime, Math.abs(mice[i] - holes[i]));
        }
        return maxTime;
    }
}
