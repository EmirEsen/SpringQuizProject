package com.example.demo.mapper;

import com.example.demo.dto.post.NewAnswerDto;
import com.example.demo.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    NewAnswerDto answerToNewAnswerDto(Answer answer);


    Answer newAnswerDtoToAnswer(NewAnswerDto newAnswerDto);


}
