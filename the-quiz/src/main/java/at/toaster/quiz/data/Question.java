package at.toaster.quiz.data;

import java.io.Serializable;

public class Question implements Serializable {

	private static final long serialVersionUID = 1L;

	private String questionText;

	private Answer answer1;
	private Answer answer2;
	private Answer answer3;
	private Answer answer4;

	public Question(String questionText, Answer answer1, Answer answer2,
			Answer answer3, Answer answer4) {
		
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;

	}

	public String getQuestionText() {
		return questionText;
	}

	public Answer getAnswer1() {
		return answer1;
	}

	public Answer getAnswer2() {
		return answer2;
	}

	public Answer getAnswer3() {
		return answer3;
	}

	public Answer getAnswer4() {
		return answer4;
	}

}
