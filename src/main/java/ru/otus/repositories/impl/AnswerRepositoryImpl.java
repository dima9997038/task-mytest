package ru.otus.repositories.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import ru.otus.models.Answer;
import ru.otus.repositories.AnswerRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Repository
@PropertySource("classpath:application.properties")
public class AnswerRepositoryImpl implements AnswerRepository {
    private final String fileName;

    public AnswerRepositoryImpl(@Value("${answer.filename}") String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Answer> findAllByQuestionId(int questionId) {
        List<Answer> result = new ArrayList<>();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStreamReader streamReader = new InputStreamReader(classloader.getResourceAsStream(fileName), StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            for (String line; (line = reader.readLine()) != null; ) {
                String[] split = line.split(",");
                if (Integer.parseInt(split[0]) == questionId) {
                    result.add(new Answer(Integer.parseInt(split[0]), split[1], Boolean.parseBoolean(split[2])));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
