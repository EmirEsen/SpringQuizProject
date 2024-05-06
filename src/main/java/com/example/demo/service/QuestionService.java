package com.example.demo.service;

import com.example.demo.dto.get.CategoryDto;
import com.example.demo.dto.get.GetQuestionDto;
import com.example.demo.dto.get.GetSolutionDto;
import com.example.demo.dto.post.NewQuestionDto;
import com.example.demo.entity.Answer;
import com.example.demo.entity.Question;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.mapper.QuestionMapper;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class QuestionService extends ServiceManager<Question, Long> {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        super(questionRepository);
        this.questionRepository = questionRepository;
    }



    public void saveQuestionDto(String question, List<String> answers, String correctAnswer, List<String> categories) {
        NewQuestionDto newQuestionDto = null;

        Set<CategoryDto> categoryDtos = new HashSet<>();
        for (String categoryName : categories) {
            categoryDtos.add(CategoryDto.builder()
                    .name(categoryName)
                    .build());
        }

        newQuestionDto = NewQuestionDto.builder()
                .question(question)
                .correctAnswer(correctAnswer)
                .categories(categoryDtos.stream().map(CategoryMapper.INSTANCE::categoryDtoToCategory).collect(Collectors.toSet()))
                .build();

        Question questionToSave = QuestionMapper.INSTANCE.newQuestionDtoToQuestion(newQuestionDto);

        Set<Answer> answerObjs = new HashSet<>();
        for (String answer : answers) {
            answerObjs.add(Answer.builder()
                    .answerText(answer)
                    .question(questionToSave)
                    .build());
        }

        questionToSave.setAnswers(answerObjs);


        questionRepository.save(questionToSave);
    }

    public Set<GetQuestionDto> findAllDto() {
        return questionRepository.findAll().stream()
                .map(QuestionMapper.INSTANCE::questionToGetQuestionDto)
                .collect(Collectors.toSet());
    }

    public GetSolutionDto getQuestionAndSolutionsById(Long id) {
        Question question = questionRepository.findById(id).orElse(null);
        if(question != null) {
            return QuestionMapper.INSTANCE.questionToGetSolutionDto(question);
        }
        return null;
    }
}
