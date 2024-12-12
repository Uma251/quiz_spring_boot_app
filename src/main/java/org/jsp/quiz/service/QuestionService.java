package org.jsp.quiz.service;

import java.util.List;

import org.jsp.quiz.dto.QuizResponse;
import org.jsp.quiz.entity.Quiz;
import org.springframework.http.ResponseEntity;

public interface QuestionService {

	ResponseEntity<?> saveQuestion(Quiz quiz);

	ResponseEntity<?> findAllQuestions();

	ResponseEntity<?> findQuestionById(int id);

	ResponseEntity<?> submitQuiz(List<QuizResponse> quizResponses);

}
