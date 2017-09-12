package com.ataybur.folderImpl.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;

public class ReflectionUtils {
	public static Field findFieldByMapKey(String fieldName) {
		Field field = null;
		for (Field fieldItem : Mp3.class.getDeclaredFields()) {
			MapField mapField = fieldItem.getAnnotation(MapField.class);
			if (mapField != null && mapField.key() != null && fieldName != null) {
				if (mapField.key().equalsIgnoreCase(fieldName)) {
					field = fieldItem;
				}
			}
		}
		return field;
	}

	public static Field findFieldByFieldName(String fieldName) {
		Field field = null;
		for (Field fieldItem : Mp3.class.getDeclaredFields()) {
			if (fieldName != null) {
				if (fieldItem.getName().equalsIgnoreCase(fieldName)) {
					field = fieldItem;
				}
			}
		}
		return field;
	}

	
	public static String getSetterName(Field field) {
		return getMethodName(field, "set");
	}
	
	public static String getGetterName(Field field) {
		return getMethodName(field, "get");
	}
	
	private static String getMethodName(Field field, String preName) {
		String fieldName = field.getName();
		String firstLetter = fieldName.substring(0, 1);
		String remain = fieldName.substring(1);
		String setterName = preName + firstLetter.toUpperCase(Locale.ENGLISH) + remain;
		return setterName;
	}
	
	public static void set(Mp3 mp3, String fieldName, String data) throws Exception {
		Field field = findFieldByMapKey(fieldName);
		String setterName = getSetterName(field);
		Method method = mp3.getClass().getMethod(setterName, String.class);
		method.invoke(mp3, data);
	}
	
	public static String get(Mp3 mp3, String fieldName) throws Exception {
		Field field = ReflectionUtils.findFieldByFieldName(fieldName);
		String getterName = ReflectionUtils.getGetterName(field);
		Method method = mp3.getClass().getMethod(getterName);
		return String.valueOf(method.invoke(mp3));
	}
}
