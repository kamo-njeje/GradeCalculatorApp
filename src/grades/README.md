#  Grade Calculator App (Java OOP)

This is a simple Java console application that allows a student to enter course names and marks, calculates the average, and determines whether the student passed or failed. The results are also saved to a `grades.txt` file.

##  Features
- Object-Oriented structure (`Student`, `Course`)
- Input: course names + marks
- Output: average + pass/fail status
- File export to `grades.txt`
- Uses the `grades` Java package

---

##  Example

Enter your name: Kamohelo
How many courses? 3
Enter course name: IMOB
Enter mark for IMOB: 70
Enter course name: IADA
Enter mark for IADA: 45
Enter course name: Networks
Enter mark for Networks: 55

Average mark: 56.67
Result: PASS
Grades saved to grades.txt

##  How to Run

```bash
javac -d out src/grades/*.java
java -cp out grades.GradeCalculatorApp

## Technologies

- Java
- OOP (Object-Oriented Programming)
- File I/O
- CLI (Command Line Interface)

---

## Author

Developed by **Kamohelo Njeje** — third-year IT student exploring design patterns, clean code, and GitHub projects.