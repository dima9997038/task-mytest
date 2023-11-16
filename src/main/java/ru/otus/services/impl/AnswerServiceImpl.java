package ru.otus.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.dtos.TestAnswerDto;
import ru.otus.models.Answer;
import ru.otus.models.Result;
import ru.otus.repositories.impl.AnswerRepositoryImpl;
import ru.otus.repositories.impl.ResultRepositoryImpl;
import ru.otus.services.AnswerService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepositoryImpl answerRepository;
    private final ResultRepositoryImpl resultRepository;
    @Override
    public List<Answer> answersOfQuestion(Integer questionId) {
        return answerRepository.answersOfQuestion(questionId);
    }

    @Override
    public void setResult(TestAnswerDto dto) {
        Result result=new Result();
        result.setCorrect(false);
        List<Answer> answers = answerRepository.answersOfQuestion(dto.getQuestionId());
        Answer answer = answers.stream().filter(a -> a.getText().equals(dto.getAnswer())).findFirst().orElse(null);
        if(answer!=null){
            if (answer.isCorrectAnswer()){
                result.setCorrect(true);
            }
        }
        result.setQuestionId(dto.getQuestionId());
        result.setStudentId(dto.getStudentId());
        resultRepository.save(result);
    }
}
