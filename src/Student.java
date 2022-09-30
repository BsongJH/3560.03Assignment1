import java.util.List;
/*
 * Student has its own String of Student ID and number combined the numbers
 * are counted by the static field. Each student has a List of answers that they
 * can submit and resubmit
 */
public class Student
{
    private static int studentCount;
    private final String studentID;
    private List<String> answers;

    public Student(List<String> answers)
    {
        studentCount++;
        this.studentID = "Student" + studentCount;
        this.answers = answers;
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
