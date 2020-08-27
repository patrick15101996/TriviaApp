import React, { Component } from "react";
import "../App.css";
import { Container, Row, Col, Button } from "react-bootstrap";

class Quiz extends Component {
  constructor(props) {
    super(props);
    this.state = {
      questions: [],
      correctAnswer: [],
      score: 0,
    };
  }

  componentDidMount() {
    fetch("http://localhost:8080/questions")
      .then((res) => res.json())
      .then((data) => {
        this.setState({ questions: data.entity.questions });
      });
  }

  checkAnswer = (event, questionId, answer) => {
    let savedTarget = event.target;
    fetch("http://localhost:8080/checkanswers", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ id: questionId }),
    })
      .then((response) => response.json())
      .then((data) => {
        this.setState({ correctAnswer: data.entity });
        if (
          savedTarget.getAttribute("style") === "background-color: #218838;" ||
          savedTarget.getAttribute("style") === "background-color: #c82333;"
        ) {
        } else {
          let currentScore = this.state.score;
          if (this.state.correctAnswer === answer) {
            savedTarget.setAttribute("style", "background-color: #218838;");
            this.setState({ score: ++currentScore });
          } else {
            savedTarget.setAttribute("style", "background-color: #c82333;");
            this.setState({ score: --currentScore });
          }
        }
      });
  };

  scoreBoard = () =>
    this.state.score < 0 ? (
      <h2 style={{ color: "red" }}>
        <b>{this.state.score}</b>
      </h2>
    ) : (
      <h2 style={{ color: "green" }}>
        <b>{this.state.score}</b>
      </h2>
    );

  render() {
    return (
      <Container>
        <Row>
          <Col className={"mb-5"}>
            <h1>
              <b>Welcome to the super duper awesome trivia app!</b>
            </h1>
          </Col>
        </Row>
        {this.state.questions.map((question) => (
          <Row>
            <Col xs={12}>
              <h2
                key={question.id}
                dangerouslySetInnerHTML={{
                  __html: question.question,
                }}></h2>
            </Col>
            <Col>
              <ul>
                {question.answers.map((answer, index) => (
                  <Button
                    className={"mr-5"}
                    variant="info"
                    onClick={(e) => this.checkAnswer(e, question.id, answer)}
                    dangerouslySetInnerHTML={{
                      __html: answer,
                    }}></Button>
                ))}
              </ul>
            </Col>
          </Row>
        ))}
        <Row className={"mt-5"}>
          <Col>
            <h1>
              <b>Your total score is: </b>
            </h1>
            {this.scoreBoard()}
          </Col>
        </Row>
      </Container>
    );
  }
}

export default Quiz;
