package ru.otus.repositories;

import ru.otus.models.Question;

import java.io.IOException;
import java.util.List;

public interface QuestionRepository {
    List<Question> findAll();
}
