package com.trivia.api.controller;

import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.trivia.api.service.TriviaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin({ "http://localhost:8080", "http://localhost:4200", "http://localhost:9050", "http://localhost:80", "http://localhost:3000" })
@RestController
@RequestMapping("/checkanswers")
public class CheckAnswersController {

    private final TriviaService service;

    public CheckAnswersController(TriviaService service) {
        this.service = service;
    }

    @PostMapping("")
    public Response checkAnswer(@RequestBody Map<String, Integer> map) {
        try {
            String result = service.getCorrectAnswer(map.getOrDefault("id", null));
            return result == null
                ? Response.serverError().build()
                : Response.ok(result, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}