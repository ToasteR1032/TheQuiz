package at.toaster.quiz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.apache.log4j.Logger;

import at.toaster.quiz.data.Question;
import at.toaster.quiz.data.QuestionSet;
import at.toaster.quiz.data.QuestionSetHandling;

public class MainView extends JFrame {
	private static final long serialVersionUID = 5581544918997956339L;
	private static final Logger LOG = Logger.getLogger(MainView.class);
	
	private MainModel mModel;
	private MainControl mControl;

	private JLabel lQuestion;
	private JLabel lAnswer1;
	private JLabel lAnswer2;
	private JLabel lAnswer3;
	private JLabel lAnswer4;

	public JButton bPlayer1;
	public JButton bPlayer2;

	private String questionText;
	private String answerText1;
	private String answerText2;
	private String answerText3;
	private String answerText4;
	private int qNumber;
	private QuestionSet qSet;

	private JPanel answers;

	private boolean player1Active = false;
	private boolean player2Active = false;

	private PlaySound buzzer;

	public Timer timer1;
	public Timer timer2;

	public MainView(MainModel mModel, MainControl mControl) {
		super("Quiz");
		this.mModel = mModel;
		this.mControl = mControl;
		this.setLayout(new BorderLayout());

		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.qNumber = 0;
		
		try {
			this.qSet = QuestionSetHandling.getQuestionSet(mControl.connector.getConnection(), 1);
		} catch (Exception e) {
			LOG.error("Connection Error occurred: " + e);
		}
		
		Question question = qSet.getQuestions().get(qNumber);
		
		Font question_font = new Font(null, Font.PLAIN, 40);
		Font question_small = new Font(null, Font.PLAIN, 30);
		Font question_verysmall = new Font(null, Font.PLAIN, 20);
		Font answer = new Font(null, Font.PLAIN, 25);

		this.buzzer = new PlaySound("buzzer.wav");

		this.setQuestionText(question.getQuestionText());
		this.setAnswerText1(question.getAnswer1().getText());
		this.setAnswerText2(question.getAnswer2().getText());
		this.setAnswerText3(question.getAnswer3().getText());
		this.setAnswerText4(question.getAnswer4().getText());

		this.timer1 = new Timer(1000, new TimerListener(this, 1));
		this.timer2 = new Timer(1000, new TimerListener(this, 2));

		// Layout

		lQuestion = new JLabel(questionText, JLabel.CENTER);

		// Changing font size of question label, so longer texts still fit
		if (this.getQuestionText().length() > 46) {
			lQuestion.setFont(question_verysmall);
		} else if (this.getQuestionText().length() > 38) {
			lQuestion.setFont(answer);
		} else if (this.getQuestionText().length() > 27) {
			lQuestion.setFont(question_small);
		} else
			lQuestion.setFont(question_font);

		lAnswer1 = new JLabel("1) " + answerText1, JLabel.CENTER);
		lAnswer1.setFont(answer);

		lAnswer2 = new JLabel("2) " + answerText2, JLabel.CENTER);
		lAnswer2.setFont(answer);

		lAnswer3 = new JLabel("3) " + answerText3, JLabel.CENTER);
		lAnswer3.setFont(answer);

		lAnswer4 = new JLabel("4) " + answerText4, JLabel.CENTER);
		lAnswer4.setFont(answer);

		bPlayer1 = new JButton("X");
		bPlayer1.setFont(question_font);

		bPlayer2 = new JButton("X");
		bPlayer2.setFont(question_font);

		answers = new JPanel();

		answers.setLayout(new GridLayout(4, 1));
		answers.add(lAnswer1);
		answers.add(lAnswer2);
		answers.add(lAnswer3);
		answers.add(lAnswer4);

		this.add(lQuestion, BorderLayout.NORTH);

		this.add(answers, BorderLayout.CENTER);

		this.add(bPlayer1, BorderLayout.WEST);
		this.add(bPlayer2, BorderLayout.EAST);

		bPlayer1.addActionListener(mControl);
		bPlayer2.addActionListener(mControl);

		Buzzers buzzers = new Buzzers(this);

		this.addKeyListener(buzzers);
		bPlayer1.addKeyListener(buzzers);
		bPlayer2.addKeyListener(buzzers);

	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getAnswerText1() {
		return answerText1;
	}

	public void setAnswerText1(String answerText1) {
		this.answerText1 = answerText1;
	}

	public String getAnswerText2() {
		return answerText2;
	}

	public void setAnswerText2(String answerText2) {
		this.answerText2 = answerText2;
	}

	public String getAnswerText3() {
		return answerText3;
	}

	public void setAnswerText3(String answerText3) {
		this.answerText3 = answerText3;
	}

	public String getAnswerText4() {
		return answerText4;
	}

	public void setAnswerText4(String answerText4) {
		this.answerText4 = answerText4;
	}

	public void player1() {
		if (!player1Active && !player2Active) {
			player1Active = true;

			buzzer.play();

			this.bPlayer1.setBackground(Color.red);
			this.bPlayer2.setEnabled(false);
			this.bPlayer1.setText("3");

			timer1.start();
		}
	}

	public void player2() {
		if (!player1Active && !player2Active) {
			player2Active = true;

			buzzer.play();

			this.bPlayer2.setBackground(Color.red);
			this.bPlayer1.setEnabled(false);
			this.bPlayer2.setText("3");

			timer2.start();
		}
	}

	public void player1Finished() {
		player1Active = false;

		this.bPlayer1.setBackground(null);
		this.bPlayer2.setEnabled(true);

		this.bPlayer1.setText("X");
	}

	public void player2Finished() {
		player2Active = false;

		this.bPlayer2.setBackground(null);
		this.bPlayer1.setEnabled(true);

		this.bPlayer2.setText("X");
	}

	public void answer1() {
		
	}

	public void answer2() {

	}

	public void answer3() {

	}

	public void answer4() {

	}
	
	public void nextQuestion() {
		
	}
	
	public boolean bPlayer1(ActionEvent e) {
		if (e.getSource() == this.bPlayer1)
			return true;
		return false;
	}

	public boolean bPlayer2(ActionEvent e) {
		if (e.getSource() == this.bPlayer2)
			return true;
		return false;
	}

}
