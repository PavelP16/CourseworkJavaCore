package com.example.CourseworkJavaCore.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@AllArgsConstructor
@RequestMapping("/exam")
@Tag(name = "API по работе с вопросами на экзамен",
        description = "Получение вопросов с ответами в случайном порядке")
public class ExamController {

    private final ExaminerService examinerService;

    @GetMapping("/{amount}")
    @Operation(
            summary = "Получение списка вопросов с ответами",
            description = "Нужно написать число Вопросов с ответами, которое хотите получить"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Список вопросов с ответами был получен"
    )
    public ResponseEntity<Collection<Question>> getQuestions(@PathVariable int amount) throws QuestionLimitException {

        Collection<Question> amountQuestions = examinerService.getQuestions(amount);
        return ResponseEntity.ok(amountQuestions);
    }
}