package grades;

public class Course {
    private String name;
    private double mark;

    public Course(String name, double mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public double getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return name + ": " + mark;
    }
}
