package com.example.CourseworkJavaCore.service;


import com.example.CourseworkJavaCore.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}