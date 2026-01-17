
public class Test {
    public static void main(String[] args) {
        
        Student hoa = new Student(
            new StudentName("Thái Hoà"),
            new StudentID("230165")
        );

        Course testCourse = new Course(
            new CourseID("SOCI-100-000001"),
            new CourseName("Social Inquiry And Science's"),
            new LectureSessionInfo(2, 1.5, 16),
            new PracticeSessionInfo(2, 1.25, 16)
        );

        Grade grade = new Grade(50, 75, 20);

        hoa.enroll(testCourse, grade);

        hoa.printReport();

    }
    
}
