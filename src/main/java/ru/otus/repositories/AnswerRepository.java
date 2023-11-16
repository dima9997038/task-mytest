package ru.otus.repositories;

import ru.otus.models.Answer;

import java.util.List;

public interface AnswerRepository {
    List<Answer> answersOfQuestion(Integer questionId);
}
