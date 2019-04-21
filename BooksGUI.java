package library;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class BooksGUI {
	JFrame frame;

	
	public BooksGUI() {
		frame = new JFrame("Manage books");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(600, 600);
		
		
		JButton add = new JButton("Add Book");
		JPanel addPanel = new JPanel();
		addPanel.setSize(100,100);
		addPanel.setLocation(250, 120);
		addPanel.add(add);
		
		JButton delete = new JButton("Delete Book");
		JPanel deletePanel = new JPanel();
		deletePanel.setSize(200,200);
		deletePanel.setLocation(200, 220);
		deletePanel.add(delete);
		
		JButton mod = new JButton("Modify Book");
		JPanel modPanel = new JPanel();
		modPanel.setSize(200,200);
		modPanel.setLocation(200, 320);
		modPanel.add(mod);
		
		JButton status = new JButton("Book Status");
		JPanel statusPanel = new JPanel();
		statusPanel.setSize(200,200);
		statusPanel.setLocation(200, 420);
		statusPanel.add(status);
		
		
		//Add action listener to login button
		add.addActionListener(new AddActionListener());
		delete.addActionListener(new DeleteActionListener());
		mod.addActionListener(new ModActionListener());
		status.addActionListener(new StatusActionListener());

				
		frame.getContentPane().setLayout(null);
		frame.add(addPanel);
		frame.add(deletePanel);
		frame.add(modPanel);
		frame.add(statusPanel);

	}
			
	class AddActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			AddWindow a = new AddWindow();
			frame.dispose();
		}
	}
	class DeleteActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			DeleteWindow d = new DeleteWindow();
			frame.dispose();
		}
		
	}
	
	class ModActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			ModifyWindow m = new ModifyWindow();
			frame.dispose();
		}
	}
	class StatusActionListener implements ActionListener{
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			StatusWindow test = new StatusWindow();
			frame.dispose();
		}
	}
	
}
