import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    String name;
    double marks;
    String grade;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }

    private String calculateGrade(double marks) {
        if (marks >= 91 && marks <= 100)
            return "S";
        else if (marks >= 81 && marks <= 90)
            return "A";
        else if (marks >= 71 && marks <= 80)
            return "B";
        else if (marks >= 61 && marks <= 70)
            return "C";
        else if (marks >= 51 && marks <= 60)
            return "D";
        else if (marks >= 0 && marks <= 50)
            return "F";
        else
            return "Invalid";
    }
}

public class StudentGradeManager {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("=================================");
        System.out.println("   STUDENT GRADE MANAGEMENT");
        System.out.println("=================================");

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Input student details
        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Marks (0-100): ");
            double marks = sc.nextDouble();
            sc.nextLine();

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid Marks! Please enter marks between 0 and 100.");
                i--;
                continue;
            }

            students.add(new Student(name, marks));
        }

        // Sort students by marks in descending order
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.marks, s1.marks);
            }
        });

        // Calculate statistics
        double total = 0;
        double highest = students.get(0).marks;
        double lowest = students.get(0).marks;

        for (Student s : students) {
            total += s.marks;

            if (s.marks > highest)
                highest = s.marks;

            if (s.marks < lowest)
                lowest = s.marks;
        }

        double average = total / students.size();

        // Display report
        System.out.println("\n==============================================");
        System.out.println("              STUDENT REPORT");
        System.out.println("==============================================");

        System.out.printf("%-5s %-15s %-10s %-10s%n",
                "Rank", "Name", "Marks", "Grade");

        System.out.println("----------------------------------------------");

        int rank = 1;
        for (Student s : students) {
            System.out.printf("%-5d %-15s %-10.2f %-10s%n",
                    rank++, s.name, s.marks, s.grade);
        }

        System.out.println("----------------------------------------------");
        System.out.printf("Average Marks : %.2f%n", average);
        System.out.printf("Highest Marks : %.2f%n", highest);
        System.out.printf("Lowest Marks  : %.2f%n", lowest);

        System.out.println("==============================================");

        sc.close();
    }
}