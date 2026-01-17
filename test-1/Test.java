
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

        Course testCourse_2 = new Course(
            new CourseID("SOCI-100-000001"),
            new CourseName("Social Inquiry And Science's"),
            new LectureSessionInfo(2, 1.5, 16),
            new PracticeSessionInfo(2, 1.25, 16)
        );

        Course testCourse_3 = new Course(
            new CourseID("SOCI-100-000001"),
            new CourseName("Social Inquiry And Science's"),
            new LectureSessionInfo(2, 1.5, 16),
            new PracticeSessionInfo(2, 1.25, 16)
        );

        Course testCourse_4 = new Course(
            new CourseID("SOCI-100-000001"),
            new CourseName("Social Inquiry And Science's"),
            new LectureSessionInfo(2, 1.5, 16),
            new PracticeSessionInfo(2, 1.25, 16)
        );

        Course testCourse_5 = new Course(
            new CourseID("SOCI-100-000001"),
            new CourseName("Social Inquiry And Science's"),
            new LectureSessionInfo(2, 1.5, 16),
            new PracticeSessionInfo(2, 1.25, 16)
        );

        Course testCourse_6 = new Course(
            new CourseID("SOCI-100-000001"),
            new CourseName("Social Inquiry And Science's"),
            new LectureSessionInfo(2, 1.5, 16),
            new PracticeSessionInfo(2, 1.25, 16)
        );


        Course testCourse_7 = new Course(
            new CourseID("SOCI-100-000001"),
            new CourseName("Social Inquiry And Science's"),
            new LectureSessionInfo(2, 1.5, 16),
            new PracticeSessionInfo(2, 1.25, 16)
        );
        Grade grade = new Grade(50, 75, 20);

        hoa.enroll(testCourse, grade);
        hoa.enroll(testCourse_2, grade);
        hoa.enroll(testCourse_3, grade);
        hoa.enroll(testCourse_4, grade);
        hoa.enroll(testCourse_5, grade);
        hoa.enroll(testCourse_6, grade);
        // hoa.enroll(testCourse_7, grade);

        hoa.printReport();

    }
    
}
