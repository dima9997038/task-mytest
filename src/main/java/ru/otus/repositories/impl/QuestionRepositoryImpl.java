package ru.otus.repositories.impl;

import ru.otus.models.Question;
import ru.otus.repositories.QuestionRepository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class QuestionRepositoryImpl implements QuestionRepository {
    private final String fileName;

    public QuestionRepositoryImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Question> findAll() {
        List<Question> result=new ArrayList<>();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStreamReader streamReader = new InputStreamReader(classloader.getResourceAsStream(fileName), StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            for (String line; (line = reader.readLine()) != null; ) {
                String[] split = line.split(",");
                result.add(new Question(Integer.parseInt(split[0]),split[1])  );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
