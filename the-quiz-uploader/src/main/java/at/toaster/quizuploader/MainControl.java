package at.toaster.quizuploader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import at.toaster.authmenu.AuthenticationWindow;

public class MainControl implements ActionListener {
	private MainView mView;
	private AuthenticationWindow aView;
	
	public MainControl() {
		this.mView = new MainView(this);
		this.aView = new AuthenticationWindow(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Main Window
		if (mView.bSave(e)) {
			mView.save();
		}
		
		if (mView.bFinalize(e)) {
			mView.setVisible(false);
			aView.setVisible(true);
		}
		
		//Authentication Window
		if (aView.bSave(e)) {
			
		}
		
		if (aView.bBack(e)) {
			mView.setVisible(true);
			aView.setVisible(false);
		}
		
		
	}
}
