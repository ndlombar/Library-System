package library;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckOutClass {
	JFrame frame;
	JEditorPane bookTitlePane;
	JEditorPane usernamePane;
	JLabel username;
	JLabel bookTitle;
	JButton checkinButton;
	JButton back;
	JPanel backPanel;
	JPanel bookTitlePanel;
	JPanel usernamePanel;
	JPanel checkinPanel;
	JPanel usernameLabelPanel;
	JPanel bookTitleLabelPanel;
	
	public CheckOutClass() {
		frame = new JFrame("Checkin Book");
		frame.setSize(600, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		username = new JLabel("Enter your username: ");
		usernameLabelPanel = new JPanel();
		usernameLabelPanel.add(username);
		usernameLabelPanel.setSize(130,50);
		usernameLabelPanel.setLocation(115, 252);
		
		usernamePane = new JEditorPane();
		usernamePanel = new JPanel();
		usernamePanel.add(usernamePane);
		usernamePanel.setSize(100,50);
		usernamePanel.setLocation(250, 250);
		
		bookTitle = new JLabel("Enter the title of your book: ");
		bookTitleLabelPanel = new JPanel();
		bookTitleLabelPanel.add(bookTitle);
		bookTitleLabelPanel.setSize(160, 80);
		bookTitleLabelPanel.setLocation(84, 300);
		
		bookTitlePane = new JEditorPane();
		bookTitlePanel = new JPanel();
		bookTitlePanel.add(bookTitlePane);
		bookTitlePanel.setSize(100,30);
		bookTitlePanel.setLocation(250, 300);
		
		checkinButton = new JButton("Check-out");
		checkinPanel = new JPanel();
		checkinPanel.add(checkinButton);
		checkinPanel.setSize(100,100);
		checkinPanel.setLocation(250, 330);
		
		back = new JButton("Back");
		backPanel = new JPanel();
		backPanel.setSize(75,100);
		backPanel.setLocation(5, 520);
		backPanel.add(back);
		
		checkinButton.addActionListener(new CheckInActionListener());
		back.addActionListener(new BackActionListener());
		
		frame.getContentPane().setLayout(null);
		frame.add(usernameLabelPanel);
		frame.add(usernamePanel);
		frame.add(bookTitleLabelPanel);
		frame.add(bookTitlePanel);
		frame.add(checkinPanel);
		frame.add(backPanel);
		frame.setVisible(true);
		
	}
	
	class CheckInActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Book b = new Book();
			try {
				b.checkOutBook(bookTitlePane.getText(), usernamePane.getText());
				JLabel incorrect = new JLabel("Book successfully checked out!");
				JPanel incorrectPanel = new JPanel();
				incorrectPanel.add(incorrect);
				incorrectPanel.setSize(300,100);
				incorrectPanel.setLocation(120, 180);
				frame.add(incorrectPanel);
				frame.setVisible(true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	class BackActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			StudentGUI g = new StudentGUI();
			frame.dispose();
		}
	}
}
