import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AttendanceManager {
    private List<Student> students;

    public AttendanceManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String id, String name) {
        students.add(new Student(id, name));
        System.out.println("Student added successfully.");
    }

    public void markAttendanceForDate(String date) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Marking Attendance for " + date + " ---");
        
        for (Student s : students) {
            System.out.print("Is " + s.getName() + " (ID: " + s.getId() + ") Present? (y/n): ");
            String input = scanner.next();
            boolean isPresent = input.equalsIgnoreCase("y");
            s.markAttendance(date, isPresent);
        }
        System.out.println("Attendance marked successfully.");
    }

    public void viewAllStudents() {
        System.out.println("\n--- Student List & Stats ---");
        if (students.isEmpty()) {
            System.out.println("No students registered.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }
}