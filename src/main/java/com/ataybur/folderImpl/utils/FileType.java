package com.ataybur.folderImpl.utils;

public enum FileType {
	FILE(GeneralFileList.class), FOLDER(FolderList.class);
	private Class<? extends FileList> fileListType;

	private FileType(Class<? extends FileList> fileListType) {
		this.fileListType = fileListType;
	}

	public Class<? extends FileList> getFileListType() {
		return fileListType;
	}
}
