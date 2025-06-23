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

    public void setName(String name) {
        this.name = name;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String getGrade() {
        if (mark >= 75) return "A";
        else if (mark >= 65) return "B";
        else if (mark >= 50) return "C";
        else if (mark >= 40) return "D";
        else return "F";
    }

    @Override
    public String toString() {
        return name + ": " + mark + " → Grade: " + getGrade();
    }
}
