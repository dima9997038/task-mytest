package ru.otus.repositories.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import ru.otus.models.Student;
import ru.otus.repositories.StudentRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    @Value("${filename.students}")
    private String CSV_FILENAME;
    @Override
    public List<Student> findAll() {
        List<Student> students=new ArrayList<>();
        try(ICsvBeanReader beanReader = new CsvBeanReader(new FileReader(CSV_FILENAME), CsvPreference.STANDARD_PREFERENCE))
        {
            final String[] headers = beanReader.getHeader(true);
            final CellProcessor[] processors = getProcessors();

            Student student;
            while ((student = beanReader.read(Student.class, headers, processors)) != null) {
                students.add(student);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public Student registration(Student student) {
        ICsvBeanWriter beanWriter = null;
        List<Student> students = findAll();
        Integer maxId = students.stream().map(Student::getId).max(Integer::compareTo).orElse(0);
        student.setId(maxId+1);
        students.add(student);
        try
        {
            beanWriter = new CsvBeanWriter(new FileWriter(CSV_FILENAME), CsvPreference.STANDARD_PREFERENCE);
            final String[] header = new String[] { "id", "name", "surName"};

            final CellProcessor[] processors = getProcessors();
            beanWriter.writeHeader(header);
            for (Student c : students) {
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
        return student;
    }

    private static CellProcessor[] getProcessors() {


        return new CellProcessor[] {
                new NotNull(new ParseInt()),
                new NotNull(),
                new NotNull()


        };
    }
}
