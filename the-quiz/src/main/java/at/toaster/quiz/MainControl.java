package at.toaster.quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.log4j.Logger;

import at.toaster.quiz.menu.MenuModel;
import at.toaster.quiz.menu.MenuView;

public class MainControl implements ActionListener{
	private MainView mView;
	private MainModel mModel;
	private MenuModel meModel;
	private MenuView meView;
	public MySQLConnector connector;
	
	private static final Logger LOG = Logger.getLogger(MainControl.class);
	
	public MainControl(MySQLConnector connector) {
		this.connector = connector;
		this.mModel = new MainModel();
		this.meModel = new MenuModel();
		this.meView = new MenuView(meModel, this, connector);
		this.mView = new MainView(mModel, this, meView.lSets.getSelectedIndex() + 1);
	}
	
	public void actionPerformed (ActionEvent e) {
		
		//Menu
		if (meView.bPlay(e)) {
			meView.setVisible(false);
			mView.setVisible(true);
		}
		
		if (meView.bExit(e)) {
			LOG.debug("Exiting...");
			System.exit(0);
		}
		
		//Game
		//Player 1
		if (mView.bPlayer1(e)) {
			mView.player1();
		}
		
		//Player 2
		if (mView.bPlayer2(e)) {
			mView.player2();
		}
	}
}
