package ru.otus;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.models.Answer;
import ru.otus.models.Question;
import ru.otus.services.AnswerService;
import ru.otus.services.QuestionService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        QuestionService questionService = context.getBean(QuestionService.class);
        AnswerService answerService = context.getBean(AnswerService.class);
        List<Question> questions = questionService.getAll();
        Scanner in = new Scanner(System.in);
        System.out.println("Hello! Are you ready? Yes(Y/y) or No(N/n)?");
        int countCorrectAnswer = 0;
        if (in.nextLine().equalsIgnoreCase("Y")) {
            for (Question question : questions) {
                System.out.println(question);
                List<Answer> answers = answerService.getAllAnswerByQuestionId(question.getId());
                System.out.println("Select the correct answer number");
                int correctIndex = Integer.MIN_VALUE;
                for (int i = 0; i < answers.size(); i++) {
                    System.out.println(i + ". " + answers.get(i).getText());
                    if (answers.get(i).isCorrectAnswer()) {
                        correctIndex = i;
                    }
                }
                String select = in.nextLine();
                if (select.equals(String.valueOf(correctIndex))) {
                    countCorrectAnswer++;
                }
                System.out.println();
            }
            System.out.println("Count of correct answers is: " + countCorrectAnswer);
        } else {
            System.out.println("Good bye");
        }
    }
}