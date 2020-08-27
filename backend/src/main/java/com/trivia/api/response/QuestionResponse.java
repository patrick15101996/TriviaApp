package com.trivia.api.response;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.trivia.api.model.Question;

@JsonInclude(Include.NON_NULL)
public class QuestionResponse {
    public List<Question> questions;

    public QuestionResponse(List<Question> questions) {
        this.questions = questions.stream().map(Question::new).collect(Collectors.toList());
    }
}
