package com.ataybur.folderImpl.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AudioParser {
	public static String parse(File file) throws IOException, SAXException, TikaException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		InputStream input = new FileInputStream(file);
		ContentHandler handler = new DefaultHandler();
		Metadata metadata = new Metadata();
		Parser parser = new Mp3Parser();
		ParseContext parseCtx = new ParseContext();
		parser.parse(input, handler, metadata, parseCtx);
		input.close();

		MapToPojo mapToMp3 = new MapToPojo(metadata);
		Mp3 mp3 = mapToMp3.toMp3();
		return new Mp3PrettyPrinter(mp3).prettyPrint();
	}
}
