package com.example.demo.mapper;

import com.example.demo.dto.get.GetAnswerDto;
import com.example.demo.dto.get.GetQuestionDto;
import com.example.demo.dto.get.GetSolutionDto;
import com.example.demo.dto.post.NewQuestionDto;
import com.example.demo.entity.Answer;
import com.example.demo.entity.Question;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);


    @Mapping(source = "question.questionText", target = "question")
    @Mapping(source = "question.answers", target = "answers")
    NewQuestionDto questionToNewQuestionDto(Question question);

    @InheritInverseConfiguration
    Question newQuestionDtoToQuestion(NewQuestionDto newQuestionDto);

    @Mapping(source = "answers", target = "answerSet", qualifiedByName = "mapAnswersToGetAnswerDto")
    GetQuestionDto questionToGetQuestionDto(Question question);

    @Mapping(source = "answers", target = "answerSet", qualifiedByName = "mapAnswersToGetAnswerDto")
    GetSolutionDto questionToGetSolutionDto(Question question);

    @Mapping(source = "answerText", target = "answerText")
    GetAnswerDto answerToGetAnswerDto(Answer answer);

    @Named("mapAnswersToGetAnswerDto")
    default Set<GetAnswerDto> mapAnswersToGetAnswerDto(Set<Answer> answers) {
        return answers.stream()
                .map(this::answerToGetAnswerDto)
                .collect(Collectors.toSet());
    }

}
