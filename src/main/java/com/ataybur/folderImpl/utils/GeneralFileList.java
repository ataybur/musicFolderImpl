package com.ataybur.folderImpl.utils;

import java.awt.BorderLayout;
import java.io.File;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

@Singleton
public class GeneralFileList implements FileList {
	
	@Inject
	private ListenerFactory listenerFactory;
	
	@Inject
	private FilePane generalFileList;
	
	@Inject
	private Gui gui;
//	FilePane fileList = generalFileList.getGui(f,fileList);

//	gui.add(folderListInstance.get(), BorderLayout.WEST);
	
	
	public void observe(@Observes FileChangeEvent folderChangeEvent){
		getGui(folderChangeEvent.getFile());
	}
	
	@Override
	public JScrollPane getGui(File f) {
		JList<File> fileList = createFileList(f);
		gui.remove(generalFileList);
		generalFileList.setViewportView(fileList);
		gui.add(generalFileList, BorderLayout.CENTER);
		generalFileList.updateUI();
		generalFileList.revalidate();
		generalFileList.repaint();
//		panel.setViewportView(fileList);
		return generalFileList;
	}
	
	private JList<File> createFileList(File f){
		File[] array = f.listFiles(new TextFileFilter());
		JList<File> fileList = new JList<File>(array);
		ListSelectionModel listSelectionModel = fileList.getSelectionModel();
		listSelectionModel.addListSelectionListener(listenerFactory.new SharedListSelectionHandler(array));
		fileList.setCellRenderer(new FileRenderer());
		fileList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		fileList.setVisibleRowCount(-1);
		return fileList;
	}
}
