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
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String answerText;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false)
    private Question question;


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
        Answer answer = (Answer) o;
        return Objects.equals(id, answer.id) && Objects.equals(answerText, answer.answerText) && Objects.equals(createdOn, answer.createdOn) && Objects.equals(updatedOn, answer.updatedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, answerText, createdOn, updatedOn);
    }
}
