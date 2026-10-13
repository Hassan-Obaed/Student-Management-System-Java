public class Subject {
    String subjectName;
    int creditHours;
    double grade;
    
    public Subject(String subjectName, int creditHours, double grade) {
        this.subjectName = subjectName;
        this.creditHours = creditHours;
        this.grade = grade;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public double getGrade() {
        return grade;
    }
}