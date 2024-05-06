package com.example.demo.dto.get;

import java.util.Set;

public record GetQuestionDto(String questionText, Set<GetAnswerDto> answerSet) {

}
