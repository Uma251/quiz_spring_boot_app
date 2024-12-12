package org.jsp.quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	
	

}
