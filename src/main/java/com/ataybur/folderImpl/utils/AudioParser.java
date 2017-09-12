package com.ataybur.folderImpl.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.helpers.DefaultHandler;

public class AudioParser implements com.ataybur.folderImpl.utils.Parser {
	public String parse(File file) throws Exception {
		Mp3 mp3 = parseToMp3(file);
		return new Mp3PrettyPrinter(mp3).prettyPrint();
	}

	public Mp3 parseToMp3(File file) throws Exception {
		InputStream input = new FileInputStream(file);
		ContentHandler handler = new DefaultHandler();
		Metadata metadata = new Metadata();
		Parser parser = new Mp3Parser();
		ParseContext parseCtx = new ParseContext();
		parser.parse(input, handler, metadata, parseCtx);
		input.close();

		MapToPojo mapToMp3 = new MapToPojo(metadata);
		Mp3 mp3 = mapToMp3.toMp3();
		return mp3;
	}

	public List<Mp3> parse(File[] fileArray) {
		FunctionThrowing<File, Mp3> ft = this::parseToMp3;
		return Stream //
				.of(fileArray) //
				.map(ft) //
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
	}
}
