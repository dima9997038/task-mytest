package ru.otus.repositories.impl;

import org.springframework.stereotype.Repository;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;
import ru.otus.models.Question;
import ru.otus.repositories.QuestionRepository;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {
    static final String CSV_FILENAME = "src/main/resources/questions.csv";

    @Override
    public List<Question> findAll() {
        List<Question> questions = new ArrayList<>();
        try (ICsvBeanReader beanReader = new CsvBeanReader(new FileReader(CSV_FILENAME), CsvPreference.STANDARD_PREFERENCE)) {
            final String[] headers = beanReader.getHeader(true);
            final CellProcessor[] processors = getProcessors();

            Question question;
            while ((question = beanReader.read(Question.class, headers, processors)) != null) {
                questions.add(question);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return questions;
    }

    private static CellProcessor[] getProcessors() {
        return new CellProcessor[]{
                new NotNull(new ParseInt()),
                new NotNull()
        };
    }
}
