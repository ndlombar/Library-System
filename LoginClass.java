import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class LoginClass {
	JFrame frame;
	JLabel userLabel;
	JLabel passwordLabel;
	JPanel userPanel;
	JPanel passwordPanel;
	JEditorPane userPane;
	JEditorPane passwordPane;
	JButton login;
	
	public LoginClass() {
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
		
		JPanel usernameLabel = new JPanel();
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
		
		JPanel passwordLabelPanel = new JPanel();
		passwordLabelPanel.setSize(120,100);
		passwordLabelPanel.setLocation(150, 240);
		passwordLabelPanel.add(passwordLabel);
		
		
		JButton back = new JButton("Back");
		JPanel backPanel = new JPanel();
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
	
	class LoginActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Library IU = new Library();
				System.out.println(IU.attemptLogin(userPane.getText(), passwordPane.getText()));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	class BackActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Window w = new Window();
			frame.dispose();
		}
	}
}
