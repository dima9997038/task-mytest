package ru.otus.repositories;

import ru.otus.models.Result;

import java.util.List;

public interface ResultRepository {
    List<Result> resultOfStudent(Integer studentId);

    void save(Result result);
}
