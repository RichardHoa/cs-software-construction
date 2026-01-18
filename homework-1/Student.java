import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public void addCourse(Course course, Grade grade) {
        if (enrollments.size() >= MAX_COURSES) {
            throw new IllegalStateException("Maximum course limit reached (" + MAX_COURSES + ")");
        } else {
            enrollments.put(course, grade);
        }

    }

    public Map<Course, Grade> getEnrollments() {
        return enrollments;
    }

}

class SemesterName {
    private final String value;

    public SemesterName(String name) {
        String[] parts = name.split(" ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Format must be 'Season Year' (e.g., 'Spring 2026')");
        }

        String season = parts[0];
        if (!season.equals("Spring") && !season.equals("Summer") && !season.equals("Fall")) {
            throw new IllegalArgumentException("Season must be Spring, Summer, or Fall");
        }

        try {
            int year = Integer.parseInt(parts[1]);
            if (year < 2026 || year > 2031) {
                throw new IllegalArgumentException("Year must be between 2026 and 2031");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Year must be a valid number");
        }

        this.value = name;
    }

    public String getValue() { return value; }
}

class Semester {
    private final SemesterName name;
    private final CourseLoad courseLoad;

    public Semester(SemesterName name) {
        this.name = name;
        this.courseLoad = new CourseLoad();
    }

    public void enroll(Course course, Grade grade) {
        courseLoad.addCourse(course, grade);
    }

    public SemesterName getName() { return name; }
    public CourseLoad getCourseLoad() { return courseLoad; }
}

public class Student {
    private final StudentName name;
     private final StudentID id;
     private final List<Semester> semesters;
     private static final int MAX_SEMESTERS = 3;

     public Student(StudentName name, StudentID id) {
         this.name = name;
         this.id = id;
         this.semesters = new ArrayList<>();
     }

     public void addSemester(Semester semester) {
         if (this.semesters.size() >= MAX_SEMESTERS) {
            throw new IllegalStateException("Maximum semesters reached (" + MAX_SEMESTERS + ")");
        } else {
            this.semesters.add(semester);
        }
    }

     public void printReport() {
         System.out.println("Student: " + name.getValue() + " (" + id.getValue() + ")");

         for (Semester sem : semesters) {
             System.out.println("\n--- Semester: " + sem.getName().getValue() + " ---");
             sem.getCourseLoad().getEnrollments().forEach((course, grade) -> {
                 System.out.println(
                         "- " + course.getCourseName() + " : " + course.getCourseID() 
                                 + "\n | " + grade
                                 + "\n | Total lecture hours: " + course.getTotalLectureHours() 
                                 + "\n | Total practice hours: " + course.getTotalPracticeHours() 
                                 + "\n | Total hours: " + course.getTotalHours() 
                                 + "\n");
             });
         }
     }


}


