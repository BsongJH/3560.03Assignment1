import java.util.ArrayList;
import java.util.List;

public class SingleChoice extends Question
{
    public SingleChoice(String newQuestion, List<String> newAnsChoice)
    {
        super(newQuestion,newAnsChoice);
    }

    /*
    * Returns integer List into String List and if it's empty its considered as no answer.
    * Integer List size will be 1 greater than the answer choice to simulate the no submission
    */
    public List<String> checkSubmits(List<Integer> newSubmits)
    {
        List<String> letterAns = new ArrayList<>();
        if (newSubmits.get(0) == ansChoice.size() || newSubmits.isEmpty())
        {
            letterAns.add("no answer");
            return letterAns;
        }
        for(int item : newSubmits)
        {
            if(!letterAns.contains(ansChoice.get(item)))
            {
                letterAns.add(ansChoice.get(item));
            }
        }
        return letterAns;
    }
}
