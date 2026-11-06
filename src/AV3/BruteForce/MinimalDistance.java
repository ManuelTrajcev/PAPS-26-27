package AV3.BruteForce;

import java.util.Scanner;

class Point {
    String name;
    int x;
    int y;

    Point(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return name + " " + x + " " + y;
    }
}

public class MinimalDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String name = parts[0];
            int x = Integer.parseInt(parts[1]);
            int y = Integer.parseInt(parts[2]);

            Point p = new Point(name, x, y);
            points[i] = p;
        }

        double minDistance = Double.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double currentDistance = distance(points[i], points[j]);
                if (currentDistance < minDistance) {
                    minDistance = currentDistance;
                }
            }
        }

        System.out.println("Minimal distance: " + minDistance);

    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p1.x - p2.x), 2) + (p1.y - p2.y) * (p1.y - p2.y));
    }
}
