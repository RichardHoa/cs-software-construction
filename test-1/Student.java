import java.util.HashMap;
import java.util.Map;

class StudentName {
    private final String value;

    public StudentName(String name) {
        int len = name.length();
        if (len < 3 || len > 100) {
            throw new IllegalArgumentException("name must be between 3 and 100 characters long (current length: " + len + ")");
        }

        if (!name.matches("^[\\p{L}\\d' ]+$")) {
            throw new IllegalArgumentException("name can only contain letters, numbers, spaces, and single quotes.");
        }

        this.value = name;
    }

    public String getValue() {
        return value;
    }
}


class StudentID {
    private final String id;

    public StudentID(String id) {
        if (!id.matches("^[0-9]{6}$"))
            throw new IllegalArgumentException("id must be 6 digits. Ex: 230165");

        this.id = id;
    }

    public String getValue() {
        return id;
    }
}

class CourseLoad {
    private final Map<Course, Grade> enrollments = new HashMap<>();
    private static final int MAX_COURSES = 6;

    public CourseLoad() {
    }

    public void addCourse(Course course, Grade grade) {
        if (enrollments.size() >= MAX_COURSES) {
            throw new IllegalStateException("Maximum course limit reached (6)");
        }

        enrollments.put(course, grade);
    }

    public Map<Course, Grade> getEnrollments() {
        return enrollments;
    }

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
            System.out.println(
                "- " + course.getCourseName() + " : " + course.getCourseID()
                + "\n | " + grade
                + "\n | Total lecture hours: " + course.getTotalLectureHours()
                + "\n | Total practice hours: " + course.getTotalPracticeHours()
                + "\n | Total hours: " + course.getTotalHours()

            );
        });
    }

}


