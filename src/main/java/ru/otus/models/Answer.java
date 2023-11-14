package ru.otus.models;

public class Answer {
    private final int questionId;
    private final String text;
    private final boolean correctAnswer;

    public Answer(int questionId, String text, boolean correctAnswer) {
        this.questionId = questionId;
        this.text = text;
        this.correctAnswer = correctAnswer;
    }

    public String getText() {
        return text;
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

}
