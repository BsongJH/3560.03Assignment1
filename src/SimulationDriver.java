import java.util.*;

public class SimulationDriver
{
    /*
    simulates the whole process
    1.create question type and configure the answers
    2.configure the question for iVote/votingService
    3.randomly generate students and their numbers and their answers
    4.submit their answers to votingservice
    5.call voting service for output to display.
     */
    public static void main(String[] args)
    {
        int numOfStudent = 25;
        simulationStart("Question here", true, numOfStudent);
        simulationStart("Question here", false, numOfStudent);

    }
    // question type true - multi
    //              false - single
    private static void simulationStart(String question, boolean questionType,
                                        int numOfStudent)
    {
        Map<String, List<String>> map = new HashMap<>();
        Student[] studentArray = new Student[numOfStudent];
        if (questionType)
        {
            Question question1 = new MultipleChoice();
            // Simulates answers being collected into the map with Student ID and Array of their answers
            for (int i = 0; i < numOfStudent; i++)
            {
                studentArray[i] = new Student();
                studentArray[i].setAnswers(question1.checkSubmits(randAnsGen(questionType)));
                map.put(studentArray[i].getStudentID(), studentArray[i].getAnswers());
            }
            VotingService voteMulti = new VotingService(question, map);
            voteMulti.collectSubmissions();
            voteMulti.dispQuestion();
            voteMulti.dispCollected(questionType);
        }
        else
        {
            Question question2 = new SingleChoice();
            for (int i = 0; i < numOfStudent; i++)
            {
                studentArray[i] = new Student();
                studentArray[i].setAnswers(question2.checkSubmits(randAnsGen(questionType)));
                map.put(studentArray[i].getStudentID(), studentArray[i].getAnswers());
            }
            VotingService voteSingle = new VotingService(question, map);
            voteSingle.collectSubmissions();
            voteSingle.dispQuestion();
            voteSingle.dispCollected(questionType);
        }
    }

    private static List<Integer> randAnsGen(boolean singOrMulti)
    {
        Random random = new Random();
        List<Integer> submissions = new ArrayList<>();
        if(singOrMulti)
        {
            for (int i = 0; i < random.nextInt(5); i++)
            {
                submissions.add(random.nextInt(5));
            }
        }
        else
        {
            submissions.add(random.nextInt(3));
        }
        return submissions;
    }
}