package ru.otus.services;

import ru.otus.dtos.TestAnswerDto;
import ru.otus.models.Answer;

import java.util.List;

public interface AnswerService {
    List<Answer> answersOfQuestion(Integer questionId);

    void setResult(TestAnswerDto dto);
}
