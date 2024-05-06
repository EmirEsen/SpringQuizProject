package com.example.demo.dto.post;

import com.example.demo.entity.Answer;
import com.example.demo.entity.Category;
import lombok.Builder;

import java.util.Set;

@Builder
public record NewQuestionDto(String question, Set<Answer> answers, String correctAnswer ,Set<Category> categories) {


}
