package com.example.demo.mapper;

import com.example.demo.dto.post.NewAnswerDto;
import com.example.demo.entity.Answer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T18:22:31+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class AnswerMapperImpl implements AnswerMapper {

    @Override
    public NewAnswerDto answerToNewAnswerDto(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        NewAnswerDto.NewAnswerDtoBuilder newAnswerDto = NewAnswerDto.builder();

        newAnswerDto.answerText( answer.getAnswerText() );

        return newAnswerDto.build();
    }

    @Override
    public Answer newAnswerDtoToAnswer(NewAnswerDto newAnswerDto) {
        if ( newAnswerDto == null ) {
            return null;
        }

        Answer.AnswerBuilder answer = Answer.builder();

        answer.answerText( newAnswerDto.answerText() );

        return answer.build();
    }
}
