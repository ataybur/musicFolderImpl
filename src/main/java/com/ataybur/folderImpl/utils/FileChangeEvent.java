package com.ataybur.folderImpl.utils;

import java.io.File;

public class FileChangeEvent {
	private File file;

	public FileChangeEvent(File file) {
		super();
		this.file = file;
	}

	public File getFile() {
		return file;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileChangeEvent other = (FileChangeEvent) obj;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FileChangeEvent [file=" + file + "]";
	}

}
