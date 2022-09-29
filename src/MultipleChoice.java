import java.util.ArrayList;
import java.util.List;

public class MultipleChoice extends Question
{
    public MultipleChoice(String newQuestion, List<String> newAnsChoice)
    {
        super(newQuestion, newAnsChoice);
    }
    public List<String> checkSubmits(List<Integer> intSubmits)
    {
        List<String> stringAns = new ArrayList<>();
        for(int item : intSubmits)
        {
            if(!stringAns.contains(ansChoice.get(item)))
                stringAns.add(ansChoice.get(item));
            else
                stringAns.add("no answer");
        }
        if(intSubmits.isEmpty())
            stringAns.add("no answer");
        return stringAns;
    }
}
