package ru.otus.repositories.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.supercsv.cellprocessor.ParseBool;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;
import ru.otus.models.Answer;
import ru.otus.repositories.AnswerRepository;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AnswerRepositoryImpl implements AnswerRepository {
    @Value("${filename.answers}")
    private String CSV_FILENAME;

    @Override
    public List<Answer> answersOfQuestion(Integer questionId) {
        List<Answer> results = new ArrayList<>();
        try (ICsvBeanReader beanReader = new CsvBeanReader(new FileReader(CSV_FILENAME), CsvPreference.STANDARD_PREFERENCE)) {
            final String[] headers = beanReader.getHeader(true);
            final CellProcessor[] processors = getProcessors();

            Answer result;
            while ((result = beanReader.read(Answer.class, headers, processors)) != null) {
                if (questionId == result.getQuestionId()) {
                    results.add(result);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return results;
    }

    private static CellProcessor[] getProcessors() {
        return new CellProcessor[]{
                new NotNull(new ParseInt()),
                new NotNull(),
                new NotNull(new ParseBool())
        };
    }
}
