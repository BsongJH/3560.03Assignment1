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

        simulation("Question here1", false, numOfStudent, setSingAns1);
        simulation("Question here2", false, numOfStudent, setSingAns2);
        simulation("Question here3", false, numOfStudent, setSingAns3);

        simulation("Question here4", true, numOfStudent, setMultAns1);
        simulation("Question here5", true, numOfStudent, setMultAns2);
        simulation("Question here6", true, numOfStudent, setMultAns3);


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
            System.out.println("Collecting Resubmissions!");
            // Resubmission simulator
            for (int j = 0; j < numOfStudent; j += 4)
            {
                voteMulti.resubmission(stuArrList.get(j).getStudentID(),question1.checkSubmits(randAnsGen(questionType, ansChoice.size())));
            }
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
            System.out.println("Collecting Resubmissions!");
            // Resubmission simulator
            for (int j = 0; j < numOfStudent; j += 4)
            {
                voteSingle.resubmission(stuArrList.get(j).getStudentID(),question2.checkSubmits(randAnsGen(questionType, ansChoice.size())));
            }
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