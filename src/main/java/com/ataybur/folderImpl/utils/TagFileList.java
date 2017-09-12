package com.ataybur.folderImpl.utils;

import java.awt.BorderLayout;
import java.io.File;
import java.util.List;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@Singleton
public class TagFileList implements FileList {

	@Inject
	private TagTablePane tagTablePane;

	@Inject
	private Gui gui;

	@Inject
	@ParserInjection
	@ParserType(value = AudioParser.class)
	private Parser audioParser;

	public void observe(@Observes FileChangeEvent folderChangeEvent) {
		getGui(folderChangeEvent.getFile());
	}

	@Override
	public JScrollPane getGui(File f) {
		JTable fileList;
		try {
			fileList = createFileList(f);
		} catch (Exception e) {
			e.printStackTrace();
			fileList = new JTable(new CustomTableModel());
		}
		gui.remove(tagTablePane);
		tagTablePane.setViewportView(fileList);
		gui.add(tagTablePane, BorderLayout.EAST);
		fileList.setAutoCreateRowSorter(true);
		tagTablePane.updateUI();
		tagTablePane.revalidate();
		tagTablePane.repaint();
		return tagTablePane;
	}

	private JTable createFileList(File f) throws Exception {
		File[] array = f.listFiles(new Mp3FileFilter());
		List<Mp3> list = audioParser.parse(array);
		JTable table = new JTable(new CustomTableModel(list));
		// JList<File> fileList = new JList<File>(array);
		// fileList.setCellRenderer(new FileRenderer());
		// fileList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		// fileList.setVisibleRowCount(-1);
		return table;
	}
}
