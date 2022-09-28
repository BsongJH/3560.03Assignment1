import java.util.ArrayList;
import java.util.List;

public class SingleChoice implements Question
{
    @Override
    public String answerReturn(int submittedAnswer)
    {
        String shortAnswer;
        /*
        if (submittedAnswer < 1 && submittedAnswer > 2)
        {
            shortAnswer = "no answer";
            return shortAnswer;
        }
         */
        switch (submittedAnswer)
        {
            case 0 -> shortAnswer = "no answer";
            case 1 -> shortAnswer = "1. Right";
            case 2 -> shortAnswer = "2. Wrong";
            default -> throw new IllegalStateException("Invalid option occurred try again");
        }
        return shortAnswer;
    }
    public List<String> checkSubmits(List<Integer> submits)
    {
        List<String> letterAns = new ArrayList<>();
        for(int item : submits)
        {
            if(!letterAns.contains(answerReturn(item)))
            {
                letterAns.add(answerReturn(item));
            }
        }
        if(submits.isEmpty())
            letterAns.add("no answer");
        return letterAns;
    }
}
