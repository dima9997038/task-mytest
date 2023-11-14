package ru.otus.services.impl;

import org.springframework.stereotype.Service;
import ru.otus.models.Answer;
import ru.otus.repositories.impl.AnswerRepositoryImpl;
import ru.otus.services.AnswerService;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepositoryImpl answerRepository;

    public AnswerServiceImpl(AnswerRepositoryImpl answerRepository) {
        this.answerRepository = answerRepository;
    }


    @Override
    public List<Answer> getAllAnswerByQuestionId(int questionId) {
        return answerRepository.findAllByQuestionId(questionId);
    }
}
