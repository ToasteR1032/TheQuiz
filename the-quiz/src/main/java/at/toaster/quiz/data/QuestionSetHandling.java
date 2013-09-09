package at.toaster.quiz.data;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionSetHandling {

	public static QuestionSet readSet(String base64object)
			throws ClassNotFoundException, IOException {

		byte b[] = base64object.getBytes();

		ByteArrayInputStream bi = new ByteArrayInputStream(b);
		ObjectInputStream si = new ObjectInputStream(bi);

		return (QuestionSet) si.readObject();

	}

	public static String writeSet(QuestionSet set) throws IOException {

		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream so = new ObjectOutputStream(bo);
		so.writeObject(set);
		so.flush();

		return String.valueOf(Base64Coder.encode(bo.toString().getBytes()));

	}
	
	public static QuestionSet getQuestionSet(Connection connection, int id) throws SQLException, ClassNotFoundException, IOException {
		
		ResultSet result = connection.createStatement().executeQuery("SELECT content FROM questionset WHERE id=" + id);
		
		result.next();
		String content = result.getString("content");
		
		if ((content == "") || (content == null)) return null;
		
		return readSet(content);
		
	}

}
