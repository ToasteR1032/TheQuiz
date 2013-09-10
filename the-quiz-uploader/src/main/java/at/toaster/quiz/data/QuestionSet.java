package at.toaster.quiz.data;

import java.io.Serializable;
import java.util.ArrayList;

public class QuestionSet implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String questionSetName;
	
	private ArrayList<Question> questions;
	
	public QuestionSet(String questionSetName, ArrayList<Question> questions) {
		
		this.questionSetName = questionSetName;
		this.questions = questions;
		
	}

	public String getQuestionSetName() {
		return questionSetName;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}
	
}
