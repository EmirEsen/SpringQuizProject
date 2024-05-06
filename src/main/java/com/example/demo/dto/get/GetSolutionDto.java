package com.example.demo.dto.get;

import java.util.Set;

public record GetSolutionDto(String questionText, Set<GetAnswerDto> answerSet, String correctAnswer ) {
}
