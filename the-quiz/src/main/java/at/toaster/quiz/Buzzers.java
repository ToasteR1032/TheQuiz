package at.toaster.quiz;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Buzzers implements KeyListener {

	private MainView mView;

	public Buzzers(MainView mView) {
		this.mView = mView;
	}

	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
			mView.player1();
		}

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			mView.player2();
		}

		// Answer 1
		if (e.getKeyCode() == KeyEvent.VK_1) {
			mView.answer1();
		}

		// Answer 2
		if (e.getKeyCode() == KeyEvent.VK_2) {
			mView.answer2();
		}
		
		// Answer 3
		if (e.getKeyCode() == KeyEvent.VK_3) {
			mView.answer3();
		}
		
		// Answer 4
		if (e.getKeyCode() == KeyEvent.VK_4) {
			mView.answer4();
		}
		
		//Skip Question
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			mView.nextQuestion();
		}
	}


	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}


	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
