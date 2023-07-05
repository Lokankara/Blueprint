package com.solution;

import java.util.Scanner;

public class Snowmobile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int time = 0;
        while (sc.hasNext()) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
            time += (int) Math.round(distance / 20000 * 60);
        }
        double distanceToHangar = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        time += (int) Math.round(distanceToHangar / 20000 * 60);
        System.out.println(time / 60 + ":" + String.format("%02d", time % 60));
    }
}
