package com.ataybur.folderImpl;

import java.io.File;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.swing.JFrame;

import org.jboss.weld.environment.se.events.ContainerInitialized;

import com.ataybur.folderImpl.utils.FileList;
import com.ataybur.folderImpl.utils.FileListInjector;
import com.ataybur.folderImpl.utils.FileListType;
import com.ataybur.folderImpl.utils.FileType;
import com.ataybur.folderImpl.utils.FolderChangeEvent;
import com.ataybur.folderImpl.utils.Gui;
import com.ataybur.folderImpl.utils.Parser;
import com.ataybur.folderImpl.utils.ParserInjection;
import com.ataybur.folderImpl.utils.ParserType;

@ApplicationScoped
public class App2 {

	@Inject
	private MainFrame frame;

	@Inject
	@FileListInjector
	@FileListType(value = FileType.FOLDER)
	private FileList folderFileList;

	@Inject
	@FileListInjector
	@FileListType(value = FileType.FILE)
	private FileList generalFileList;
	
	@Inject
	private Event<FolderChangeEvent> event;
	

	
	@Produces
	@FileListInjector
	public FileList fileList(@Any Instance<FileList> instance, InjectionPoint injectionPoint) {
		Annotated annotated = injectionPoint.getAnnotated();
		FileListType bankTypeAnnotation = annotated.getAnnotation(FileListType.class);
		Class<? extends FileList> bankType = bankTypeAnnotation.value().getFileListType();
		return instance.select(bankType).get();
	}

	@Produces
	@ParserInjection
	public Parser parser(@Any Instance<Parser> instance, InjectionPoint injectionPoint) {
		Annotated annotated = injectionPoint.getAnnotated();
		ParserType bankTypeAnnotation = annotated.getAnnotation(ParserType.class);
		Class<? extends Parser> type = bankTypeAnnotation.value();
		return instance.select(type).get();
	}

	public void start(@Observes ContainerInitialized startEvent) {

		setUpLookAndFeel();
		startEventLoop(new Runnable() {
			public void run() {
				//
				// File f = new File(System.getProperty("user.home"));
				File f = new File("C:\\Users\\Burak\\Desktop\\Sezen Aksu\\");
				
				FolderChangeEvent fileChangeEvent = new FolderChangeEvent(f);
				event.fire(fileChangeEvent);

				frame.setVisible(true);

			}
		});

	}

	private void startEventLoop(final Runnable callback) {
		/* Create and display the form */
		java.awt.EventQueue.invokeLater(callback);
	}

	private void setUpLookAndFeel() {
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting
		// code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.
		 * html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>
	}
}
