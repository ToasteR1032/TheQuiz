package at.toaster.authmenu;

import javax.swing.JFrame;

import at.toaster.quizuploader.MainControl;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AuthenticationWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainControl mControl;
	private JTextField tfSetName;
	private JTextField tfUserName;
	private JPasswordField tfPassword;
	private JButton bSave;
	private JButton bBack;

	public AuthenticationWindow(MainControl mControl) {
		super("Quiz-Uploader");
		this.mControl = mControl;
		initGUI();
	}

	public void save() {

	}

	public boolean bSave(ActionEvent e) {
		if (e.getSource() == this.bSave)
			return true;
		return false;
	}

	public boolean bBack(ActionEvent e) {
		if (e.getSource() == this.bBack)
			return true;
		return false;
	}

	public void initGUI() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		setResizable(false);
		this.setSize(331, 199);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblQuestionSetName = new JLabel("Question Set Name:");
		lblQuestionSetName.setBounds(12, 13, 115, 16);
		getContentPane().add(lblQuestionSetName);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(12, 57, 70, 16);
		getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(12, 93, 70, 16);
		getContentPane().add(lblPassword);

		tfSetName = new JTextField();
		tfSetName.setBounds(131, 10, 183, 22);
		getContentPane().add(tfSetName);
		tfSetName.setColumns(10);

		tfUserName = new JTextField();
		tfUserName.setColumns(10);
		tfUserName.setBounds(131, 57, 183, 22);
		getContentPane().add(tfUserName);

		tfPassword = new JPasswordField();
		tfPassword.setBounds(131, 90, 183, 22);
		getContentPane().add(tfPassword);

		JSeparator separator = new JSeparator();
		separator.setBounds(12, 42, 302, 2);
		getContentPane().add(separator);

		this.bSave = new JButton("Save Question Set");
		this.bSave.setBounds(131, 126, 183, 25);
		getContentPane().add(this.bSave);

		this.bBack = new JButton("Back");
		this.bBack.setBounds(12, 126, 115, 25);
		getContentPane().add(this.bBack);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] {
				tfSetName, tfUserName, tfPassword }));

		this.bSave.addActionListener(mControl);
		this.bBack.addActionListener(mControl);

		this.getRootPane().setDefaultButton(bSave);
	}
}
