package com.example.CourseworkJavaCore.controller;

import com.example.CourseworkJavaCore.service.QuestionService;
import org.junit.jupiter.api.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/exam/java")
@Tag(name = "API по работе с вопросами на экзамен по Java",
        description = "CRUD-операции для вопросов по экзамену")
public class JavaQuestionController {

    private final QuestionService javaQuestionService;

    @PostMapping
    @Operation(
            summary = "Создание вопроса с ответом",
            description = "Нужно написать вопрос и ответ"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Вопрос с ответом был добавлен"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Вопрос с ответом не добавлен"
    )
    public ResponseEntity<Question> addQuestion(@RequestParam(required = false) String question,
                                                @RequestParam(required = false) String answer) {

        try {
            return ResponseEntity.ok(javaQuestionService.add(question, answer));
        } catch (ValidationException e) {
            e.getStackTrace();
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping
    @Operation(
            summary = "Показать все вопросы с ответами"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Вопрос с ответом были найдены"
    )
    public ResponseEntity<Collection<Question>> getAllQuestions() {

        return ResponseEntity.ok(javaQuestionService.getAll());
    }

    @DeleteMapping()
    @Operation(
            summary = "Удаление вопроса с ответом",
            description = "Нужно написать вопрос и ответ, который хотите удалить"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Вопрос с ответом были удалены"
    )
    public ResponseEntity<Void> deleteQuestion(@RequestParam(required = false) String question,
                                               @RequestParam(required = false) String answer) {

        try {
            javaQuestionService.remove(new Question(question, answer));
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            e.getStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}