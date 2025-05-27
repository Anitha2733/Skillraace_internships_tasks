// Quiz.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions;
    private int score;
    private Scanner scanner;

    public Quiz() {
        questions = new ArrayList<>();
        scanner = new Scanner(System.in);
        
        // Initialize questions (you can add more questions here)
        questions.add(new Question("What is 6 + 6?", new String[]{"2", "3", "12", "5"}, 2));
        questions.add(new Question("What is the capital of India?", new String[]{"London", "Paris", "Delhi", "Madrid"}, 2));
        // Add more questions as needed
    }

    public void displayQuestions() {
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("Question " + (i + 1) + ": " + questions.get(i).getQuestion());
            String[] options = questions.get(i).getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ": " + options[j]);
            }
            System.out.print("Enter your answer (1-" + options.length + "): ");
            int answer = scanner.nextInt();
            selectAnswer(i, answer - 1); // Adjust index (answer - 1) for zero-based index
        }
    }

    public void selectAnswer(int questionIndex, int selectedOption) {
        Question question = questions.get(questionIndex);
        if (selectedOption >= 0 && selectedOption < question.getOptions().length) {
            if (selectedOption == question.getCorrectAnswer()) {
                score++;
            }
        }
    }

    public int getScore() {
        return score;
    }

    public void closeQuiz() {
        scanner.close();
    }
}



