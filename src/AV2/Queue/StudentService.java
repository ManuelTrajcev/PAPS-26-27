package AV2.Queue;

import impl.Queue.LinkedQueue;
import impl.Queue.Queue;

import java.util.Scanner;

class Student {
    String id;
    Integer minutes;

    public Student(String id, Integer minutes) {
        this.id = id;
        this.minutes = minutes;
    }


    @Override
    public String toString() {
        return "Student{id='" + id + "', minutes=" + minutes + "}";
    }
}

public class StudentService {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Student> queue = new LinkedQueue<Student>();
        Integer timeLeft = 180;

        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String id = parts[0];
            Integer minutes = Integer.parseInt(parts[1]);
            Student student = new Student(id, minutes);
            queue.enqueue(student);
        }

        while (!queue.isEmpty() && timeLeft > 0) {
            Student currentStudent = queue.peek();
            if(currentStudent.minutes <= timeLeft) {
                timeLeft -= currentStudent.minutes;
                queue.dequeue();
            } else {
                break;
            }
        }
        if(queue.isEmpty()) {
            System.out.println("All students have been processed.");
        } else {
            System.out.println("First Student in the queue: " + queue.peek());
        }

        Integer sum = 0;

        while (!queue.isEmpty()) {
            sum += queue.dequeue().minutes;
        }

        System.out.println("Total remaining time for all students in the queue: " + sum + " minutes.");
    }
}
