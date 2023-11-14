package ru.otus.services.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import ru.otus.models.Answer;
import ru.otus.models.Question;
import ru.otus.models.Student;
import ru.otus.services.PassTestService;

import java.util.List;
import java.util.Scanner;

@Service
@ComponentScan(basePackages = "ru.otus")
public class PassTestServiceImpl implements PassTestService {

    private final QuestionServiceImpl questionService;
    private final AnswerServiceImpl answerService;

    public PassTestServiceImpl(QuestionServiceImpl questionService, AnswerServiceImpl answerService) {
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @Override
    public void startPassTest() {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello! Are you ready? Yes(Y/y) or No(N/n)?");
        int countCorrectAnswer = 0;
        if (in.nextLine().equalsIgnoreCase("Y")) {
            List<Question> questions = questionService.getAll();
            System.out.println("What is your name?");
            String name = in.nextLine();
            System.out.println("What is your last name?");
            String lastName = in.nextLine();
            Student student = new Student(name, lastName);
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
            }
            System.out.println("Result test  " + student + " -  count of correct answers is: " + countCorrectAnswer);
        } else {
            System.out.println("Good bye");
        }
    }
}
