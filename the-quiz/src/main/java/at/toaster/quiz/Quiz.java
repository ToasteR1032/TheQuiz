package at.toaster.quiz;

import org.apache.log4j.Logger;

public class Quiz {
	private static final Logger LOG = Logger.getLogger(Quiz.class);
	public static void main (String[] args) {

		LOG.debug("Starting programm...");
		new MainControl();
	}
}
