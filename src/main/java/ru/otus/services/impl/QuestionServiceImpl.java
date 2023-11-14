package ru.otus.services.impl;

import ru.otus.models.Question;
import ru.otus.repositories.QuestionRepository;
import ru.otus.services.QuestionService;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }
}
