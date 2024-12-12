package org.jsp.quiz.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.quiz.entity.Quiz;

public interface QuestionDao {

	Quiz saveQuestion(Quiz quiz);

	List<Quiz> findAllQuestions();

	Optional<Quiz> findQuestionById(int id);

	List<Quiz> findAllActiveQuestions();

}
