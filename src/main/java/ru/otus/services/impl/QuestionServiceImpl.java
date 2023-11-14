package ru.otus.services.impl;

import org.springframework.stereotype.Service;
import ru.otus.models.Question;
import ru.otus.repositories.impl.QuestionRepositoryImpl;
import ru.otus.services.QuestionService;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepositoryImpl questionRepository;

    public QuestionServiceImpl(QuestionRepositoryImpl questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }
}
