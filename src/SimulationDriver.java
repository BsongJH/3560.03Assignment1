import java.util.*;

public class SimulationDriver
{
    public static void main(String[] args)
    {
        int numOfStudent = 25;
        /* Single and Multiple question can be chosen here,
        The lecturers are able to change the answer lists from here as well.
        Assuming that there are not only True or False, or A,B,C,D questions.
         */
        List<String> setSingAns = new ArrayList<>();
        setSingAns.add("True");
        setSingAns.add("False");


        List<String> setMultAns = new ArrayList<>();
        setMultAns.add("A");
        setMultAns.add("B");
        setMultAns.add("C");
        setMultAns.add("D");
        // Passing constant boolean value for questionType due to being a simulation.
        simulation("Question here", true, numOfStudent, setMultAns);
        simulation("Question here", false, numOfStudent, setSingAns);

    }

    private static void simulation(String question, boolean questionType,
                                        int numOfStudent, List<String> ansChoice)
    {
        Map<String, List<String>> map = new HashMap<>();
        ArrayList<Student> stuArrList = new ArrayList<>(numOfStudent);
        if (questionType)
        {
            Question question1 = new MultipleChoice(question, ansChoice);
            // Simulates answers being collected into the map with Student ID and Array of their answers
            for (int i = 0; i < numOfStudent; i++)
            {
                stuArrList.add(new Student(question1.checkSubmits(randAnsGen(questionType, ansChoice.size()))));
                map.put(stuArrList.get(i).getStudentID(), stuArrList.get(i).getAnswers());
            }
            VotingService voteMulti = new VotingService(question, map);
            voteMulti.collectSubmissions(ansChoice);
            voteMulti.dispCollected(questionType, ansChoice);
        }
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

        }
    }

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
            submissions.add(random.nextInt(numOfChoice + 1));
        }
        return submissions;
    }
}