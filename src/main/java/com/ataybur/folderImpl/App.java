package com.ataybur.folderImpl;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.Icon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

public class App {

	private static void createAndShowGUI() {
		// Create and set up the window.
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel gui = new JPanel(new BorderLayout());

		// Add the ubiquitous "Hello World" label.
		JFileChooser chooser = new JFileChooser();
		chooser.setMultiSelectionEnabled(false);
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int option = chooser.showOpenDialog(frame);
		if (option == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
//			JList<File> fileList = new JList<File>();
			if (file.isDirectory()) {
				File[] files = file.listFiles();

				for (File fileItem : files) {
					Icon ico = FileSystemView.getFileSystemView().getSystemIcon(fileItem);
					// Image image = ((ImageIcon) ico).getImage();

					// ImageIcon icon = new ImageIcon(img);
//					JLabel label = new JLabel(ico);
					gui.add(new JLabel(ico));
				}

				// Icon ico =
				// FileSystemView.getFileSystemView().getSystemIcon(file);
				//// Image image = ((ImageIcon) ico).getImage();
				//
				// // ImageIcon icon = new ImageIcon(img);
				// JLabel label2 = new JLabel(ico);
				// frame.getContentPane().add(label2);
			}
		}
		// Display the window.
		frame.setContentPane(gui);
		  frame.pack();
          frame.setLocationByPlatform(true);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});

	}

}
