package com.example.CourseworkJavaCore.service.impl;
import com.example.CourseworkJavaCore.model.Question;
import com.example.CourseworkJavaCore.service.ValidationService;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {

    @Override
    public boolean validate(Question question) {
        return question != null
                && question.getQuestion() != null
                && question.getAnswer() != null
                && !question.getQuestion().isEmpty()
                && !question.getAnswer().isEmpty()
                && !question.getQuestion().equals(question.getAnswer());
    }
}
