import java.util.ArrayList;
import java.util.List;

public class MultipleChoice implements Question
{
    @Override
    public String answerReturn(int submittedAnswer)
    {
        String letters;
        if (submittedAnswer < 1 || submittedAnswer > 4)
        {
            letters = "no answer";
            return letters;
        }
        switch (submittedAnswer)
        {
            case 1 -> letters = "A";
            case 2 -> letters = "B";
            case 3 -> letters = "C";
            case 4 -> letters = "D";
            default -> throw new IllegalStateException("Invalid option occurred try again");
        }
        return letters;
    }
    public List<String> checkSubmits(List<Integer> submits)
    {
        List<String> letterAns = new ArrayList<>();
        for(int item : submits)
        {
            if(!letterAns.contains(answerReturn(item)))
                letterAns.add(answerReturn(item));
        }
        if(submits.isEmpty())
            letterAns.add("no answer");
        return letterAns;
    }
}
