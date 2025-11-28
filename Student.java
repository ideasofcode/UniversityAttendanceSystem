import java.util.HashMap;
import java.util.Map;

public class Student {
    private String id;
    private String name;
    // Stores Date (String) -> Status (Boolean: true=Present, false=Absent)
    private Map<String, Boolean> attendanceRecord;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.attendanceRecord = new HashMap<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }

    public void markAttendance(String date, boolean isPresent) {
        attendanceRecord.put(date, isPresent);
    }

    public boolean isPresent(String date) {
        return attendanceRecord.getOrDefault(date, false);
    }

    public double getAttendancePercentage() {
        if (attendanceRecord.isEmpty()) return 0.0;
        long presentCount = attendanceRecord.values().stream().filter(p -> p).count();
        return (double) presentCount / attendanceRecord.size() * 100;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Attendance: " + String.format("%.2f", getAttendancePercentage()) + "%";
    }
}