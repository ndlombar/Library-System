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

public class AddWindow {
	JFrame frame;
	JLabel userLabel;
	JLabel authorLabel;
	JLabel descLabel;
	JLabel yrLabel;
	JLabel IDLabel;
	
	JPanel userPanel;
	JPanel authorPanel;
	JPanel descPanel;
	JPanel yrPanel;
	JPanel IDPanel;
	
	JEditorPane userPane;
	JEditorPane authorPane;
	JEditorPane descPane;
	JEditorPane yrPane;
	JEditorPane IDPane;
	JEditorPane feePane;
	
	JButton add;
	
	public AddWindow() {
		frame = new JFrame("Add Book Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(600, 600);
		
		//Instantiate new labels, buttons, panes, and panels
		
		userPanel = new JPanel();
		userPane = new JEditorPane();
		add = new JButton("Add");
		
		JPanel usernameLabel = new JPanel();
		usernameLabel.setSize(250, 105);
		usernameLabel.setLocation(150, 500);
		userLabel = new JLabel("Enter book title:");
		userPanel.add(userLabel);
		usernameLabel.add(add);
		
		
		//Set size and location of userPanel
		userPanel.setSize(600, 100);
		userPanel.setLocation(-40, 50);
		
		//userPanel.add(userLabel);
		userPanel.add(userPane);
		
		
		//
		authorLabel = new JLabel("Enter book author:");
		authorPanel = new JPanel();
		authorPane = new JEditorPane();
		
		JPanel authornameLabel = new JPanel();
		authornameLabel.setSize(110, 105);
		authornameLabel.setLocation(140, 100);
		authornameLabel.add(authorLabel);
		
		//Set size and location of 
		authorPanel.setSize(100, 40);
		authorPanel.setLocation(260, 100);
		
		
		authorPanel.add(authorPane);
		
		
		//
		descLabel = new JLabel("Enter book description:");
		descPanel = new JPanel();
		descPane = new JEditorPane();
		
		JPanel descriptionLabel = new JPanel();
		descriptionLabel.setSize(110, 105);
		descriptionLabel.setLocation(140, 150);
		descriptionLabel.add(descLabel);
		
		//Set size and location of 
		descPanel.setSize(100, 40);
		descPanel.setLocation(260, 150);
		
		
		descPanel.add(descPane);
		
		//
		yrLabel = new JLabel("Enter book year:");
		yrPanel = new JPanel();
		yrPane = new JEditorPane();
		
		JPanel yrLabel = new JPanel();
		yrLabel.setSize(250, 105);
		yrLabel.setLocation(260, 200);
		frame.add(yrLabel);
		
		//Set size and location of 
		yrPanel.setSize(100, 40);
		yrPanel.setLocation(260, 200);
		
		
		yrPanel.add(yrPane);
		
		//
		IDLabel = new JLabel("Enter book ID:");
		IDPanel = new JPanel();
		IDPane = new JEditorPane();
		
		JPanel IDLabel = new JPanel();
		IDLabel.setSize(250, 105);
		IDLabel.setLocation(0, 200);
		IDLabel.add(yrLabel);
		
		//Set size and location of 
		IDPanel.setSize(100, 100);
		IDPanel.setLocation(260, 250);
		
		
		IDPanel.add(IDPane);
		
		//Fee stuff
		
		JPanel feePanel = new JPanel();
		feePane = new JEditorPane();
		JLabel feeLabel = new JLabel("Fee amount:");
		
		JPanel totalFeePanel = new JPanel();
		totalFeePanel.setSize(250, 105);
		totalFeePanel.setLocation(150, 500);
		feePanel.setLocation(170, 300);
		feePanel.add(feeLabel);

		//Set size and location of userPanel
		feePanel.setSize(200, 100);

		
		//userPanel.add(userLabel);
		feePanel.add(feePane);
		
		
		JButton back = new JButton("Back");
		JPanel backPanel = new JPanel();
		backPanel.setSize(75,100);
		backPanel.setLocation(5, 520);
		backPanel.add(back);
		
		//Add action listener to delete button
		add.addActionListener(new AddActionListener());
	    back.addActionListener(new BackActionListener());
		
		frame.getContentPane().setLayout(null);
		frame.add(userPanel);
		frame.add(authorPanel);
		frame.add(descPanel);
		frame.add(yrPanel);
		frame.add(IDPanel);
		frame.add(usernameLabel);
		frame.add(authornameLabel);
		frame.add(descLabel);
		frame.add(yrLabel);
		frame.add(IDLabel);
		frame.add(backPanel);
		frame.add(feePanel);

		JPanel newPanel = new JPanel();
		newPanel.setLocation(260, 300);
		newPanel.setSize(600, 600);
	
		frame.add(newPanel);
		frame.setVisible(true);
		
		
	}

	class AddActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Book add = new Book(userPane.getText(), authorPane.getText(), descPane.getText(),
						"null", yrPane.getText(), IDPane.getText(), "null", "null", "null", feePane.getText());
				
				
				
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
