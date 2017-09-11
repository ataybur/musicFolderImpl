package com.ataybur.folderImpl;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.swing.JFrame;

import com.ataybur.folderImpl.utils.AbstractMainFrame;
import com.ataybur.folderImpl.utils.Gui;

public class MainFrame extends AbstractMainFrame {

	private static final long serialVersionUID = -7331478299805990719L;
	
	@Inject
	private Gui gui;
	
	public MainFrame() {
		super("File List");
	}
	
	@PostConstruct
	private void init(){
		setContentPane(gui);
		pack();
		setLocationByPlatform(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
