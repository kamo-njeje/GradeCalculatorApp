package grades;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GradeCalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = null;

        while (true) {
            System.out.println("\n=== Grade Calculator Menu ===");
            System.out.println("1. Create new student");
            System.out.println("2. Add course");
            System.out.println("3. View courses and grades");
            System.out.println("4. Calculate average and result");
            System.out.println("5. Save to files");
            System.out.println("6. Exit");
            System.out.println("7. Edit course");
            System.out.println("8. Delete course");
            System.out.print("Choose an option (1-8): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    student = new Student(name);
                    System.out.println("Student created: " + name);
                    break;

                case 2:
                    if (student == null) {
                        System.out.println("Create a student first (option 1).");
                        break;
                    }
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter mark for " + courseName + ": ");
                    double mark = scanner.nextDouble();
                    scanner.nextLine();

                    Course course = new Course(courseName, mark);
                    student.addCourse(course);
                    System.out.println("Course added.");
                    break;

                case 3:
                    if (student == null) {
                        System.out.println("Create a student first (option 1).");
                        break;
                    }
                    System.out.println("\nCourses and grades:");
                    if (student.getCourses().isEmpty()) {
                        System.out.println("No courses added yet.");
                    } else {
                        int i = 1;
                        for (Course c : student.getCourses()) {
                            System.out.println(i + ". " + c);
                            i++;
                        }
                    }
                    break;

                case 4:
                    if (student == null) {
                        System.out.println("Create a student first (option 1).");
                        break;
                    }
                    double average = student.calculateAverage();
                    System.out.printf("Average mark: %.2f%n", average);
                    String result = (average >= 50) ? "PASS" : "FAIL";
                    System.out.println("Result: " + result);
                    break;

                case 5:
                    if (student == null) {
                        System.out.println("Create a student first (option 1).");
                        break;
                    }
                    saveToFiles(student);
                    break;

                case 6:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);

                case 7:
                    if (student == null) {
                        System.out.println("Create a student first (option 1).");
                        break;
                    }
                    if (student.getCourses().isEmpty()) {
                        System.out.println("No courses to edit.");
                        break;
                    }
                    System.out.println("Select course number to edit:");
                    int editIndex = getCourseIndex(scanner, student);
                    if (editIndex == -1) break;

                    Course toEdit = student.getCourses().get(editIndex);
                    System.out.println("Editing course: " + toEdit.getName() + " (Current mark: " + toEdit.getMark() + ")");
                    System.out.print("Enter new course name (or press Enter to keep): ");
                    String newName = scanner.nextLine();
                    if (!newName.isEmpty()) {
                        toEdit.setName(newName);
                    }
                    System.out.print("Enter new mark (or press Enter to keep): ");
                    String newMarkInput = scanner.nextLine();
                    if (!newMarkInput.isEmpty()) {
                        try {
                            double newMark = Double.parseDouble(newMarkInput);
                            toEdit.setMark(newMark);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid mark input. Mark not changed.");
                        }
                    }
                    System.out.println("Course updated.");
                    break;

                case 8:
                    if (student == null) {
                        System.out.println("Create a student first (option 1).");
                        break;
                    }
                    if (student.getCourses().isEmpty()) {
                        System.out.println("No courses to delete.");
                        break;
                    }
                    System.out.println("Select course number to delete:");
                    int delIndex = getCourseIndex(scanner, student);
                    if (delIndex == -1) break;

                    Course toDelete = student.getCourses().get(delIndex);
                    System.out.println("Deleting course: " + toDelete.getName());
                    student.getCourses().remove(delIndex);
                    System.out.println("Course deleted.");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    private static int getCourseIndex(Scanner scanner, Student student) {
        int numCourses = student.getCourses().size();
        for (int i = 0; i < numCourses; i++) {
            System.out.println((i + 1) + ". " + student.getCourses().get(i));
        }
        System.out.print("Enter number (1-" + numCourses + "): ");
        int idx = scanner.nextInt();
        scanner.nextLine(); // consume newline
        if (idx < 1 || idx > numCourses) {
            System.out.println("Invalid selection.");
            return -1;
        }
        return idx - 1;
    }

    private static void saveToFiles(Student student) {
        double average = student.calculateAverage();
        String result = (average >= 50) ? "PASS" : "FAIL";

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
            System.out.println("Failed to save grades.txt file.");
        }

        try {
            FileWriter csvWriter = new FileWriter("grades.csv");
            csvWriter.write("Course,Mark,Grade\n");
            for (Course c : student.getCourses()) {
                csvWriter.write(c.getName() + "," + c.getMark() + "," + c.getGrade() + "\n");
            }
            csvWriter.write(String.format("Average,,%.2f\n", average));
            csvWriter.write("Result,," + result + "\n");
            csvWriter.close();
            System.out.println("Grades saved to grades.csv");
        } catch (IOException e) {
            System.out.println("Failed to save grades.csv file.");
        }
    }
}
