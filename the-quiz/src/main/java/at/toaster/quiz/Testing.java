package at.toaster.quiz;

import java.util.ArrayList;

import at.toaster.quiz.data.Answer;
import at.toaster.quiz.data.ObjectSerialization;
import at.toaster.quiz.data.Question;
import at.toaster.quiz.data.QuestionSet;

public class Testing {

	public static void main(String[] args) {

		new Testing();

	}

	public Testing() {
		
		ArrayList<Question> questions = new ArrayList<Question>();

		Answer a1 = new Answer("A", true);
		Answer a2 = new Answer("B", false);
		Answer a3 = new Answer("C", false);
		Answer a4 = new Answer("D", false);

		Question question1 = new Question("A, B, C oder D?", a1, a2, a3, a4);

		questions.add(question1);
		
		Answer a5 = new Answer("E", false);
		Answer a6 = new Answer("F", false);
		Answer a7 = new Answer("G", false);
		Answer a8 = new Answer("H", true);

		Question question2 = new Question("E, F, G oder H?", a5, a6, a7, a8);

		questions.add(question2);

		QuestionSet set = new QuestionSet("Buchstaben", questions);

		System.out.println(ObjectSerialization.OToS(set));

		/*
		
		try {
			QuestionSet qs = QuestionSetHandling.getQuestionSet(connection, 1);
			System.out.println(qs.getQuestionSetName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	*/

	}
}
