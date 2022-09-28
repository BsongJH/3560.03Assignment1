import java.util.ArrayList;
import java.util.List;

public class Student
{
    private static int studentCount;
    private final String studentID;
    private List<String> answers;

    public Student()
    {
        studentCount++;
        this.studentID = "Student" + studentCount;
        this.answers = new ArrayList<>();
    }

    public String getStudentID()
    {
        return this.studentID;
    }

    public void setAnswers(List<String> newAnswers)
    {
        this.answers = newAnswers;
    }
    public List<String> getAnswers()
    {
        return this.answers;
    }
}
