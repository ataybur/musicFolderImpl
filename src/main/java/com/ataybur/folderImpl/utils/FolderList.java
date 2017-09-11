package com.ataybur.folderImpl.utils;

import java.awt.BorderLayout;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

@Singleton
public class FolderList implements FileList {

	@Inject
	private ListenerFactory listenerFactory;

	@Inject
	private Gui gui;

	@Inject
	private FolderPane folderList;

	@Inject
	private Event<FileChangeEvent> fileEvent;

	public void observe(@Observes FolderChangeEvent folderChangeEvent) {
		getGui(folderChangeEvent.getFile());
		FileChangeEvent fileChangeEvent = new FileChangeEvent(folderChangeEvent.getFile());
		fileEvent.fire(fileChangeEvent);
	}

	@Override
	public JScrollPane getGui(File f) {
		JList<File> fileList = createFileList(f);
		gui.remove(folderList);
		folderList.setViewportView(fileList);
		gui.add(folderList, BorderLayout.WEST);
		folderList.updateUI();
		folderList.revalidate();
		folderList.repaint();
		return folderList;
	}

	private JList<File> createFileList(File f) {
		File[] files = f.listFiles(new FolderFilter());

		LinkedList<File> list = new LinkedList<>(Arrays.asList(files));
		File parentFile = new ParentFile(f.getParent());
		list.addFirst(parentFile);
		// put File objects in the list..
		File[] array = (File[]) list.toArray(new File[list.size()]);
		JList<File> fileList = new JList<File>(array);
		ListSelectionModel listSelectionModel = fileList.getSelectionModel();
		listSelectionModel.addListSelectionListener(listenerFactory.new SharedListSelectionHandler(array));
		// ..then use a renderer
		fileList.setCellRenderer(new FolderRenderer());
		fileList.setVisibleRowCount(9);
		return fileList;
	}
}
