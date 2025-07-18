// QuizApp.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp {
    private List<QuizQuestion> questions;
    private int currentQuestionIndex;
    private int score;
    private boolean answerSubmitted;

    public QuizApp(List<QuizQuestion> questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.score = 0;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        while (currentQuestionIndex < questions.size()) {
            QuizQuestion currentQuestion = questions.get(currentQuestionIndex);
            displayQuestion(currentQuestion);

            answerSubmitted = false;

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (!answerSubmitted) {
                        System.out.println("Time's up!");
                        moveToNextQuestion();
                    }
                }
            }, 15000); // 15 seconds timer

            int userAnswer = scanner.nextInt();
            timer.cancel();
            answerSubmitted = true;

            if (userAnswer == currentQuestion.getCorrectAnswer()) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect!");
            }

            moveToNextQuestion();
        }

        displayResults();
    }

    private void displayQuestion(QuizQuestion question) {
        System.out.println(question.getQuestion());
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print("Enter your answer (1-4): ");
    }

    private void moveToNextQuestion() {
        currentQuestionIndex++;
    }

    private void displayResults() {
        System.out.println("Quiz over!");
        System.out.println("Your score: " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
        List<QuizQuestion> questions = new ArrayList<>();
        questions.add(new QuizQuestion("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris", "Rome"}, 3));
        questions.add(new QuizQuestion("What is the smallest bone in human body?", new String[]{"Stapes", "Femur", "Tibia", "Radius"}, 1));
        questions.add(new QuizQuestion("Which country is known as Land of Rising Sun?", new String[]{"India", "US", "UK", "Japan"}, 4));
        questions.add(new QuizQuestion("Which is the longest river in the world?", new String[]{"Mississippi", "Yangtze", "Amazon", "Nile"}, 4));
      
        QuizApp quizApp = new QuizApp(questions);
        quizApp.startQuiz();
    }
}
