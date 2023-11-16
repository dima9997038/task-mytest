package ru.otus.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.otus.dtos.TestAnswerDto;
import ru.otus.models.Answer;
import ru.otus.models.Question;
import ru.otus.models.Result;
import ru.otus.models.Student;
import ru.otus.services.ResultService;
import ru.otus.services.impl.AnswerServiceImpl;
import ru.otus.services.impl.QuestionServiceImpl;
import ru.otus.services.impl.ResultServiceImpl;
import ru.otus.services.impl.StudentServiceImpl;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PassTestController {
    private final QuestionServiceImpl questionService;
    private final StudentServiceImpl studentService;
    private final AnswerServiceImpl answerService;
    private final ResultServiceImpl resultService;
    @GetMapping("/passTest/{studentId}")
    public String passTest(@PathVariable Integer studentId, Model model){
        Question question = questionService.nextQuestion(studentId);
        Student student = studentService.getById(studentId);
        if(question==null){
            model.addAttribute("student",student);
            Integer resultTest = resultService.result(studentId);
            model.addAttribute("resultTest",resultTest);
            return "result";
        }

        List<Answer> answers = answerService.answersOfQuestion(question.getId());
        model.addAttribute("question", question);
        model.addAttribute("student",student);
        model.addAttribute("answers",answers);
        return "test";
    }
    @PostMapping("/testAnswer")
    public String testAnswer(TestAnswerDto dto){
        answerService.setResult(dto);
        System.out.println();
        return "redirect:/passTest/"+dto.getStudentId();
    }
}
