import java.util.Scanner;

class Student {
    String name;
    int[] marks = new int[3];
    double average;
    char grade;

    void inputData(Scanner sc) {
        System.out.print("\nEnter student name: ");
        name = sc.nextLine();

        System.out.println("Enter marks for 3 subjects:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
        sc.nextLine(); // consume newline
    }

    void calculateGrade() {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }

        average = sum / 3.0;

        if (average >= 80) {
            grade = 'A';
        } else if (average >= 60) {
            grade = 'B';
        } else if (average >= 40) {
            grade = 'C';
        } else {
            grade = 'F';
        }
    }

    void displayReport() {
        System.out.println("\n--- Student Report ---");
        System.out.println("Name: " + name);

        System.out.println("Marks:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Subject " + (i + 1) + ": " + marks[i]);
        }

        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade);
    }
}

public class StudentGradeSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        Student[] students = new Student[n];

        // Input + calculation
        for (int i = 0; i < n; i++) {
            students[i] = new Student();
            students[i].inputData(sc);
            students[i].calculateGrade();
        }

        // Display all reports
        System.out.println("\n===== ALL STUDENT REPORTS =====");
        for (int i = 0; i < n; i++) {
            students[i].displayReport();
        }

        sc.close();
    }
}