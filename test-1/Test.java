
public class Test {
    public static void main(String[] args) {
        
        System.out.println("Hello there");

        Course testCourse = new Course(
            new CourseID("SOCI-100-000001"),
                new CourseName("Social Inquiry And Science's"),
                new LectureSessionInfo(2, 1.5, 16),
                        new PracticeSessionInfo(2, 1, 16)
        );

        System.out.println(testCourse.getCourseName());

    }
    
}
