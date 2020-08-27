package com.trivia.api.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {

    private long id;
    @JsonProperty("question")
    private String content;
    @JsonProperty("incorrect_answers")
    private List<String> incorrectAnswers;
    @JsonProperty("correct_answer")
    private String correctAnswer;
    @JsonProperty("answers")
    private List<String> answers;

    Question() {

    }

    public Question(long id, String content, List<String> incorrectAnswers, String correctAnswer) {
        this.id = id;
        this.content = content;
        this.incorrectAnswers = incorrectAnswers;
        this.correctAnswer = correctAnswer;
    }

    public Question(Question question) {
        id = question.getId();
        content = question.getContent();
        answers = new ArrayList<>(question.getIncorrectAnswers());
        answers.add(question.getCorrectAnswer());
        Collections.shuffle(answers);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(List<String> incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
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
