package library;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class LoginWindow extends JFrame{
	
	JFrame frame;
	JPanel studentPanel;
	JPanel registerPanel;
	JPanel librarianPanel;
	JButton login;
	JButton librarianLogin;
	JButton register;
	
	public LoginWindow() {
		frame = new JFrame("Library System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setVisible(true);
		frame.setResizable(false);
	
		studentPanel = new JPanel();
		studentPanel.setSize(150,100);
		studentPanel.setLocation(235, 247);
		
		
		login = new JButton("Student Login");
		studentPanel.add(login);
		
		librarianPanel = new JPanel();
		librarianLogin = new JButton("Librarian Login");
		librarianPanel.setSize(150,100);
		librarianPanel.add(librarianLogin);
		librarianPanel.setLocation(235, 283);

		

		registerPanel = new JPanel();
		registerPanel.setSize(100,100);
		registerPanel.setLocation(258, 320);

		register = new JButton("Register");
		register.setBounds(253,300,100,20);
		registerPanel.add(register);


		
		login.addActionListener(new StudentLoginActionListener());		
		librarianLogin.addActionListener(new LibrarianLoginActionListener());
		register.addActionListener(new RegisterActionListener());
		
		frame.getContentPane().setLayout(null);
		frame.add(registerPanel);
		frame.add(librarianPanel);
		frame.add(studentPanel);
	}
	
	
	
	public static void main(String[] args) throws IOException {
		LoginWindow w = new LoginWindow();
	}

	class StudentLoginActionListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			StudentLoginClass c = new StudentLoginClass();
			frame.dispose();
		}
	}
	
	class LibrarianLoginActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			LibrarianLoginClass l = new LibrarianLoginClass();
			frame.dispose();
		}
	}
	
	class RegisterActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			RegisterClass r = new RegisterClass();
			frame.dispose();
			
		}
		
	}

}
