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
import javax.swing.JOptionPane;
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

	private int qNumber;
	private QuestionSet qSet;
	private Question question;

	private JPanel answers;

	private boolean player1Active = false;
	private boolean player2Active = false;

	private PlaySound buzzer;

	public Timer timer1;
	public Timer timer2;

	private int points1 = 0;
	private int points2 = 0;

	Font question_font = new Font(null, Font.PLAIN, 40);
	Font question_small = new Font(null, Font.PLAIN, 30);
	Font question_verysmall = new Font(null, Font.PLAIN, 20);
	Font answer = new Font(null, Font.PLAIN, 25);

	public MainView(MainModel mModel, MainControl mControl, int questionSetID) {
		super("Quiz");
		this.mModel = mModel;
		this.mControl = mControl;
		this.setLayout(new BorderLayout());

		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.qNumber = -1;

		try {
			this.qSet = QuestionSetHandling.getQuestionSet(
					mControl.connector.getConnection(), questionSetID);
		} catch (Exception e) {
			LOG.error("Connection Error occurred: " + e);
		}

		this.buzzer = new PlaySound("buzzer.wav");

		this.timer1 = new Timer(1000, new TimerListener(this, 1));
		this.timer2 = new Timer(1000, new TimerListener(this, 2));

		// Layout

		lQuestion = new JLabel("Question", JLabel.CENTER);

		lAnswer1 = new JLabel("1)", JLabel.CENTER);
		lAnswer1.setFont(answer);

		lAnswer2 = new JLabel("2)", JLabel.CENTER);
		lAnswer2.setFont(answer);

		lAnswer3 = new JLabel("3)", JLabel.CENTER);
		lAnswer3.setFont(answer);

		lAnswer4 = new JLabel("4)", JLabel.CENTER);
		lAnswer4.setFont(answer);

		bPlayer1 = new JButton(points1+"");
		bPlayer1.setFont(question_font);
		bPlayer1.setFocusable(false);

		bPlayer2 = new JButton(points2+"");
		bPlayer2.setFont(question_font);
		bPlayer2.setFocusable(false);

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

		this.nextQuestion();

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

		this.bPlayer1.setText(points1 + "");
	}

	public void player2Finished() {
		player2Active = false;

		this.bPlayer2.setBackground(null);
		this.bPlayer1.setEnabled(true);

		this.bPlayer2.setText(points2 + "");
	}

	public void answer1() {
		if (player1Active) {
			if (question.getAnswer1().isCorrect()) {
				points1++;
				this.bPlayer1.setText(points1+"");
			} else {
				points2++;
				this.bPlayer2.setText(points2+"");
			} 
			timer1.stop();
			player1Finished();
			nextQuestion();
		}
		
		if (player2Active) {
			if (question.getAnswer1().isCorrect()) {
				points2++;
				this.bPlayer2.setText(points2+"");
			} else {
				points1++;
				this.bPlayer1.setText(points1+"");
			}
			timer2.stop();
			player2Finished();
			nextQuestion();
		}
	}

	public void answer2() {
		if (player1Active) {
			if (question.getAnswer2().isCorrect()) {
				points1++;
				this.bPlayer1.setText(points1+"");
			} else {
				points2++;
				this.bPlayer2.setText(points2+"");
			}
			timer1.stop();
			player1Finished();
			nextQuestion();
		}
		
		if (player2Active) {
			if (question.getAnswer2().isCorrect()) {
				points2++;
				this.bPlayer2.setText(points2+"");
			} else {
				points1++;
				this.bPlayer1.setText(points1+"");
			}
			timer2.stop();
			player2Finished();
			nextQuestion();
		}
	}

	public void answer3() {
		if (player1Active) {
			if (question.getAnswer3().isCorrect()) {
				points1++;
				this.bPlayer1.setText(points1+"");
			} else {
				points2++;
				this.bPlayer2.setText(points2+"");
			}
			timer1.stop();
			player1Finished();
			nextQuestion();
		}
		
		if (player2Active) {
			if (question.getAnswer3().isCorrect()) {
				points2++;
				this.bPlayer2.setText(points2+"");
			} else {
				points1++;
				this.bPlayer1.setText(points1+"");
			}
			timer2.stop();
			player2Finished();
			nextQuestion();
		}
	}

	public void answer4() {
		if (player1Active) {
			if (question.getAnswer4().isCorrect()) {
				points1++;
				this.bPlayer1.setText(points1+"");
			} else {
				points2++;
				this.bPlayer2.setText(points2+"");
			} 
			timer1.stop();
			player1Finished();
			nextQuestion();
		}
		
		if (player2Active) {
			if (question.getAnswer4().isCorrect()) {
				points2++;
				this.bPlayer2.setText(points2+"");
			} else {
				points1++;
				this.bPlayer1.setText(points1+"");
			} 
			timer2.stop();
			player2Finished();
			nextQuestion();
		}
	}

	public void nextQuestion() {
		if (player1Active || player2Active) return;
		
		this.qNumber++;

		if (qSet.getQuestions().size() == this.qNumber) {
			this.end();
			return;
		}

		question = qSet.getQuestions().get(qNumber);

		this.lQuestion.setText(question.getQuestionText());
		this.lAnswer1.setText("1) " + question.getAnswer1().getText());
		this.lAnswer2.setText("2) " + question.getAnswer2().getText());
		this.lAnswer3.setText("3) " + question.getAnswer3().getText());
		this.lAnswer4.setText("4) " + question.getAnswer4().getText());

		// Changing font size of question label, so longer texts still fit
		if (this.lQuestion.getText().length() > 46) {
			lQuestion.setFont(question_verysmall);
		} else if (this.lQuestion.getText().length() > 38) {
			lQuestion.setFont(answer);
		} else if (this.lQuestion.getText().length() > 27) {
			lQuestion.setFont(question_small);
		} else
			lQuestion.setFont(question_font);

	}
	
	public void timeUp1() {
		player1Finished();
		points2++;
		this.bPlayer2.setText(points2+"");
		nextQuestion();
		
	}
	
	public void timeUp2() {
		player2Finished();
		points1++;
		this.bPlayer1.setText(points1+"");
		nextQuestion();
	}
	
	public void end() {
		if (points1 > points2) {
			JOptionPane.showMessageDialog(null, "GAME OVER!\nPlayer 1 wins!");
		} else if (points1 < points2) {
			JOptionPane.showMessageDialog(null, "GAME OVER!\nPlayer 2 wins!");
		} else {
			JOptionPane.showMessageDialog(null, "GAME OVER!\nIt's a tie!");
		}
		
		System.exit(0);
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
