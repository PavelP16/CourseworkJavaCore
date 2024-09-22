package com.example.CourseworkJavaCore.service.impl;



import com.example.CourseworkJavaCore.exception.QuestionLimitException;
import com.example.CourseworkJavaCore.model.Question;
import com.example.CourseworkJavaCore.service.ExaminerService;
import com.example.CourseworkJavaCore.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionServiceImpl") QuestionService questionService) {
        this.javaQuestionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) throws QuestionLimitException {

        int size = javaQuestionService.getAll().size();
        if (size < amount) {
            throw new QuestionLimitException("Заданное число вопросов превысило количество сохраненных");
        }
        Set<Question> listQuestions = new HashSet<>();

        while (listQuestions.size() < amount) {
            listQuestions.add(javaQuestionService.getRandomQuestion());
        }
        return listQuestions;
    }
}