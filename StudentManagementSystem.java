import java.util.ArrayList;

public class StudentManagementSystem {

    private ArrayList<Student> students=new ArrayList<>();

    public StudentManagementSystem() {
    }

    public void addStudent(Student student) {
        if (student == null) {
            System.out.println("Invalid student.");
            return;
        }

        if (searchStudent(student.getStudentId()) != null) {
            System.out.println("Error: Student ID already exists.");
            return;
        }

        students.add(student);
        System.out.println("Student added successfully.");
    }

    public Student searchStudent(int id) { // ← int بدل String
        for (Student s : students) {
            if (s.getStudentId() == id) { // ← مقارنة int
                return s;
            }
        }
        return null;
    }

    public void addSubjectToStudent(int studentId, Subject subject) {
        Student student = searchStudent(studentId);

        if (student == null) {
            System.out.println("Error: Student not found.");
            return;
        }

        if (subject == null) {
            System.out.println("Invalid subject.");
            return;
        }

        student.addSubject(subject);
        System.out.println("Subject added successfully.");
    }

    public void displayStudentInfo(int studentId) {
        Student student = searchStudent(studentId);

        if (student == null) {
            System.out.println("Error: Student not found.");
            return;
        }

        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Student Name: " + student.getStudentName());
        System.out.println("Subjects: " + student.getSubjects().size());
        System.out.println("GPA: " + student.calculateGPA());
    }

    public void calculateStudentGPA(int studentId) {
        Student student = searchStudent(studentId);

        if (student == null) {
            System.out.println("Error: Student not found.");
            return;
        }

        double gpa = student.calculateGPA();

        System.out.println("Student: " + student.getStudentName());
        System.out.println("GPA: " + gpa);
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }

        int i = 1;
        for (Student s : students) {
            System.out.println(i + ". " + s.getStudentName() + " (ID: " + s.getStudentId() + ")");
            i++;
        }
    }

    public void removeStudent(int studentId) {
        Student student = searchStudent(studentId);

        if (student == null) {
            System.out.println("Error: Student not found.");
            return;
        }

        students.remove(student);
        System.out.println("Student removed successfully.");
    }

    public void removeSubject(int studentId, int subjectIndex) {
        Student student = searchStudent(studentId);

        if (student == null) {
            System.out.println("Error: Student not found.");
            return;
        }

        ArrayList<Subject> subjects = student.getSubjects();

        if (subjectIndex < 0 || subjectIndex >= subjects.size()) {
            System.out.println("Error: Invalid subject number.");
            return;
        }

        subjects.remove(subjectIndex);
        System.out.println("Subject removed successfully.");
    }

    public Student getHighestGPAStudent() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return null;
        }

        Student topStudent = students.get(0);
        double highestGPA = topStudent.calculateGPA();

        for (Student s : students) {
            double currentGPA = s.calculateGPA();

            if (currentGPA > highestGPA) {
                highestGPA = currentGPA;
                topStudent = s;
            }
        }

        return topStudent;
    }

    public char convertToLetterGrade(int grade) {
        if (grade < 0 || grade > 100) {
            System.out.println("Invalid grade.");
            return 'X';
        }

        if (grade >= 90) return 'A';
        else if (grade >= 80) return 'B';
        else if (grade >= 70) return 'C';
        else if (grade >= 60) return 'D';
        else return 'F';
    }
}