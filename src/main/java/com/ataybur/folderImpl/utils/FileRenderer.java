package com.ataybur.folderImpl.utils;

import java.awt.Component;
import java.io.File;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;

public class FileRenderer extends DefaultListCellRenderer {

	private static final long serialVersionUID = -4132835067703491146L;
	private Border padBorder = new EmptyBorder(3, 3, 3, 3);

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {

		Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		JLabel l = (JLabel) c;
		File f = (File) value;
		l.setText(f.getName());
		l.setIcon(FileSystemView.getFileSystemView().getSystemIcon(f));
		l.setBorder(padBorder);

		return l;
	}

}