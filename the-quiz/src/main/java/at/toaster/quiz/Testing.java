package at.toaster.quiz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import at.toaster.quiz.data.Answer;
import at.toaster.quiz.data.Question;
import at.toaster.quiz.data.QuestionSet;
import at.toaster.quiz.data.QuestionSetHandling;

public class Testing {
	
	public Testing(Connection connection) {
		/*
		ArrayList<Question> questions = new ArrayList<Question>();
		
		Answer a1 = new Answer("1", true);
		Answer a2 = new Answer("2", false);
		Answer a3 = new Answer("3", false);
		Answer a4 = new Answer("4", false);
		
		Question question = new Question("1, 2, 3 oder 4", a1, a2, a3, a4);
		
		questions.add(question);
		
		QuestionSet set = new QuestionSet("Test", questions);
		
		try {
			System.out.println(SerializeObject.convertToString(set));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		*/
		
		try {
			QuestionSet qs = QuestionSetHandling.getQuestionSet(connection, 1);
			
			System.out.println(qs.getQuestionSetName());
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
