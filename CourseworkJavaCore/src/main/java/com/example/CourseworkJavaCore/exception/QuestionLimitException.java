package com.example.CourseworkJavaCore.exception;


public class QuestionLimitException extends RuntimeException{

    public QuestionLimitException(String message) {
        super("Заданное число вопросов превысило количество сохраненных");
    }
}