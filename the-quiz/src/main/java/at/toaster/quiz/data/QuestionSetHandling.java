package at.toaster.quiz.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionSetHandling {

	public static QuestionSet getQuestionSet(Connection connection, int id)
			throws SQLException, ClassNotFoundException, IOException {

		ResultSet result = connection.createStatement().executeQuery(
				"SELECT content FROM questionsets WHERE id=" + id);

		result.next();
		String content = result.getString("content");

		return (QuestionSet) ObjectSerialization.SToO(content);

	}

}
