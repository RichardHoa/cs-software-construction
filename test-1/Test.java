
public class Test {
    public static void main(String[] args) {
        
        System.out.println("Hello there");
        LectureSessionInfo lecture_1 = new LectureSessionInfo(3, 1.5, 16);

        Course testCourse = new Course(
            new CourseID("SOCI-100-000001"),
            new CourseName("Social Inquiry And Science's"),
            lecture_1,
            new PracticeSessionInfo(2, 1, 16)
        );

        testCourse.debug();

    }
    
}
