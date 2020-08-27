import React from 'react'
import Answer from './Answer';

    const Questions = ({ questions }) => {
        const pickedAnswer = null;
      return (
        <div>
          <center><h1>Questions</h1></center>
          {questions.map((question) => (
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">{question.id}</h5>
                <h6 class="card-subtitle mb-2 text-muted">{question.question}</h6>
                {question.answers.map((answer, index) => (
                    <Answer index={index} pickedAnswer={pickedAnswer} answer={answer}/>
                ))}
              </div>
            </div>
          ))}
        </div>
      )
    };

    export default Questions