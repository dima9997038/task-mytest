package ru.otus.repositories.impl;

import org.springframework.stereotype.Repository;
import org.supercsv.cellprocessor.ParseBool;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import ru.otus.models.Result;
import ru.otus.repositories.ResultRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ResultRepositoryImpl implements ResultRepository {
    static final String CSV_FILENAME = "src/main/resources/results.csv";

    public List<Result> findAll(){
        List<Result> results = new ArrayList<>();
        try (ICsvBeanReader beanReader = new CsvBeanReader(new FileReader(CSV_FILENAME), CsvPreference.STANDARD_PREFERENCE)) {
            final String[] headers = beanReader.getHeader(true);
            final CellProcessor[] processors = getProcessors();

            Result result;
            while ((result = beanReader.read(Result.class, headers, processors)) != null) {
                    results.add(result);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return results;
    }

    public List<Result> resultOfStudent(Integer studentId) {
        List<Result> results = new ArrayList<>();
        try (ICsvBeanReader beanReader = new CsvBeanReader(new FileReader(CSV_FILENAME), CsvPreference.STANDARD_PREFERENCE)) {
            final String[] headers = beanReader.getHeader(true);
            final CellProcessor[] processors = getProcessors();

            Result result;
            while ((result = beanReader.read(Result.class, headers, processors)) != null) {
                if (studentId == result.getStudentId()) {
                    results.add(result);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return results;
    }

    @Override
    public void save(Result result) {
        ICsvBeanWriter beanWriter = null;
        List<Result> results = findAll();
        results.add(result);
        try
        {
            beanWriter = new CsvBeanWriter(new FileWriter(CSV_FILENAME), CsvPreference.STANDARD_PREFERENCE);
            final String[] header = new String[] { "studentId", "questionId", "correct"};
            final CellProcessor[] processors = getProcessorsSave();
            beanWriter.writeHeader(header);
            for (Result c : results) {
                beanWriter.write(c, header, processors);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            try {
                beanWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static CellProcessor[] getProcessors() {
        return new CellProcessor[]{
                new NotNull(new ParseInt()),
                new NotNull(new ParseInt()),
                new NotNull(new ParseBool())
        };
    }
    private static CellProcessor[] getProcessorsSave() {
        return new CellProcessor[]{
                new NotNull(new ParseInt()),
                new NotNull(new ParseInt()),
                new NotNull()
        };
    }

}
