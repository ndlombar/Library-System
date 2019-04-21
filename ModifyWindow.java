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

public class ModifyWindow {
	JFrame frame;
	JLabel userLabel;
	JLabel passwordLabel;
	JPanel userPanel;
	JPanel passwordPanel;
	JEditorPane userPane;
	JEditorPane passwordPane;
	JButton delete;
	JEditorPane field;
	JEditorPane modify;
	
	public ModifyWindow() {
		frame = new JFrame("Modify Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(600, 600);
		
		delete = new JButton("Modify");
		JPanel confirm = new JPanel();
		confirm.add(delete);
		confirm.setLocation(250, 500);
		confirm.setSize(100,100);
		frame.add(confirm);
		
		//Instantiate new labels, buttons, panes, and panels
		userLabel = new JLabel("Enter title you'd like to modify:");
		userPanel = new JPanel();
		userPane = new JEditorPane();
		
		
		JPanel usernameLabel = new JPanel();
		usernameLabel.setSize(250, 105);
		usernameLabel.setLocation(0, 200);
		usernameLabel.add(userLabel);
		
		
		//Set size and location of userPanel
		userPanel.setSize(100, 40);
		userPanel.setLocation(250, 198);
		
		//userPanel.add(userLabel);
		userPanel.add(userPane);
		
		////////////////////////////
		userLabel = new JLabel("Enter field you'd like to modify:");
		field = new JEditorPane();
		

		usernameLabel.setSize(250, 105);
		usernameLabel.setLocation(0, 200);
		usernameLabel.add(userLabel);
		
		//Set size and location of userPanel
		userPanel.setSize(100, 100);
		userPanel.setLocation(250, 198);
		
		//userPanel.add(userLabel);
		userPanel.add(field);
		///////////
		userLabel = new JLabel("Enter the information:");
		modify = new JEditorPane();
		

		usernameLabel.setSize(250, 105);
		usernameLabel.setLocation(0, 200);
		usernameLabel.add(userLabel);
		
		//Set size and location of userPanel
		userPanel.setSize(100, 100);
		userPanel.setLocation(250, 198);
		
		//userPanel.add(userLabel);
		userPanel.add(modify);
		
		
		
		///////////
		JButton back = new JButton("Back");
		JPanel backPanel = new JPanel();
		backPanel.setSize(75,100);
		backPanel.setLocation(5, 520);
		backPanel.add(back);
		
		//Add action listener to delete button
		back.addActionListener(new BackActionListener());
		delete.addActionListener(new ModifyActionListener());
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
	

	
	class BackActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
		    BooksGUI test = new BooksGUI();
			frame.dispose();
		}
	}
	
	class ModifyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				Librarian hera = new Librarian("Herald", "admin123");
				hera.modifyBook(userPane.getText(), field.getText(), modify.getText());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    BooksGUI test = new BooksGUI();
			frame.dispose();
		}
	}
}