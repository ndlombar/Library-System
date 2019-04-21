package library;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Window;
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

public class DeleteWindow {
	JFrame frame;
	JLabel userLabel;
	JLabel passwordLabel;
	JPanel userPanel;
	JPanel passwordPanel;
	JEditorPane userPane;
	JEditorPane passwordPane;
	JButton delete;
	
	public DeleteWindow() {
		frame = new JFrame("Delete Book Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(600, 600);
		
		//Instantiate new labels, buttons, panes, and panels
		userLabel = new JLabel("Enter book name you want to delete:");
		userPanel = new JPanel();
		userPane = new JEditorPane();
		delete = new JButton("Delete");
		
		JPanel usernameLabel = new JPanel();
		usernameLabel.setSize(250, 105);
		usernameLabel.setLocation(0, 200);
		usernameLabel.add(userLabel);
		usernameLabel.add(delete);
		
		//Set size and location of userPanel
		userPanel.setSize(100, 40);
		userPanel.setLocation(250, 198);
		
		//userPanel.add(userLabel);
		userPanel.add(userPane);
		
		
		
		JButton back = new JButton("Back");
		JPanel backPanel = new JPanel();
		backPanel.setSize(75,100);
		backPanel.setLocation(5, 520);
		backPanel.add(back);
		
		//Add action listener to delete button
		delete.addActionListener(new DeleteActionListener());
		back.addActionListener(new BackActionListener());
		
		frame.getContentPane().setLayout(null);
		frame.add(userPanel);
		frame.add(usernameLabel);
		frame.add(backPanel);

		JPanel newPanel = new JPanel();
		newPanel.setLocation(300, 500);
		newPanel.setSize(600, 600);
	
		frame.add(newPanel);
		frame.setVisible(true);
		
		
	}
	
	class DeleteActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Librarian hera = new Librarian("Herald", "admin123");
				
				hera.deleteBook(userPane.getText());
				
				
				
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
			BooksGUI test = new BooksGUI();
			frame.dispose();
		}
	}
}
