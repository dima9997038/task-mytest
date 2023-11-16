package ru.otus.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.models.Student;
import ru.otus.repositories.impl.StudentRepositoryImpl;

import java.util.List;

@RunWith(SpringRunner.class)
public class StudentServiceImplTest {
    @Mock
    private StudentRepositoryImpl studentRepository;

    @Test
    public void getAll() {
        Mockito.when(studentRepository.findAll()).thenReturn(List.of(new Student(1,"Pol","Cook"),new Student(2,"Tom","Smith")));
        StudentServiceImpl studentService=new StudentServiceImpl(studentRepository);
        List<Student> students = studentService.getAll();
        Assert.assertEquals(2,students.size());
        Assert.assertEquals("Tom",students.get(1).getName());
    }

    @Test
    public void getById() {
        Mockito.when(studentRepository.findAll()).thenReturn(List.of(new Student(1,"Pol","Cook"),new Student(2,"Tom","Smith")));
        StudentServiceImpl studentService=new StudentServiceImpl(studentRepository);
        Student student = studentService.getById(1);
        Assert.assertEquals("Pol",student.getName());
    }
}