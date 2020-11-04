package com.trivia.api.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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

    public Question(long id, String content, List<String> incorrectAnswers, String correctAnswer) {
        this.id = id;
        this.content = content;
        this.incorrectAnswers = incorrectAnswers;
        this.correctAnswer = correctAnswer;
    }

    /**
     * Does not copy incorrectAnswers and correctAnswers to hide the correct answers.
     * @param question A question object to be copied over
     */
    public Question(Question question) {
        id = question.getId();
        content = question.getContent();
        answers = new ArrayList<>(question.getIncorrectAnswers());
        answers.add(question.getCorrectAnswer());
        Collections.shuffle(answers);
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
