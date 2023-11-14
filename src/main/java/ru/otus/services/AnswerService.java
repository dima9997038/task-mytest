package ru.otus.services;

import ru.otus.models.Answer;

import java.util.List;

public interface AnswerService {
    List<Answer> getAllAnswerByQuestionId(int questionId);
}
