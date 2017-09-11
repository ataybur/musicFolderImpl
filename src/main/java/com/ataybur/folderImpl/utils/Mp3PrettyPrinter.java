package com.ataybur.folderImpl.utils;

import java.lang.reflect.Field;

public class Mp3PrettyPrinter {
	private Mp3 mp3;

	public Mp3PrettyPrinter(Mp3 mp3) {
		this.mp3 = mp3;
	}

	public String prettyPrint() throws IllegalArgumentException, IllegalAccessException {
		StringBuilder stringBuilder = new StringBuilder();
		Field[] fieldArray = this.mp3.getClass().getDeclaredFields();
		for (Field field : fieldArray) {
			String key = field.getAnnotation(MapField.class).key();
			 field.setAccessible(true);
			Object valueObject = field.get(this.mp3);
			String value;
			if (valueObject != null) {
				value = valueObject.toString();
			} else {
				value = "";
			}
			stringBuilder //
					.append(key + "= " + value) //
					.append(System.lineSeparator());
		}
		return stringBuilder.toString();
	}
}
