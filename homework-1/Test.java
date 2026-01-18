
public class Test {
    public static void main(String[] args) {
        
        Student hoa = new Student(
            new StudentName("Thái Hoà"),
            new StudentID("230165")
        );

        Semester spring2026 = new Semester(
                new SemesterName("Spring 2026")
        );

        Semester fall2026 = new Semester(
                new SemesterName("Fall 2026")
        );

        Semester summer2026 = new Semester(
                new SemesterName("Summer 2026")
        );

        Semester spring2027 = new Semester(
                new SemesterName("Spring 2027")
        );

        hoa.addSemester(spring2026);
        hoa.addSemester(fall2026);
        hoa.addSemester(summer2026);
        // hoa.addSemester(spring2027);

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

        spring2026.enroll(testCourse, grade);
        spring2026.enroll(testCourse_2, grade);
        spring2026.enroll(testCourse_3, grade);
        spring2026.enroll(testCourse_4, grade);
        spring2026.enroll(testCourse_5, grade);
        spring2026.enroll(testCourse_6, grade);
        // spring2026.enroll(testCourse_7, grade);

        hoa.printReport();

    }
    
}
