package org.jsp.quiz.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.quiz.dao.QuestionDao;
import org.jsp.quiz.entity.Quiz;
import org.jsp.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionDaoImpl implements QuestionDao {
	@Autowired
	private QuizRepository repository;

	@Override
	public Quiz saveQuestion(Quiz quiz) {

		return repository.save(quiz);
	}

	@Override
	public List<Quiz> findAllQuestions() {
		
		return repository.findAll();
	}

	@Override
	public Optional<Quiz> findQuestionById(int id) {
		
		return repository.findById(id);
	}

	@Override
	public List<Quiz> findAllActiveQuestions() {
		// TODO Auto-generated method stub
		return repository.findAllActiveQuestions();
	}

}
