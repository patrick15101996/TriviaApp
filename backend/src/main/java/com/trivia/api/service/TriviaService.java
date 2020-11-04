package com.trivia.api.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.trivia.api.model.Question;
import com.trivia.api.response.TriviaResponse;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TriviaService {
    private static final Map<Long, String> questionAnswersMap = new HashMap<>();
    private static long questionIdToAssign = 0;

    public String getCorrectAnswer(long id) {
        return questionAnswersMap.getOrDefault(id, null);
    }

    public List<Question> getQuestions() throws Exception {
        HttpResponse<String> httpResponse = Unirest.get("https://opentdb.com/api.php?amount=5&type=multiple").asString();
        TriviaResponse response = new ObjectMapper().readValue(httpResponse.getBody(), TriviaResponse.class);
        response.results.forEach(x -> {
            x.setId(questionIdToAssign++);
            questionAnswersMap.put(x.getId(), x.getCorrectAnswer());
        });
        return response.results;
    }
}
