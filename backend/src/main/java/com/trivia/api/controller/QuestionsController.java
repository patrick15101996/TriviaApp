package com.trivia.api.controller;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.trivia.api.model.Question;
import com.trivia.api.response.QuestionResponse;
import com.trivia.api.service.TriviaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin({ "http://localhost:8080", "http://localhost:4200", "http://localhost:9050", "http://localhost:80", "http://localhost:3000" })
@RestController
@Produces("application/json")
@RequestMapping("/questions")
public class QuestionsController {

    private final TriviaService service;

    public QuestionsController(TriviaService service) {
        this.service = service;
    }

    @GetMapping("")
    public Response getQuestions() {
        try {
            List<Question> rawResult = service.getQuestions();
            return Response.ok(new QuestionResponse(rawResult), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
