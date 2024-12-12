package org.jsp.quiz.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsp.quiz.dao.QuestionDao;
import org.jsp.quiz.dto.QuestionDto;
import org.jsp.quiz.dto.QuizResponse;
import org.jsp.quiz.entity.Quiz;
import org.jsp.quiz.exceptionclasses.InvalidQuestionIdException;
import org.jsp.quiz.exceptionclasses.NoQuestionFoundException;
import org.jsp.quiz.responsestructure.ResponseStructure;
import org.jsp.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Service
public class QuestionServiceImpl implements QuestionService{
	@Autowired
	private QuestionDao dao;

	@Override
	public ResponseEntity<?> saveQuestion(Quiz quiz) {
		//re-initialization
		quiz=dao.saveQuestion(quiz);
//		ResponseStructure<Quiz> structure=new ResponseStructure<Quiz>();
//		structure.setHttpStatus(HttpStatus.OK.value());
//		structure.setMessage("Question saved SuccessFully");
//		structure.setBody(quiz);
//		return new ResponseEntity<>(structure,HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value()).message("Question saved successfully").body(quiz).build());
		
	}

	@Override
	public ResponseEntity<?> findAllQuestions() {
		//List<Quiz> questions=dao.findAllQuestions();
		List<Quiz> questions=dao.findAllActiveQuestions();
		List<QuestionDto> dtolist=new ArrayList<>();
		
		for(Quiz q:questions)
		{
			dtolist.add(new QuestionDto(q.getQuestion(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4()));
		}
		
		
		
		if(dtolist.isEmpty())
		{
//			throw new NoQuestionFoundException();
		 throw NoQuestionFoundException.builder().message("No question found in the Database").build();
		  	
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value()).message("Question Found successfully").body(dtolist).build());
	}

	@Override
	public ResponseEntity<?> findQuestionById(int id) {
		Optional<Quiz> optional=dao.findQuestionById(id);
		if(optional.isEmpty())
		{
			throw InvalidQuestionIdException.builder().message("Inavlid Question id").build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value()).message("Question Found successfully").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> submitQuiz(List<QuizResponse> quizResponses) {
		int c=0;
		for(QuizResponse qr:quizResponses) {
		 Optional<Quiz> q= dao.findQuestionById(qr.getId());	
//		 if(q.isEmpty())
//		 {
//			 throw InvalidQuestionIdException.builder().message("Inavlid question id and unable to calculate result").build();
//		 }
		 Quiz quiz = q.get();
		 if(quiz.getAnswer().equalsIgnoreCase(qr.getAnswer())) {
			 c++;
		 }
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value()).message("Question submitted successfully").body("Your Score"+c).build());
		
	}

}
