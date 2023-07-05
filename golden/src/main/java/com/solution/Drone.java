package com.solution;

import java.util.Scanner;

public class Drone {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int i = 0; i < t; i++) {
            String s = in.nextLine();
            int[] coordinates = droneExplosion(s);
            System.out.println(coordinates[0] + " " + coordinates[1]);
        }
    }

    public static int[] droneExplosion(String s) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '>') {
                x++;
            } else if (c == '<') {
                x--;
            } else if (c == '^') {
                y++;
            } else if (c == 'v') {
                y--;
            }
        }
        return new int[]{x, y};
    }
}