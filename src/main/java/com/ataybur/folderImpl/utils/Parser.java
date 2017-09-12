package com.ataybur.folderImpl.utils;

import java.io.File;
import java.util.List;

public interface Parser {
	public String parse(File file) throws Exception;

	public List<Mp3> parse(File[] fileArray) throws Exception;
}
