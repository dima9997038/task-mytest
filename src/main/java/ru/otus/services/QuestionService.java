package ru.otus.services;

import ru.otus.models.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getAll();
    Question nextQuestion(Integer studentId);
}
