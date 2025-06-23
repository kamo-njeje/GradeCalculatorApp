package grades;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GradeCalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String studentName = scanner.nextLine();
        Student student = new Student(studentName);

        System.out.print("How many courses? ");
        int numCourses = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < numCourses; i++) {
            System.out.print("Enter course name: ");
            String courseName = scanner.nextLine();

            System.out.print("Enter mark for " + courseName + ": ");
            double mark = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            Course course = new Course(courseName, mark);
            student.addCourse(course);
        }

        double average = student.calculateAverage();
        System.out.printf("Average mark: %.2f%n", average);

        if (average >= 50) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }

        // Save to grades.txt
        try {
            FileWriter writer = new FileWriter("grades.txt");
            writer.write("Student: " + student.getName() + "\n");
            writer.write("Courses:\n");
            for (Course c : student.getCourses()) {
                writer.write(c.toString() + "\n");
            }
            writer.write(String.format("Average: %.2f%n", average));
            writer.write(average >= 50 ? "Result: PASS\n" : "Result: FAIL\n");
            writer.close();
            System.out.println("Grades saved to grades.txt");
        } catch (IOException e) {
            System.out.println("Failed to save file.");
        }

        scanner.close();
    }
}
