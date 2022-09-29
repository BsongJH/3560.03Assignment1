import java.util.ArrayList;
import java.util.List;

public class SingleChoice extends Question
{
    public SingleChoice(String newQuestion, List<String> newAnsChoice)
    {
        super(newQuestion,newAnsChoice);
    }
    public List<String> checkSubmits(List<Integer> submits)
    {
        List<String> letterAns = new ArrayList<>();
        if (submits.get(0) == 2 || submits.isEmpty())
        {
            letterAns.add("no answer");
            return letterAns;
        }
        for(int item : submits)
        {
            if(!letterAns.contains(ansChoice.get(item)))
            {
                letterAns.add(ansChoice.get(item));
            }
        }
        return letterAns;
    }
}
