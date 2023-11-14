package model;

public class Answer {
    private int questionId;
    private String text;
    private boolean correctAnswer;

    public Answer(int questionId, String text, boolean correctAnswer) {
        this.questionId = questionId;
        this.text = text;
        this.correctAnswer = correctAnswer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
