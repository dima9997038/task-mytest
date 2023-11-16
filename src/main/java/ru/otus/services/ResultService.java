package ru.otus.services;

import ru.otus.models.Result;

import java.util.List;

public interface ResultService {
    List<Result> getResultOfStudent(Integer studentId);
    Integer result(Integer studentId);
}
