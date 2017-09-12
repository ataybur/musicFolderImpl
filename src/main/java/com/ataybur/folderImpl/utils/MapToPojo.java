package com.ataybur.folderImpl.utils;

import org.apache.tika.metadata.Metadata;

public class MapToPojo {
	private Metadata metadata;

	public MapToPojo(Metadata metadata) {
		this.metadata = metadata;
	}

	public Mp3 toMp3() throws Exception {
		Mp3 mp3 = new Mp3();
		String[] metadataNames = metadata.names();
		for (String name : metadataNames) {
			System.out.println(name + ": " + metadata.get(name));
			ReflectionUtils.set(mp3, name, metadata.get(name));
		}
		return mp3;
	}

}
