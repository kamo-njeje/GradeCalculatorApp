package grades;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public double calculateAverage() {
        if (courses.isEmpty()) return 0;
        double total = 0;
        for (Course c : courses) {
            total += c.getMark();
        }
        return total / courses.size();
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getName() {
        return name;
    }
}
