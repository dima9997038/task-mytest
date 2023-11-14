package ru.otus.models;

public class Question {
    private final int id;
    private final String text;

    public Question(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return " № " + id + " Question:  " + text;
    }
}
