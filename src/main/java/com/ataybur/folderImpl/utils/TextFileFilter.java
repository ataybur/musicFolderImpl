package com.ataybur.folderImpl.utils;

import java.io.File;
import java.io.FileFilter;

public class TextFileFilter implements FileFilter {

    public boolean accept(File file) {
        return file.isFile();
    }
}