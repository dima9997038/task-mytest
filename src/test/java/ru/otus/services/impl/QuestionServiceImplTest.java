package ru.otus.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.models.Question;
import ru.otus.models.Student;
import ru.otus.repositories.impl.QuestionRepositoryImpl;
import ru.otus.repositories.impl.ResultRepositoryImpl;

import java.util.List;

@RunWith(SpringRunner.class)
public class QuestionServiceImplTest {
    @Mock
    private QuestionRepositoryImpl questionRepository;
    @Mock
    private ResultRepositoryImpl resultRepository;

    @Test
    public void getAll() {
        Mockito.when(questionRepository.findAll()).thenReturn(List.of(new Question(1,"Qst1"),new Question(2,"Qst2")));
        QuestionServiceImpl questionService=new QuestionServiceImpl(questionRepository,resultRepository);
        List<Question> questions = questionService.getAll();
        Assert.assertEquals(2,questions.size());
        Assert.assertEquals("Qst2",questions.get(1).getText());
    }
}