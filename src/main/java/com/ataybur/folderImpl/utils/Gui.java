package com.ataybur.folderImpl.utils;

import java.awt.BorderLayout;

import javax.inject.Singleton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@Singleton
public class Gui extends JPanel {

	private static final long serialVersionUID = -4630041311873637032L;

	public Gui() {
		super(new BorderLayout());
		setBorder(new EmptyBorder(3, 3, 3, 3));
	}
}
