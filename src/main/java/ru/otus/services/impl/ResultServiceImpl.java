package ru.otus.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.models.Result;
import ru.otus.repositories.ResultRepository;
import ru.otus.repositories.impl.ResultRepositoryImpl;
import ru.otus.services.ResultService;

import java.util.List;

@Service
@AllArgsConstructor
public class ResultServiceImpl implements ResultService {
    private final ResultRepositoryImpl resultRepository;


    @Override
    public List<Result> getResultOfStudent(Integer studentId) {
        return resultRepository.resultOfStudent(studentId);
    }

    @Override
    public Integer result(Integer studentId) {
        return (int) getResultOfStudent(studentId).stream().filter(result -> result.isCorrect()).count();
    }
}
