package at.toaster.quiz.data;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class QuestionSetHandling {

	public static QuestionSet getQuestionSet(int id)
			throws ClassNotFoundException, IOException {

		String out = HTTPRequest.Post(new URL(
				"http://80.241.220.222/thequiz/getQuestionSet.php"), "id="
				+ URLEncoder.encode(id + "", "UTF-8"));

		return (QuestionSet) ObjectSerialization.SToO(out);

	}
	
	public static boolean postQuestionSet(String username, String password, String name, QuestionSet set) throws MalformedURLException, UnsupportedEncodingException, IOException {
		
		String out = HTTPRequest.Post(new URL("http://80.241.220.222/thequiz/postQuestionSet.php"),
				"username=" + URLEncoder.encode(username, "UTF-8") + "&" +
				"password=" + URLEncoder.encode(password, "UTF-8") + "&" +
				"name=" + URLEncoder.encode(name, "UTF-8") + "&" +
				"content=" + URLEncoder.encode(ObjectSerialization.OToS(set), "UTF-8")
				);
		
		if (out.equals(1)) return true;
		else return false;
			
		
	}
	
	public static String[] getQuestionSets() throws MalformedURLException, IOException {
		
		String out = HTTPRequest.Post(new URL("http://80.241.220.222/thequiz/getQuestionSets.php"), "");
		
		return out.split(";");
		
	}

}
