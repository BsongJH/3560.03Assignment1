import java.util.List;
import java.util.Map;
import java.util.Objects;
/*
 * VotingService stores the map of the key: studentID and value: List of String answers
 * into stuAnsMap. Question stores the user input question,
 * counts array collects the number of answers that has been submitted to display the result
 */
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

    /* This method iterate through the map and count up the submission for display purposes */
    public void collectSubmissions(List<String> ansChoice)
    {
        counts = new int[ansChoice.size() + 1];
        for (Map.Entry<String, List<String>> entry : stuAnsMap.entrySet()) // Iterating Through Keys.
        {
            for(String collect : entry.getValue()) // Iterating Through The Values.
            {
                if (Objects.equals(collect, "no answer"))
                {
                    counts[ansChoice.size()]++; // Increases the very last variable for non submission.
                    continue;
                }
                for(int i = 0; i < ansChoice.size(); i++) // Iterating through the answers
                {
                    if (Objects.equals(collect, ansChoice.get(i)))
                    {
                        counts[i]++;  // Increases the submissions according to the size of the user's answer choices
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
            System.out.println();
        }
    }
    public void resubmission(String stuNum, List<String> newSubmissions)
    {
        stuAnsMap.replace(stuNum, newSubmissions);
    }
}