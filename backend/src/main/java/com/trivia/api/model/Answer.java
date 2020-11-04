package com.trivia.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Answer {
    @JsonProperty("id")
    long id;
    String content;
    @JsonIgnore
    boolean correct;

    @Override
    public String toString() {
        return "{" +
               "id='" + id + '\'' +
               ", content='" + content + '\'' +
               "},";
    }
}
