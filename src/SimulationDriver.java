/*
Brian Song
BroncoID:015118155
CS3560.03 Tu/Th 10:00am - 11:15am
 */
import java.util.*;

public class SimulationDriver
{
    public static void main(String[] args)
    {
        int numOfStudent = 25;

        List<String> setSingAns1 = new ArrayList<>();
        setSingAns1.add("True");
        setSingAns1.add("False");

        List<String> setSingAns2 = new ArrayList<>();
        setSingAns2.add("A");
        setSingAns2.add("B");
        setSingAns2.add("C");

        List<String> setSingAns3 = new ArrayList<>();
        setSingAns3.add("Yes");
        setSingAns3.add("No");
        setSingAns3.add("Maybe");
        setSingAns3.add("I Don't Know");


        List<String> setMultAns1 = new ArrayList<>();
        setMultAns1.add("A");
        setMultAns1.add("B");
        setMultAns1.add("C");
        setMultAns1.add("D");

        List<String> setMultAns2 = new ArrayList<>();
        setMultAns2.add("A");
        setMultAns2.add("B");
        setMultAns2.add("C");
        setMultAns2.add("D");
        setMultAns2.add("E");
        setMultAns2.add("F");
        setMultAns2.add("G");

        List<String> setMultAns3 = new ArrayList<>();
        setMultAns3.add("Maybe this");
        setMultAns3.add("Or this");
        setMultAns3.add("Or that");
        setMultAns3.add("this?");

        // Passing constant boolean value for questionType due to being a simulation.
        simulation("Is the assignment due on Thursday?", false, numOfStudent, setSingAns1);
        simulation("Choose one from these three", false, 35, setSingAns2);
        simulation("Do you understand this assignment?", false, 45, setSingAns3);

        simulation("Question with 4 choices", true, numOfStudent, setMultAns1);
        simulation("Question with 7 choices", true, 50, setMultAns2);
        simulation("Which one do you want to choose?", true, 60, setMultAns3);


    }

    private static void simulation(String question, boolean questionType,
                                        int numOfStudent, List<String> ansChoice)
    {
        // For multiple-choice Questions.
        Map<String, List<String>> map = new HashMap<>();
        ArrayList<Student> stuArrList = new ArrayList<>(numOfStudent);
        if (questionType)
        {
            Question question1 = new MultipleChoice(question, ansChoice);
            // New Students are created and assigned with randomly generated integers that are being turned
            // into String answers that user have chosen.
            for (int i = 0; i < numOfStudent; i++)
            {
                stuArrList.add(new Student(question1.checkSubmits(randAnsGen(questionType, ansChoice.size()))));
                map.put(stuArrList.get(i).getStudentID(), stuArrList.get(i).getAnswers());
            }

            VotingService voteMulti = new VotingService(question, map);
            voteMulti.collectSubmissions(ansChoice);
            voteMulti.dispCollected(questionType, ansChoice);

            System.out.println("Collecting Resubmissions!");

            // Resubmission simulator
            for (int j = 0; j < numOfStudent; j += 4)
            {
                // gets random student's key and submits new value that has been gone through random generator
                // and that has been turned into a String answer.
                voteMulti.resubmission(stuArrList.get(j).getStudentID(),question1.checkSubmits(randAnsGen(questionType
                        ,ansChoice.size())));
            }
            voteMulti.collectSubmissions(ansChoice);
            voteMulti.dispCollected(questionType, ansChoice);
        }
        // For Single-Choice Questions
        else
        {
            Question question2 = new SingleChoice(question, ansChoice);
            for (int i = 0; i < numOfStudent; i++)
            {
                stuArrList.add(new Student(question2.checkSubmits(randAnsGen(questionType, ansChoice.size()))));
                map.put(stuArrList.get(i).getStudentID(), stuArrList.get(i).getAnswers());
            }
            VotingService voteSingle = new VotingService(question, map);
            voteSingle.collectSubmissions(ansChoice);
            voteSingle.dispCollected(questionType, ansChoice);

            System.out.println("Collecting Resubmissions!");

            // Resubmission simulator
            for (int j = 0; j < numOfStudent; j += 4)
            {
                voteSingle.resubmission(stuArrList.get(j).getStudentID(),question2.checkSubmits(randAnsGen(questionType
                        ,ansChoice.size())));
            }
            voteSingle.collectSubmissions(ansChoice);
            voteSingle.dispCollected(questionType, ansChoice);
        }
    }
    /* Generates random list of integers bound to the size of the User answer choice + 1 */
    private static List<Integer> randAnsGen(boolean singOrMulti, int numOfChoice)
    {
        Random random = new Random();
        List<Integer> submissions = new ArrayList<>();
        if(singOrMulti)
        {
            for (int i = 0; i < random.nextInt(numOfChoice); i++)
            {
                submissions.add(random.nextInt(numOfChoice));
            }
        }
        else
        {
            // bound + 1 to have one more space for non answers.
            submissions.add(random.nextInt(numOfChoice + 1));
        }
        return submissions;
    }
}