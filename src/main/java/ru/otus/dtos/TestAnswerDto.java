package ru.otus.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestAnswerDto {
    private String answer;
    private int questionId;
    private int studentId;

}
