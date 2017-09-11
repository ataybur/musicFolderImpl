package com.ataybur.folderImpl.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

import org.apache.tika.metadata.Metadata;

public class MapToPojo {
	private Metadata metadata;
	
	public MapToPojo(Metadata metadata) {
		this.metadata = metadata;
	}
	
	public Mp3 toMp3() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Mp3 mp3 = new Mp3();
		String[] metadataNames = metadata.names();
		for (String name : metadataNames) {
			System.out.println(name + ": " + metadata.get(name));
			Field field = findField(name);
			String setterName = getSetterName(field);
			Method method = mp3.getClass().getMethod(setterName, String.class);
			method.invoke(mp3, metadata.get(name));
		}
		return mp3;
	}
	
	private Field findField(String fieldName){
		Field field = null;
		for(Field fieldItem : Mp3.class.getDeclaredFields()){
			MapField mapField = fieldItem.getAnnotation(MapField.class);
			if(mapField != null && mapField.key() != null && fieldName != null){
				if(mapField.key().equalsIgnoreCase(fieldName)){
					field = fieldItem;
				}
			}
		}
		return field;
	}
	
	private String getSetterName(Field field){
		String fieldName = field.getName();
		String firstLetter = fieldName.substring(0,1);
		String remain = fieldName.substring(1);
		String setterName = "set"+firstLetter.toUpperCase(Locale.ENGLISH)+remain;
		return setterName;
		
	}
}
