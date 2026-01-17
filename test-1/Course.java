class CourseID {
    private final String id;

    public CourseID(String id) {
        String[] parts = id.split("-");

        if (parts.length != 3) {
            throw new IllegalArgumentException(
                    "Invalid CourseID format. Expected PREFIX-LEVEL-SUFFIX. Ex: SOCI-100-000001");
        }

        if (!parts[0].matches("^[A-Z]+$")) {
            throw new IllegalArgumentException("PREFIX must be uppercase letters only.");
        }

        int courseLevel = Integer.parseInt(parts[1]);
        if (courseLevel < 100 || courseLevel > 300) {
            throw new IllegalArgumentException("LEVEL must be between 100 and 300.");
        }

        int courseSuffix = Integer.parseInt(parts[2]);
        if (courseSuffix < 1 || courseSuffix > 1000000) {
            throw new IllegalArgumentException("SUFFIX must be between 1 and 1,000,000.");
        }

        this.id = id;
    }

    public String getValue() {
        return this.id;
    }

}

class CourseName {
    private final String name;

    public CourseName(String name) {
        int nameLength = name.length();
        if (nameLength < 3 || nameLength > 200) {
            throw new IllegalArgumentException("Course name must be between 3 and 200 characters");
        }

        if (!name.matches("[a-zA-Z'\\\" ]+")) {
            throw new IllegalArgumentException(
                    "Course name can only contain letters, single quotes, and double quotes");
        }

        this.name = name;
    }

    public String getValue() {
        return this.name;
    }

}

abstract class CourseSessionInfo {
    protected final int sessionsPerWeek;
    protected final double durations;
    protected final int numberOfWeeks;

    public CourseSessionInfo(int sessionsPerWeek, double durations, int numberOfWeeks) {
        if ((durations * 100) % 25 != 0) {
            throw new IllegalArgumentException("Duration must be in 0.25 increments (e.g., 1.25, 1.5).");
        }

        if (numberOfWeeks < 12 || numberOfWeeks > 20) {
            throw new IllegalArgumentException("Number of weeks must be between 12 and 20");
        }

        this.sessionsPerWeek = sessionsPerWeek;
        this.durations = durations;
        this.numberOfWeeks = numberOfWeeks;
    }

    public double getTotalHours() {
        return this.sessionsPerWeek * this.durations * this.numberOfWeeks;
    }
}

class LectureSessionInfo extends CourseSessionInfo {
    public LectureSessionInfo(int sessionsPerWeek, double durations, int numberOfWeeks) {
        super(sessionsPerWeek, durations, numberOfWeeks);
        
        if (sessionsPerWeek != 1 && sessionsPerWeek != 2) {
            throw new IllegalArgumentException("Lecture sessions per week must be 1 or 2");
        }
        if (durations != 1.5 && durations != 3.0) {
            throw new IllegalArgumentException("Lecture durations must be 1.5 or 3.0");
        }
    }
}

class PracticeSessionInfo extends CourseSessionInfo {
    public PracticeSessionInfo(int sessionsPerWeek, double durations, int numberOfWeeks) {
        super(sessionsPerWeek, durations, numberOfWeeks);

        if (sessionsPerWeek < 1 || sessionsPerWeek > 3) {
            throw new IllegalArgumentException("Practice sessions per week must be between 1 and 3");
        }
        if (durations < 1.0 || durations > 3.0) {
            throw new IllegalArgumentException("Practice durations must be between 1.0 and 3.0 hours");
        }
    }
}


class Grade {
    private final int midterm;
    private final int project;
    private final int finalExam;

    public Grade(int midterm, int project, int finalExam) {
        if (isInvalidGrade(midterm) || isInvalidGrade(project) || isInvalidGrade(finalExam)) {
            throw new IllegalArgumentException("Grades number must be between 0 and 100.");
        }

        this.midterm = midterm;
        this.project = project;
        this.finalExam = finalExam;

    }

    private boolean isInvalidGrade(int gradeNumber) {
        return gradeNumber < 0 || gradeNumber > 100;
    }

    @Override
    public String toString() {
        return String.format("Midterm Exam: %d, Project: %d, Final Exam: %d", this.midterm, this.project,
                this.finalExam);
    }
}

public class Course {
    private final CourseID id;
    private final CourseName name;
    private final LectureSessionInfo lectureInfo;
    private final PracticeSessionInfo practiceInfo;

      public Course(CourseID id, CourseName name, LectureSessionInfo lectureInfo, PracticeSessionInfo practiceInfo) {
        this.id = id;
        this.name = name;
        this.lectureInfo = lectureInfo;
        this.practiceInfo = practiceInfo;
    }

    public String getCourseName() {
        return name.getValue();
    }

    public double getTotalHours() {
        return lectureInfo.getTotalHours() + practiceInfo.getTotalHours();
    }

    public String getCourseID() {
        return id.getValue();
    }

    
}
