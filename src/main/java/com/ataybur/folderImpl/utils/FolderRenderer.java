package com.ataybur.folderImpl.utils;

import java.awt.Component;
import java.io.File;

import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.filechooser.FileSystemView;

public class FolderRenderer extends DefaultListCellRenderer {

	private static final long serialVersionUID = -674690760879240303L;

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		boolean isParentFile = value instanceof ParentFile;
		Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		JLabel l = (JLabel) c;
		File f = (File) value;
		if (isParentFile) {
			l.setText("..");
			File file = FileSystemView.getFileSystemView().getHomeDirectory();
			Icon icon = FileSystemView.getFileSystemView().getSystemIcon(file);
			l.setIcon(icon);
		} else {
			l.setText(f.getName());
			l.setIcon(FileSystemView.getFileSystemView().getSystemIcon(f));
		}
		return l;
	}

}