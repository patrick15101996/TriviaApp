package com.trivia.api.model;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionBuilder {

    private long id;
    @JsonProperty("question")
    private String content;
    @JsonProperty("incorrect_answers")
    private List<String> incorrectAnswers;
    @JsonProperty("correct_answer")
    private String correctAnswer;

    public QuestionBuilder(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public QuestionBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    public List<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public QuestionBuilder setIncorrectAnswers(List<String> incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
        return this;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public QuestionBuilder setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
        return this;
    }

    public Question build() {
        return new Question(id, content, incorrectAnswers, correctAnswer);
    }

    @Override
    public String toString() {
        return "{" +
               "\"id\"=" + id +
               ", \"content\"=\"" + content + '\"' +
               ", \"answers\"=[" + incorrectAnswers.stream().map(x -> "\"" + x).collect(Collectors.joining("\", ")) +
               "\",\"" + correctAnswer + "\"" +
               "]}";
    }
}
