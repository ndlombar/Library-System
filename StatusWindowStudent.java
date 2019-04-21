package library;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class StatusWindowStudent {
	JFrame frame;
	JPanel panel;
	JButton back;
	JPanel backPanel;
	
	public StatusWindowStudent() {
		panel = new JPanel();

		frame = new JFrame("Status Window");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(600, 600);
		panel.setSize(600, 600);
		panel.setLocation(200, 200);
		frame.add(panel);
		frame.getContentPane().setLayout(new GridBagLayout());
		
		back = new JButton("Back");
		backPanel = new JPanel();
		backPanel.setSize(75,100);
		backPanel.setLocation(5, 520);
		backPanel.add(back);
		back.addActionListener(new BackActionListener());
		
		frame.add(backPanel);
		try {
			Library IU = new Library();
			
			JLabel newLabel = new JLabel("Currently rented books, sorted by closest due date:");
			JPanel newPanel = new JPanel();
			
			
		    newPanel.setLocation(0, 50);
			newPanel.setSize(600, 600);
			newPanel.add(newLabel);
			frame.add(newPanel);
			
			ArrayList<String> temp = IU.returnCurrentRentals();
			int length = temp.size();
			
			for(int i = 0; i < length; i++) {
			JLabel iu = new JLabel(temp.get(i));
			JPanel ourPanel = new JPanel();

		    ourPanel.setLocation(0, (1+i) * 100);
		    
			ourPanel.setSize(600, 600);
			ourPanel.add(iu);
			
			frame.add(ourPanel);
			
			System.out.println(temp.get(i));
			
			}
			frame.setVisible(true);
			
			
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	class BackActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			StudentGUI w = new StudentGUI();
			frame.dispose();
		}
	}
	
	public static void main(String[] args) {
		StatusWindowStudent g = new StatusWindowStudent();
	}
	
}