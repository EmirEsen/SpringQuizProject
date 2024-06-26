package com.example.demo.mapper;

import com.example.demo.dto.get.GetAnswerDto;
import com.example.demo.dto.get.GetQuestionDto;
import com.example.demo.dto.get.GetSolutionDto;
import com.example.demo.dto.post.NewQuestionDto;
import com.example.demo.entity.Answer;
import com.example.demo.entity.Category;
import com.example.demo.entity.Question;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T18:22:31+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public NewQuestionDto questionToNewQuestionDto(Question question) {
        if ( question == null ) {
            return null;
        }

        NewQuestionDto.NewQuestionDtoBuilder newQuestionDto = NewQuestionDto.builder();

        newQuestionDto.question( question.getQuestionText() );
        Set<Answer> set = question.getAnswers();
        if ( set != null ) {
            newQuestionDto.answers( new LinkedHashSet<Answer>( set ) );
        }
        newQuestionDto.correctAnswer( question.getCorrectAnswer() );
        Set<Category> set1 = question.getCategories();
        if ( set1 != null ) {
            newQuestionDto.categories( new LinkedHashSet<Category>( set1 ) );
        }

        return newQuestionDto.build();
    }

    @Override
    public Question newQuestionDtoToQuestion(NewQuestionDto newQuestionDto) {
        if ( newQuestionDto == null ) {
            return null;
        }

        Question.QuestionBuilder question = Question.builder();

        question.questionText( newQuestionDto.question() );
        Set<Answer> set = newQuestionDto.answers();
        if ( set != null ) {
            question.answers( new LinkedHashSet<Answer>( set ) );
        }
        question.correctAnswer( newQuestionDto.correctAnswer() );
        Set<Category> set1 = newQuestionDto.categories();
        if ( set1 != null ) {
            question.categories( new LinkedHashSet<Category>( set1 ) );
        }

        return question.build();
    }

    @Override
    public GetQuestionDto questionToGetQuestionDto(Question question) {
        if ( question == null ) {
            return null;
        }

        Set<GetAnswerDto> answerSet = null;
        String questionText = null;

        answerSet = mapAnswersToGetAnswerDto( question.getAnswers() );
        questionText = question.getQuestionText();

        GetQuestionDto getQuestionDto = new GetQuestionDto( questionText, answerSet );

        return getQuestionDto;
    }

    @Override
    public GetSolutionDto questionToGetSolutionDto(Question question) {
        if ( question == null ) {
            return null;
        }

        Set<GetAnswerDto> answerSet = null;
        String questionText = null;
        String correctAnswer = null;

        answerSet = mapAnswersToGetAnswerDto( question.getAnswers() );
        questionText = question.getQuestionText();
        correctAnswer = question.getCorrectAnswer();

        GetSolutionDto getSolutionDto = new GetSolutionDto( questionText, answerSet, correctAnswer );

        return getSolutionDto;
    }

    @Override
    public GetAnswerDto answerToGetAnswerDto(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        String answerText = null;

        answerText = answer.getAnswerText();

        GetAnswerDto getAnswerDto = new GetAnswerDto( answerText );

        return getAnswerDto;
    }
}
