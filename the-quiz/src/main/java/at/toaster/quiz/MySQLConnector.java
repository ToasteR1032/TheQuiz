package at.toaster.quiz;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

public class MySQLConnector {

	private Connection connection;
	private static final Logger LOG = Logger.getLogger(MySQLConnector.class);
	public MySQLConnector(String host, String database, String username,
			String password) {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database + "?user=" + username + "&password=" + password);
			LOG.info("Connected");
			
		} catch (Exception e) {
		
			LOG.error("Connection-Error occurred: " + e);
			
		}

	}
	
	public Connection getConnection() {
		
		return this.connection;
		
	}

}
