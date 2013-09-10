package at.toaster.quiz.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPRequest {

	public static String Post(URL url, String params) throws IOException {

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setUseCaches(false);
		connection.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		connection.setRequestProperty("Content-Length",
				String.valueOf(params.length()));

		OutputStreamWriter writer = new OutputStreamWriter(
				connection.getOutputStream());
		writer.write(params);
		writer.flush();

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));

		String output = "";

		for (String line; (line = reader.readLine()) != null;) {
			output += line;
		}

		writer.close();
		reader.close();

		return output;

	}

}
