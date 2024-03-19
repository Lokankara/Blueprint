package com.solution;

import java.util.Scanner;

public class IntersectionSegments {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        int x4 = scanner.nextInt();
        int y4 = scanner.nextInt();

        Point a = new Point(x1, y1);
        Point b = new Point(x2, y2);
        Point c = new Point(x3, y3);
        Point d = new Point(x4, y4);

        System.out.println(intersect(a, b, c, d) ? "YES" : "NO");
    }

    public static boolean intersect(Point a, Point b, Point c, Point d) {
        int d1 = direction(c, d, a);
        int d2 = direction(c, d, b);
        int d3 = direction(a, b, c);
        int d4 = direction(a, b, d);

        if (((d1 > 0 && d2 < 0) || (d1 < 0 && d2 > 0))
                && ((d3 > 0 && d4 < 0) || (d3 < 0 && d4 > 0))) {
            return true;
        }

        if (d1 == 0 && onSegment(c, d, a)) {
            return true;
        }
        if (d2 == 0 && onSegment(c, d, b)) {
            return true;
        }
        if (d3 == 0 && onSegment(a, b, c)) {
            return true;
        }
        return d4 == 0 && onSegment(a, b, d);
    }

    public static boolean onSegment(Point a, Point b, Point c) {
        return Math.min(a.x, b.x) <= c.x
                && c.x <= Math.max(a.x, b.x)
                && Math.min(a.y, b.y) <= c.y
                && c.y <= Math.max(a.y, b.y);
    }

    public static int direction(Point a, Point b, Point c) {
        return (c.x - a.x) * (b.y - a.y) - (b.x - a.x) * (c.y - a.y);
    }
}
