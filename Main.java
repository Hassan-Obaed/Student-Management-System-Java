import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        // حلقة تكرارية لعرض القائمة بشكل مستمر حتى يقرر المستخدم الخروج
        while (true) {

            // عرض الخيارات المتاحة للمستخدم
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Subject to Student");
            System.out.println("3. Display Student Information");
            System.out.println("4. Calculate GPA");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            // استقبال اختيار المستخدم
            int choice = input.nextInt();
            input.nextLine(); // تفريغ الذاكرة المؤقتة (Buffer) لمنع تخطي المدخلات النصية التالية

            switch (choice) {

                case 1:
                    // بلوك إضافة طالب جديد
                    System.out.print("Enter ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter Major: ");
                    String major = input.nextLine();

                    // التحقق من صحة الاسم (ألا يكون فارغاً)
                    if (name.trim().isEmpty()) {
                        System.out.println("Invalid name. Student not added.");
                        break;
                    }

                    // إنشاء كائن الطالب وإضافته للنظام
                    Student s = new Student(id, name, major);
                    system.addStudent(s);
                    break;

                case 2:
                    // بلوك إضافة مادة دراسية لطالب موجود
                    System.out.print("Enter Student ID: ");
                    int sid = input.nextInt();
                    input.nextLine();

                    // منطق محسن: التأكد من وجود الطالب أولاً قبل طلب بيانات المادة
                    if (system.searchStudent(sid) == null) {
                        System.out.println("Error: Student ID not found. Please add the student first.");
                        break;
                    }

                    System.out.print("Enter Subject Name: ");
                    String sub = input.nextLine();

                    System.out.print("Enter Credit Hours: ");
                    int hours = input.nextInt();

                    System.out.print("Enter Grade (0-100): ");
                    double grade = input.nextDouble();
                    input.nextLine();

                    // التحقق من صحة الدرجة
                    if (grade < 0 || grade > 100) {
                        System.out.println("Invalid grade. Must be between 0 and 100.");
                        break;
                    }

                    // إنشاء كائن المادة وربطه بالطالب
                    Subject subject = new Subject(sub, hours, grade);
                    system.addSubjectToStudent(sid, subject);
                    break;

                case 3:
                    // بلوك عرض بيانات طالب محدد باستخدام الرقم التعريفي
                    System.out.print("Enter Student ID: ");
                    int searchId = input.nextInt();
                    input.nextLine();
                    system.displayStudentInfo(searchId);
                    break;

                case 4:
                    // بلوك حساب المعدل التراكمي (GPA) لطالب محدد
                    System.out.print("Enter Student ID: ");
                    int gpaId = input.nextInt();
                    input.nextLine();
                    system.calculateStudentGPA(gpaId);
                    break;

                case 5:
                    // بلوك عرض قائمة بجميع الطلاب المسجلين في النظام
                    system.displayAllStudents();
                    break;

                case 6:
                    // بلوك الخروج من البرنامج
                    System.out.println("Exiting System... Bye! 👋");
                    return;

                default:
                    // معالجة الاختيارات غير الصحيحة
                    System.out.println("Invalid choice! Please select a number from 1 to 6.");
            }
        }
    }
}