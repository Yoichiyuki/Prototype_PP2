
import java.util.ArrayList;

class ClassSession{
    private String courseName;
    private ArrayList<Student> students;
    private ArrayList<AttendanceRecord> records;

    public ClassSession(String courseName){
        this.courseName = courseName;
        students = new ArrayList<>();
        records = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }
    
    public void recordAttendance(AttendanceRecord record){
        records.add(record);
    }

}