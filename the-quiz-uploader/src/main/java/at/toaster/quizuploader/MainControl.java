package at.toaster.quizuploader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainControl implements ActionListener {
	private MainView mView;
	
	public MainControl() {
		this.mView = new MainView(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (mView.bSave(e)) {
			mView.save();
		}
		
		if (mView.bFinalize(e)) {
			mView.finalize();
		}
		
	}
}
