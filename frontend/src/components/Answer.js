import React from "react";
import { Container, Row, Col, Button } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";

const Answer = ({ answer, pickedAnswer, index }) => {
  return (
    <Container>
      <Row>
        <Col xs={{ span: 8 }}>{answer}</Col>
        <Col xs={{ span: 4 }}>
          <Button onClick={pickedAnswer = index}>Klik hier</Button>
        </Col>
      </Row>
    </Container>
  );
};

export default Answer;
