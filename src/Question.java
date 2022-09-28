import java.util.List;

public interface Question
{
    String answerReturn(int submittedAnswer);
    List<String> checkSubmits(List<Integer> submits);
}
