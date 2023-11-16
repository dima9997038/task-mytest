package ru.otus.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.models.Question;
import ru.otus.models.Result;
import ru.otus.repositories.impl.QuestionRepositoryImpl;
import ru.otus.repositories.impl.ResultRepositoryImpl;
import ru.otus.services.QuestionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepositoryImpl questionRepository;
    private final ResultRepositoryImpl resultRepository;

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question nextQuestion(Integer studentId) {
        List<Integer> ids = resultRepository.resultOfStudent(studentId).stream().map(Result::getQuestionId).toList();
        return getAll().stream().filter(question -> !ids.contains(question.getId())).findFirst().orElse(null);
    }
}
