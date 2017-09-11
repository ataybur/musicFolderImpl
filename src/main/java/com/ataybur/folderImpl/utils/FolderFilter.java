package com.ataybur.folderImpl.utils;

import java.io.File;
import java.io.FileFilter;

public class FolderFilter implements FileFilter {

    public boolean accept(File file) {
        return file.isDirectory();
    }
}