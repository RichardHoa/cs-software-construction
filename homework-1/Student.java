import java.util.HashMap;
import java.util.Map;

class StudentName {
    private final String value;

    public StudentName(String name) {
        if (!name.matches("^[a-zA-Z0-9 ]{3,100}$")) 
            throw new IllegalArgumentException("Invalid name format or length");
        this.value = name;
    }
    public String getValue() { return value; }
}

class StudentID {
    private final String id;

    public StudentID(String id) {
        if (!id.matches("^[0-9]{6}$")) throw new IllegalArgumentException("ID must be 6 digits");
        this.id = id;
    }
    public String getValue() { return id; }
}

class CourseLoad {
    private final Map<Course, Grade> enrollments = new HashMap<>();
    private static final int MAX_COURSES = 6;

    public void addCourse(Course course, Grade grade) {
        if (enrollments.size() >= MAX_COURSES) 
            throw new IllegalStateException("Maximum course limit reached (6)");
        enrollments.put(course, grade);
    }

    public Map<Course, Grade> getEnrollments() { return enrollments; }
}

public class Student {
    private final StudentName name;
    private final StudentID id;
    private final CourseLoad courseLoad;

    public Student(StudentName name, StudentID id) {
        this.name = name;
        this.id = id;
        this.courseLoad = new CourseLoad();
    }

    public void enroll(Course course, Grade grade) {
        courseLoad.addCourse(course, grade);
    }

    public void printReport() {
        System.out.println("Student: " + name.getValue() + " (" + id.getValue() + ")");
        courseLoad.getEnrollments().forEach((course, grade) -> {
            System.out.println("- " + course.getName() + ": " + grade);
        });
    }
}    
