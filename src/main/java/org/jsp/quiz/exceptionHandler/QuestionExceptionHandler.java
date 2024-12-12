package org.jsp.quiz.exceptionHandler;

import org.jsp.quiz.exceptionclasses.InvalidQuestionIdException;
import org.jsp.quiz.exceptionclasses.NoQuestionFoundException;
import org.jsp.quiz.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class QuestionExceptionHandler {
	
	@ExceptionHandler(NoQuestionFoundException.class)
	public ResponseEntity<?> noQuestionfoundExceptionHandler(NoQuestionFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().httpStatus(HttpStatus.NOT_FOUND.value()).message("question not found in db").body("Question not dound in DB").build());
	}
	@ExceptionHandler(InvalidQuestionIdException.class)
	public ResponseEntity<?> invalidQuestionfoundExceptionHandler(InvalidQuestionIdException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().httpStatus(HttpStatus.NOT_FOUND.value()).message("Invalid Question Id").body("Inavlid Id unable to find questions").build());
	}
    
}
