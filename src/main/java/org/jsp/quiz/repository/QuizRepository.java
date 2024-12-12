package org.jsp.quiz.repository;

import java.util.List;

import org.jsp.quiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
	@Query("select q from Quiz q where q.status='ACTIVE'")
	List<Quiz> findAllActiveQuestions();

}
