import java.util.List;
import java.util.Map;

public class VotingService
{
    private String question;
    private int[] counts;
    private Map<String,List<String>> stuAnsMap;

    public VotingService(String question, Map<String,
            List<String>> stuAnsMap)
    {
        this.question = question;
        this.stuAnsMap = stuAnsMap;
    }
    public void collectSubmissions(List<String> ansChoice)
    {
        counts = new int[ansChoice.size() + 1];
        for (Map.Entry<String, List<String>> entry : stuAnsMap.entrySet())
        {
            for(String collect : entry.getValue())
            {
                if (collect == "no answer")
                {
                    counts[ansChoice.size()]++;
                    continue;
                }
                for(int i = 0; i < ansChoice.size(); i++)
                {
                    if (collect == ansChoice.get(i))
                    {
                        counts[i]++;
                    }
                }
            }
        }
    }
    public void dispCollected(boolean questionType, List<String> ansChoice)
    {
        if (questionType)
        {
            System.out.println("****************************");
            System.out.println("* " + question + " *");
            System.out.println("****************************");
            for (int i = 0; i < ansChoice.size(); i++)
            {
                System.out.println(ansChoice.get(i) + ": " + counts[i]);
            }
            System.out.println("No Submits: " + counts[ansChoice.size()]);
            System.out.println();
        }
        else
        {
            System.out.println("****************************");
            System.out.println("* " + question + " *");
            System.out.println("****************************");
            for (int i = 0; i < ansChoice.size(); i++)
            {
                System.out.println(ansChoice.get(i) + ": " + counts[i]);
            }
            System.out.println("No Submits: " + counts[ansChoice.size()]);
        }
    }
}