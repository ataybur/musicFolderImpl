package com.ataybur.folderImpl.utils;

import java.awt.Dimension;

import javax.inject.Singleton;
import javax.swing.JScrollPane;

@Singleton
public class FolderPane extends JScrollPane {

	private static final long serialVersionUID = -4524475641446002556L;

	public FolderPane() {
		super();
		setPreferredSize(new Dimension(375, 100));
	}

}
