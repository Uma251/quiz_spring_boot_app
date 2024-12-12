package org.jsp.quiz.exceptionclasses;

import lombok.Builder;

@Builder
//can create an object without using new keyword
public class NoQuestionFoundException extends  RuntimeException {
	
	private String message;
	@Override
	public String getMessage() {
		return this.message;
	}
	public NoQuestionFoundException() {
		
	}
    public NoQuestionFoundException( String message) {
	this.message=message;
		
	}

}
