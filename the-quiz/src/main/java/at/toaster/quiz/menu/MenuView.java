package at.toaster.quiz.menu;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import at.toaster.quiz.MainControl;

public class MenuView extends JFrame{
	private static final long serialVersionUID = -8506945763768095900L;
	private MenuModel meModel;
	private MainControl mControl;
	private JLabel lTitle;
	private JButton bPlay;
	private JButton bExit;
	
	public MenuView(MenuModel meModel, MainControl mControl) {
		super("Quiz");
		this.meModel = meModel;
		this.mControl = mControl;
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(3,1));
		this.setResizable(false);

		Font fontTitle = new Font(null, Font.PLAIN, 72);
		Font font = new Font(null, Font.PLAIN, 40);
		
		lTitle = new JLabel("Quiz", SwingConstants.CENTER);
		lTitle.setFont(fontTitle);
		
		bPlay = new JButton("Spielen");
		bExit = new JButton("Beenden");
		bPlay.setFont(font);
		bExit.setFont(font);
		
		bPlay.addActionListener(mControl);
		bExit.addActionListener(mControl);
		this.add(lTitle);
		this.add(bPlay);
		this.add(bExit);
		this.setVisible(true);
		
	}
	public boolean bPlay(ActionEvent e) {
		if (e.getSource() == bPlay)
			return true;
		return false;
	}
	
	public boolean bExit(ActionEvent e) {
		if (e.getSource() == this.bExit)
			return true;
		return false;
	}
}
