package AV4.Algorithms;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Interval implements Comparable<Interval> {
    String name;
    int startTime;
    int endTime;
    boolean isDeleted;

    public Interval(String name, int startTime, int endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isDeleted = false;
    }

    @Override
    public String toString() {
        return "Interval(" + name + "): [" + startTime + ", " + endTime + "]";
    }

    @Override
    public int compareTo(Interval o) {
        return Integer.compare(this.startTime, o.startTime);
    }
}

public class Intervals {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String name = parts[0];
            int start = Integer.parseInt(parts[1]);
            int end = Integer.parseInt(parts[2]);

            Interval interval = new Interval(name, start, end);
            intervals.add(interval);
        }

        sortIntervals(intervals);

        int deletedCount = 0;
        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervals.get(i-deletedCount).endTime > intervals.get(i + 1).startTime) {
                intervals.get(i-deletedCount).endTime = Math.max(intervals.get(i-deletedCount).endTime, intervals.get(i + 1).endTime);
                intervals.get(i + 1).isDeleted = true;
                deletedCount++;
            }
        }

        for (int i = 0; i < intervals.size(); i++) {
            if (!intervals.get(i).isDeleted) {
                System.out.println(intervals.get(i));
            }
        }

    }

    public static void sortIntervals(List<Interval> intervals) {
        for (int i = 0; i < intervals.size(); i++) {
            for (int j = i + 1; j < intervals.size(); j++) {
                if (intervals.get(i).startTime > intervals.get(j).startTime) {
                    Interval temp = intervals.get(i);
                    intervals.set(i, intervals.get(j));
                    intervals.set(j, temp);
                }
            }
        }
    }
}
