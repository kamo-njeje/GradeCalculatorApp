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

        System.out.println("\n--- Grade Report ---");
        for (Course c : student.getCourses()) {
            System.out.println(c); // includes grade via toString()
        }

        double average = student.calculateAverage();
        System.out.printf("Average mark: %.2f%n", average);
        String result = (average >= 50) ? "PASS" : "FAIL";
        System.out.println("Result: " + result);

        // Save to grades.txt
        try {
            FileWriter writer = new FileWriter("grades.txt");
            writer.write("Student: " + student.getName() + "\n");
            writer.write("Courses:\n");
            for (Course c : student.getCourses()) {
                writer.write(c.toString() + "\n");
            }
            writer.write(String.format("Average: %.2f%n", average));
            writer.write("Result: " + result + "\n");
            writer.close();
            System.out.println("Grades saved to grades.txt");
        } catch (IOException e) {
            System.out.println("Failed to save file.");
        }

        // Save to grades.csv
        try {
            FileWriter csvWriter = new FileWriter("grades.csv");
            csvWriter.write("Course,Mark,Grade\n"); // Header
            for (Course c : student.getCourses()) {
                csvWriter.write(c.getName() + "," + c.getMark() + "," + c.getGrade() + "\n");
            }
            csvWriter.write(String.format("Average,,%.2f\n", average));
            csvWriter.write("Result,," + result + "\n");
            csvWriter.close();
            System.out.println("Grades saved to grades.csv");
        } catch (IOException e) {
            System.out.println("Failed to save CSV file.");
        }

        scanner.close();
    }
}
