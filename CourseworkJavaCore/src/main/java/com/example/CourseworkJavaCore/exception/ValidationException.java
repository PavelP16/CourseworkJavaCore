package com.example.CourseworkJavaCore.exception;



public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super("Ошибка валидации!");
    }
}