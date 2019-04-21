package library;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StudentGUI {

	JFrame frame;

	
	public StudentGUI() {
		frame = new JFrame("Student View");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(600, 600);
		
		
		JButton search = new JButton("Search Book");
		JPanel addPanel = new JPanel();
		addPanel.setSize(120,100);
		addPanel.setLocation(240, 120);
		addPanel.add(search);
		search.addActionListener(new SearchActionListener());
		JButton checkout = new JButton("Checkout Book");
		JPanel deletePanel = new JPanel();
		deletePanel.setSize(200,200);
		deletePanel.setLocation(200, 220);
		deletePanel.add(checkout);
		
		JButton checkin = new JButton("Checkin Book");
		JPanel modPanel = new JPanel();
		modPanel.setSize(200,200);
		modPanel.setLocation(200, 320);
		modPanel.add(checkin);
		
		JButton status = new JButton("Book Status");
		JPanel statusPanel = new JPanel();
		statusPanel.setSize(200,200);
		statusPanel.setLocation(200, 420);
		statusPanel.add(status);
		
		
		checkin.addActionListener(new CheckinActionListener());
		checkout.addActionListener(new CheckoutActionListener());
		status.addActionListener(new StatusActionListener());
		
		frame.getContentPane().setLayout(null);
		frame.add(addPanel);
		frame.add(deletePanel);
		frame.add(modPanel);
		frame.add(statusPanel);
		
	}
	
	class SearchActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Search test = new Search();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();
		}
		
	}
	
	class CheckinActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			CheckInClass c = new CheckInClass();
			frame.dispose();
			
		}
		
	}
	class CheckoutActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			CheckOutClass c = new CheckOutClass();
			frame.dispose();
		}
	}
	
	class StatusActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			StatusWindowStudent g = new StatusWindowStudent();
			frame.dispose();
			
		}
		
	}
	
	public static void main(String[] args) {
		StudentGUI s = new StudentGUI();
	}
	
}
