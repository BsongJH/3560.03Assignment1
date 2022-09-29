import java.util.List;

public abstract class Question
{
    protected String question;
    protected List<String> ansChoice;

    public Question(String newQuestion, List<String> newAnsChoice)
    {
        this.question = newQuestion;
        this.ansChoice = newAnsChoice;
    }
    public abstract List<String> checkSubmits(List<Integer> submits);
    public List<String> getAnsChoice()
    {
        return ansChoice;
    }
    public String getQuestion()
    {
        return question;
    }
}
