import java.util.List;
import java.util.Map;

public class VotingService
{
    private final String question;
    private int[] counts = {0,0,0,0,0};
    private Map<String,List<String>> stuAnsMap;

    // False -  Single - choice
    public VotingService(String question, Map<String,
            List<String>> stuAnsMap)
    {
        this.question = question;
        // True - Multiple - choice
        this.stuAnsMap = stuAnsMap;
    }
    public void collectSubmissions()
    {
        for (Map.Entry<String, List<String>> entry : stuAnsMap.entrySet())
        {
            for(String collect : entry.getValue())
            {
                switch (collect)
                {
                    case "A" -> this.counts[0]++;
                    case "B" -> this.counts[1]++;
                    case "C" -> this.counts[2]++;
                    case "D" -> this.counts[3]++;
                    case "1. Right" -> this.counts[0]++;
                    case "2. Wrong" -> this.counts[1]++;
                    case "no answer" -> this.counts[4]++;
                }
            }
        }
    }
    public void dispQuestion()
    {
        System.out.println(this.question);
    }
    public void dispCollected(boolean questionType)
    {
        if (questionType)
        {
            System.out.println("A: " + counts[0]);
            System.out.println("B: " + counts[1]);
            System.out.println("C: " + counts[2]);
            System.out.println("D: " + counts[3]);
            System.out.println("No Submits: " + counts[4]);
        }
        else
        {
            System.out.println("A: " + counts[0]);
            System.out.println("B: " + counts[1]);
            System.out.println("No Submits: " + counts[4]);
        }
    }
}
