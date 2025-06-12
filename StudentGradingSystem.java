import java.util.Scanner;

class Student {
    private String name;
    private String studentId;
    private int[] marks;
    private double average;
    private char grade;

    public Student(String name, String studentId, int[] marks) {
        this.name = name;
        this.studentId = studentId;
        this.marks = marks;
        calculateAverage();
        calculateGrade();
    }

    private void calculateAverage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        this.average = (double) sum / marks.length;
    }

    private void calculateGrade() {
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }

    public void displayStudentInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + studentId);
        System.out.print("Marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println("\nAverage: " + average);
        System.out.println("Grade: " + grade);
    }
}

public class StudentGradingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==== Student Grading System ====");

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Enter number of subjects: ");
        int numSubjects = scanner.nextInt();
        int[] marks = new int[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }

        Student student = new Student(name, studentId, marks);
        System.out.println("\n=== Student Result ===");
        student.displayStudentInfo();

        scanner.close();
    }
}
