package library;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import library.StatusWindow.BackActionListener;

public class Search {
	JFrame frame;
	JEditorPane searchPane;
	JPanel searchPanel;
	JLabel enterLabel;
	JButton searchButton;
	public Search() throws FileNotFoundException {
		searchButton = new JButton("Search");
		enterLabel = new JLabel("Enter the title you wish to search for:");
		searchPanel = new JPanel();
		searchPane = new JEditorPane();
		searchPanel.setSize(600,600);
		
		searchPanel.add(searchButton);
		searchPanel.add(enterLabel);
		searchPanel.add(searchPane);
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        frame.add(searchPanel);
        
        
        frame.getContentPane().setLayout(null);
        
        
        searchButton.addActionListener(new searchActionListener());
        
        
		
	}
	
	class searchActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Search test = new Search(searchPane.getText());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();
		}
	}
	
	public Search(String title) throws FileNotFoundException {
	
		
		File newFile = new File("C:\\Users\\ndlom\\eclipse-workspace\\Final Projectv2\\AllFiles\\" + title+ ".txt");
		 Scanner r = new Scanner(newFile);
		 
		 String occupation = r.nextLine();
		 String name = r.nextLine();
   	     String author = r.nextLine();
   	     String description = r.nextLine();
         String currentRenter = r.nextLine();
         String yearWritten =r.nextLine();
         String bookID = r.nextLine();
         String historyOfRenters = r.nextLine();
         String checkoutDate = r.nextLine();
         String unused = r.nextLine();
         String overdraftFee = r.nextLine();
        
        r.close();
        
        JLabel nameOfBook = new JLabel(name);
        JLabel authorOfBook = new JLabel(author);
        JLabel descOfBook = new JLabel(description);
        JLabel currentRenterOfBook = new JLabel(currentRenter);
        JLabel year = new JLabel(yearWritten);
        JLabel IDOfBook = new JLabel(bookID);
        JLabel returnDateOfBook = new JLabel(unused);
        JLabel feeOfBook = new JLabel(name);
        
        JPanel totalPanel = new JPanel();
        totalPanel.add(nameOfBook);
        totalPanel.add(authorOfBook);
        totalPanel.add(descOfBook);
        totalPanel.add(currentRenterOfBook);
        totalPanel.add(year);
        totalPanel.add(IDOfBook);
        totalPanel.add(returnDateOfBook);
        totalPanel.add(feeOfBook);
        
        totalPanel.setSize(600, 600);
        
        frame = new JFrame();
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        frame.add(totalPanel);
        
        
        frame.getContentPane().setLayout(null);
        JButton back = new JButton("Back");
		JPanel backPanel = new JPanel();
		backPanel.setSize(75,100);
		backPanel.setLocation(5, 520);
		backPanel.add(back);
		frame.add(backPanel);
		frame.setVisible(true);
		
		back.addActionListener(new BackActionListener());
		
		
	}
	
	class BackActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			StudentGUI test = new StudentGUI();
			frame.dispose();
		}
	}
        
	}


