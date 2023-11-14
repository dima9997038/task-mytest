package ru.otus.repositories.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import ru.otus.models.Question;
import ru.otus.repositories.QuestionRepository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Repository
@PropertySource("classpath:application.properties")
public class QuestionRepositoryImpl implements QuestionRepository {
    private final String fileName;

    public QuestionRepositoryImpl(@Value("${question.filename}") String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Question> findAll() {
        List<Question> result = new ArrayList<>();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStreamReader streamReader = new InputStreamReader(classloader.getResourceAsStream(fileName), StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            for (String line; (line = reader.readLine()) != null; ) {
                String[] split = line.split(",");
                result.add(new Question(Integer.parseInt(split[0]), split[1]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
