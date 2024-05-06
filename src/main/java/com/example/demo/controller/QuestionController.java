package com.example.demo.controller;


import com.example.demo.dto.get.GetQuestionDto;
import com.example.demo.dto.get.GetSolutionDto;
import com.example.demo.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @PostMapping("/new")
    public void createQuestion(@RequestParam String question,@RequestParam List<String> answers,@RequestParam String correctAnswer ,@RequestParam List<String> categories) {
        questionService.saveQuestionDto(question, answers, correctAnswer, categories);
    }

    @GetMapping("/")
    public Set<GetQuestionDto> getAllQuestions() {
        return questionService.findAllDto();
    }

    @GetMapping("/solution/{questionId}")
    public GetSolutionDto getQuestionAndSolution(@PathVariable Long questionId) {
        return questionService.getQuestionAndSolutionsById(questionId);
    }



}
