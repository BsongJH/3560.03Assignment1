import java.util.List;

/*
 * Abstract Class for the Questions being Single or Multiple
 * question stores Question, and ansChoice stores The list of possible
 * answers that user have chosen.
 */
public abstract class Question
{
    protected String question;
    protected List<String> ansChoice;

    public Question(String newQuestion, List<String> newAnsChoice)
    {
        this.question = newQuestion;
        this.ansChoice = newAnsChoice;
    }
    /* Turns Integer answers into String according to the ansChoice */
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
