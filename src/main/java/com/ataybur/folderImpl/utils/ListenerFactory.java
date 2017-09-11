package com.ataybur.folderImpl.utils;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

public class ListenerFactory {
	
	@Inject
	private AbstractMainFrame mainFrame;
	
	@Inject
	private Event<FolderChangeEvent> event;
	
	public class SharedListSelectionHandler implements ListSelectionListener {
		private File[] fileArray;

		public SharedListSelectionHandler(File[] fileArray) {
			super();
			this.fileArray = fileArray;
		}



		public void valueChanged(ListSelectionEvent arg0) {
			ListSelectionModel lsm = (ListSelectionModel) arg0.getSource();
			int firstIndex = arg0.getFirstIndex();
			int lastIndex = arg0.getLastIndex();
			boolean isAdjusting = arg0.getValueIsAdjusting();
			System.out.println("Event for indexes " + firstIndex + " - " + lastIndex + "; isAdjusting is " + isAdjusting
					+ "; selected indexes:");

			if (lsm.isSelectionEmpty()) {
				System.out.println(" <none>");
			} else {
				// Find out which indexes are selected.
				int minIndex = lsm.getMinSelectionIndex();
				int maxIndex = lsm.getMaxSelectionIndex();
				for (int i = minIndex; i <= maxIndex; i++) {
					if (lsm.isSelectedIndex(i)) {
						System.out.println(" " + i);
						File file = this.fileArray[i];
						if(file.isFile()){
						try {
							String str = AudioParser.parse(file);
							if (Desktop.isDesktopSupported()) {
								Desktop desktop = Desktop.getDesktop();
//								Process p = Runtime.getRuntime().exec(file.getAbsolutePath());
								desktop.open(file);
					            // now enable buttons for actions that are supported.
					        }
							JOptionPane.showMessageDialog(mainFrame, str);
						} catch (NoSuchMethodException | SecurityException | IllegalAccessException
								| IllegalArgumentException | InvocationTargetException | IOException | SAXException
								| TikaException e) {
							e.printStackTrace();
						}
						} else if (file.isDirectory()){
							FolderChangeEvent fileChangeEvent = new FolderChangeEvent(file);
							event.fire(fileChangeEvent);
						}
						break;
					}
				}
			}
			System.out.println(System.lineSeparator());
		}

	}
}
