package at.toaster.quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerListener implements ActionListener{
	
	private MainView mView;
	private int player;
	private int value = 3;
	
	public TimerListener(MainView mView, int player) {
		this.mView = mView;
		this.player = player;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		value--;
		
		if (player == 1) {
			mView.bPlayer1.setText(value+"");
			
			if (value == 0) {
				mView.player1Finished();
				mView.timer1.stop();
				value = 3;
			}
			
		}
		
		if (player == 2) {
			mView.bPlayer2.setText(value+"");
			
			if (value == 0) {
				mView.player2Finished();
				mView.timer2.stop();
				value = 3;
			}
			
		}
		
	}
}
