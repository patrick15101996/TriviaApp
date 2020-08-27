package com.trivia.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.trivia.api.model.Question;
import com.trivia.api.model.QuestionBuilder;
import com.trivia.api.service.TriviaService;
import org.apache.commons.collections.ListUtils;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiApplicationTests {
    private TriviaService service;
    private List<Question> questions;

    @BeforeEach
    void setup() throws Exception {
        service = new TriviaService();
        questions = service.getQuestions();
    }

    @Test
    void answersReceivedSameAsSent() {
        Question initialQuestion = new QuestionBuilder(0)
            .setContent("Test questions")
            .setCorrectAnswer("Correct Answer 1")
            .setIncorrectAnswers(new ArrayList<String>() {{
                add("Incorrect Answer 2");
                add("Incorrect Answer 3");
                add("Incorrect Answer 4");
            }})
            .build();
        Question questionToBeSent = new Question(initialQuestion);
        List initialAnswers = ListUtils.union(initialQuestion.getIncorrectAnswers(), Collections.singletonList(initialQuestion.getCorrectAnswer()));
        for (String answer : questionToBeSent.getAnswers()) {
            Assert.assertTrue(initialAnswers.contains(answer));
        }
    }

    @Test
    void fiveQuestionsReceived() {
        Assert.assertEquals("An odd amount of questions were found: " + questions.size(), 5, questions.size());
    }

    @Test
    void stringFromCheckAnswer() {
        String answer = service.getCorrectAnswer(0);
        Assert.assertTrue("Answer from triviaService is empty", StringUtils.isNotBlank(answer));
        Assert.assertTrue("Correct answer was not retrieved", questions.get(0).getCorrectAnswer().equalsIgnoreCase(answer));
    }
}
