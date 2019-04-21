package library;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RegisterClass {
	
	JEditorPane createUsername;
	JEditorPane createPassword;
	JButton register;
	JPanel createUsernamePanel;
	JPanel createPasswordPanel;
	JPanel usernamePanel;
	JPanel passwordPanel;
	JPanel registerPanel;
	JLabel usernameLabel;
	JLabel passwordLabel;
	JFrame frame;
	
	public RegisterClass() {
		frame = new JFrame("Register");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		
		register = new JButton("Register");
		registerPanel = new JPanel();
		registerPanel.setSize(100, 100);
		registerPanel.setLocation(252, 300);
		registerPanel.add(register);
		
		createUsername = new JEditorPane();
		createUsernamePanel = new JPanel();
		createUsernamePanel.setSize(100,40);
		createUsernamePanel.setLocation(250, 230);
		createUsernamePanel.add(createUsername);
		
		createPassword = new JEditorPane();
		createPasswordPanel = new JPanel();
		createPasswordPanel.setSize(100,40);
		createPasswordPanel.setLocation(250, 270);
		createPasswordPanel.add(createPassword);
		
		usernameLabel = new JLabel("Create username: ");
		usernamePanel = new JPanel();
		usernamePanel.setSize(120,20);
		usernamePanel.setLocation(125, 232);
		usernamePanel.add(usernameLabel);
		
		passwordLabel = new JLabel("Create password: ");
		passwordPanel = new JPanel();
		passwordPanel.setSize(120, 100);
		passwordPanel.setLocation(125, 272);
		passwordPanel.add(passwordLabel);
		
		register.addActionListener(new RegisterActionListener());
		
		frame.getContentPane().setLayout(null);
		frame.add(registerPanel);
		frame.add(createUsernamePanel);
		frame.add(createPasswordPanel);
		frame.add(usernamePanel);
		frame.add(passwordPanel);
		frame.setVisible(true);
	}
	
	class RegisterActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Student s = new Student(createUsername.getText(), createPassword.getText(), "null", "null");
				StudentGUI sg = new StudentGUI();
				frame.dispose();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
}
