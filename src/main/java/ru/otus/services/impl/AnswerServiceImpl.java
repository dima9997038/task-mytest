package ru.otus.services.impl;

import ru.otus.models.Answer;
import ru.otus.repositories.AnswerRepository;
import ru.otus.services.AnswerService;

import java.util.List;

public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public List<Answer> getAllAnswerByQuestionId(int questionId) {
        return answerRepository.findAllByQuestionId(questionId);
    }
}
