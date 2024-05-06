package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String questionText;
    // [Cascade.Type.PERSIST]: Answers will be persisted while saving a Question
    // [orphanRemoval = true]: Answers will be deleted if a related Question deleted.
    @OneToMany(mappedBy = "question",cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private Set<Answer> answers;
    private String correctAnswer;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "question_category", joinColumns = {
            @JoinColumn(name = "question_id")},
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdOn;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updatedOn;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(id, question.id) && Objects.equals(questionText, question.questionText) && Objects.equals(categories, question.categories) && Objects.equals(createdOn, question.createdOn) && Objects.equals(updatedOn, question.updatedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, questionText, categories, createdOn, updatedOn);
    }
}
