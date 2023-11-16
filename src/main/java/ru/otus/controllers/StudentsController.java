package ru.otus.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.models.Student;
import ru.otus.services.impl.StudentServiceImpl;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentsController {
    private final StudentServiceImpl studentService;
    @GetMapping("/")
    public String formRegistration(Model model) {
        model.addAttribute("student", new Student());
        return "registration";
    }
    @PostMapping("/registration")
    public String save(Student student, Model model) {
        studentService.registration(student);
        model.addAttribute("student", student);
        return "start";
    }
}
