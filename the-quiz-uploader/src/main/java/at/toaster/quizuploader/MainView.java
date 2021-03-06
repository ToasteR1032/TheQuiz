package at.toaster.quizuploader;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import at.toaster.quiz.data.Answer;
import at.toaster.quiz.data.Question;

import java.awt.Component;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MainControl mControl;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	private JRadioButton radioButton_1;
	private JRadioButton radioButton_2;
	private JRadioButton radioButton_3;
	private JRadioButton radioButton_4;
	private ButtonGroup rButtons;

	private JButton btnSaveAndNext;
	private JButton btnFinalizeQuestionset;

	public MainView(MainControl mControl) {
		super("Quiz-Uploader");
		this.mControl = mControl;
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Exception e) {
		}
		drawGUI();

		btnSaveAndNext.addActionListener(mControl);
		btnFinalizeQuestionset.addActionListener(mControl);

		this.getRootPane().setDefaultButton(btnSaveAndNext);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] {
				textField, textField_1, textField_2, textField_3, textField_4 }));
		this.setVisible(true);
	}

	public boolean save() {

		if (textField.getText().isEmpty() || textField_2.getText().isEmpty()
				|| textField_3.getText().isEmpty()
				|| textField_4.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Empty Fields", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		Answer a1 = new Answer(this.textField_1.getText(),
				this.radioButton_1.isSelected());
		Answer a2 = new Answer(this.textField_2.getText(),
				this.radioButton_2.isSelected());
		Answer a3 = new Answer(this.textField_3.getText(),
				this.radioButton_3.isSelected());
		Answer a4 = new Answer(this.textField_4.getText(),
				this.radioButton_4.isSelected());

		mControl.questions.add(new Question(this.textField.getText(), a1, a2,
				a3, a4));

		this.textField.setText("");
		this.textField_1.setText("");
		this.textField_2.setText("");
		this.textField_3.setText("");
		this.textField_4.setText("");

		this.radioButton_2.setSelected(false);
		this.radioButton_3.setSelected(false);
		this.radioButton_4.setSelected(false);
		this.radioButton_1.setSelected(true);

		this.textField.requestFocus();
		return true;
	}

	public boolean bSave(ActionEvent e) {
		if (e.getSource() == this.btnSaveAndNext)
			return true;
		return false;
	}

	public boolean bFinalize(ActionEvent e) {
		if (e.getSource() == this.btnFinalizeQuestionset)
			return true;
		return false;
	}

	public void drawGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 279);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(95, 10, 317, 22);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(95, 60, 241, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		rButtons = new ButtonGroup();

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(95, 93, 241, 22);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(95, 127, 241, 22);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(95, 162, 241, 22);
		contentPane.add(textField_4);

		btnSaveAndNext = new JButton("next Question");
		btnSaveAndNext.setBounds(204, 200, 216, 31);
		contentPane.add(btnSaveAndNext);

		btnFinalizeQuestionset = new JButton("finalize Questionset");
		btnFinalizeQuestionset.setBounds(12, 200, 189, 31);
		contentPane.add(btnFinalizeQuestionset);

		radioButton_1 = new JRadioButton("Correct");
		radioButton_1.setBounds(344, 60, 88, 22);
		contentPane.add(radioButton_1);
		radioButton_1.setSelected(true);

		rButtons.add(radioButton_1);

		radioButton_2 = new JRadioButton("Correct");
		radioButton_2.setBounds(344, 93, 88, 22);
		contentPane.add(radioButton_2);
		rButtons.add(radioButton_2);

		radioButton_3 = new JRadioButton("Correct");
		radioButton_3.setBounds(344, 127, 88, 22);
		contentPane.add(radioButton_3);

		radioButton_4 = new JRadioButton("Correct");
		radioButton_4.setBounds(344, 162, 88, 22);
		contentPane.add(radioButton_4);
		rButtons.add(radioButton_3);
		rButtons.add(radioButton_4);

		JLabel lblQuestion = new JLabel("Question:");
		lblQuestion.setBounds(15, 16, 68, 16);
		contentPane.add(lblQuestion);

		JLabel lblAnswer = new JLabel("Answer 1:");
		lblAnswer.setBounds(15, 66, 68, 16);
		contentPane.add(lblAnswer);

		JLabel lblAnswer_1 = new JLabel("Answer 2:");
		lblAnswer_1.setBounds(15, 99, 68, 16);
		contentPane.add(lblAnswer_1);

		JLabel lblAnswer_3 = new JLabel("Answer 4:");
		lblAnswer_3.setBounds(15, 168, 68, 16);
		contentPane.add(lblAnswer_3);

		JLabel lblAnswer_2 = new JLabel("Answer 3:");
		lblAnswer_2.setBounds(15, 133, 68, 16);
		contentPane.add(lblAnswer_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(15, 51, 405, 2);
		contentPane.add(separator);
	}
}
