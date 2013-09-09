package at.toaster.quiz;
import java.sql.Connection;

import at.toaster.quiz.data.QuestionSet;
import at.toaster.quiz.data.ObjectSerialization;
import at.toaster.quiz.data.QuestionSetHandling;

public class Testing {

	public static void main(String[] args) {

		MySQLConnector connector = new MySQLConnector("80.241.220.222", "quiz",
				"quiz", "quiz");
		new Testing(connector.getConnection());

	}

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

		System.out.println(ObjectSerialization.OToS(set));

		*/
		
		try {
			QuestionSet qs = QuestionSetHandling.getQuestionSet(connection, 1);
			System.out.println(qs.getQuestionSetName());
		} catch (Exception e) {
			e.printStackTrace();
		}



	}
}
