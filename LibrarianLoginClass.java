package library;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LibrarianLoginClass {
	JFrame frame;
	JLabel userLabel;
	JLabel passwordLabel;
	JPanel userPanel;
	JPanel passwordPanel;
	JPanel usernameLabel;
	JPanel passwordLabelPanel;
	JPanel backPanel;
	JEditorPane userPane;
	JEditorPane passwordPane;
	JButton login;
	JButton back;
	
	public LibrarianLoginClass() {
		frame = new JFrame("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(600, 600);
		
		//Instantiate new labels, buttons, panes, and panels
		userLabel = new JLabel("Username");
		userPanel = new JPanel();
		userPane = new JEditorPane();
		login = new JButton("Login");
		
		usernameLabel = new JPanel();
		usernameLabel.setSize(120, 45);
		usernameLabel.setLocation(150, 200);
		usernameLabel.add(userLabel);
		
		//Set size and location of userPanel
		userPanel.setSize(100, 40);
		userPanel.setLocation(250, 200);
		
		//userPanel.add(userLabel);
		userPanel.add(userPane);
		
		
		passwordLabel = new JLabel("Password");
		passwordPane = new JEditorPane();
		passwordPanel = new JPanel();
		
		passwordPanel.setSize(100,75);
		passwordPanel.setLocation(250, 240);
		
		passwordPanel.add(passwordPane);
		passwordPanel.add(login);
		
		passwordLabelPanel = new JPanel();
		passwordLabelPanel.setSize(120,100);
		passwordLabelPanel.setLocation(150, 240);
		passwordLabelPanel.add(passwordLabel);
		
		
		back = new JButton("Back");
		backPanel = new JPanel();
		backPanel.setSize(75,100);
		backPanel.setLocation(5, 520);
		backPanel.add(back);
		
		//Add action listener to login button
		login.addActionListener(new LoginActionListener());
		back.addActionListener(new BackActionListener());
		
		frame.getContentPane().setLayout(null);
		frame.add(userPanel);
		frame.add(passwordPanel);
		frame.add(usernameLabel);
		frame.add(passwordLabelPanel);
		frame.add(backPanel);
	}
	
	class BackActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			LoginWindow w = new LoginWindow();
			frame.dispose();
		}
	}
	
	class LoginActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Library IU = new Library();
				if(IU.attemptLogin(userPane.getText(), passwordPane.getText()) == false) {
					System.out.println("hi");
					JLabel incorrect = new JLabel("Username and Password is invalid.");
					JPanel incorrectPanel = new JPanel();
					incorrect.setForeground(Color.RED);
					incorrectPanel.add(incorrect);
					incorrectPanel.setSize(300,100);
					incorrectPanel.setLocation(120, 180);
					frame.add(incorrectPanel);
					frame.setVisible(true);
				} else {
					BooksGUI b = new BooksGUI();
					frame.dispose();
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
}
