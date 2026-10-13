import java.util.ArrayList;

public class Student {

     int id; // ← زي ما انت عايز (int)
     String name;
     String department;
     ArrayList<Subject> subjects = new ArrayList<>();

    public Student(int id, String name, String major) {
        this.id = id;
        this.name = name;
        this.department = major;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public double calculateGPA() { // ← نوحد الاسم مع السيستم
        double total = 0;
        int hours = 0;

        for (int i = 0; i < subjects.size(); i++) {
            Subject s = subjects.get(i);
            total += s.getGrade() * s.getCreditHours();
            hours += s.getCreditHours();
        }

        return (hours == 0) ? 0.0 : total / hours;
    }
    public int getStudentId() {
        return id;
    }
    public String getStudentName() {
        return name;
    }
    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
}