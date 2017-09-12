package com.ataybur.folderImpl.utils;

import java.io.File;
import java.io.FileFilter;

public class Mp3FileFilter implements FileFilter {

    public boolean accept(File file) {
        return file.isFile() && file.getName().contains(".mp3");
    }
}