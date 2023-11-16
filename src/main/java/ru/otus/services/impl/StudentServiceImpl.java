package ru.otus.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.models.Student;
import ru.otus.repositories.impl.StudentRepositoryImpl;
import ru.otus.services.StudentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepositoryImpl studentRepository;

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student registration(Student student) {
        return studentRepository.registration(student);
    }

    @Override
    public Student getById(Integer id) {
        return getAll().stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

}
