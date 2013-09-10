package at.toaster.quizuploader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import at.toaster.authmenu.AuthenticationWindow;
import at.toaster.quiz.data.Question;

public class MainControl implements ActionListener {
	private MainView mView;
	private AuthenticationWindow aView;
	public ArrayList<Question> questions = new ArrayList<Question>();
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
			if (mView.save()) {
				mView.setVisible(false);
				aView.setVisible(true);
			}
		}
		
		//Authentication Window
		if (aView.bSave(e)) {
			try {
				aView.save();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		if (aView.bBack(e)) {
			mView.setVisible(true);
			aView.setVisible(false);
		}
		
		
	}
}
