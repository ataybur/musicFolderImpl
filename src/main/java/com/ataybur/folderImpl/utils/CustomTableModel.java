package com.ataybur.folderImpl.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.enterprise.inject.spi.Annotated;
import javax.swing.table.AbstractTableModel;

public class CustomTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -3852781716574103410L;

	private List<Mp3> list;

	private Class<Mp3> clazz;

	private List<Field> modelFieldList;

	public CustomTableModel(List<Mp3> list) {
		super();
		if (list == null) {
			this.list = new ArrayList<>();
		} else {
			this.list = list;
		}
		commonInit();
	}

	public CustomTableModel() {
		super();
		this.list = new ArrayList<>();
		commonInit();
	}

	private void commonInit() {
		this.clazz = Mp3.class;
		this.modelFieldList = Stream //
				.of(this.clazz.getDeclaredFields()) //
				.filter((f) -> f.getAnnotation(ModelField.class) != null) //
				.filter((f) -> f.getAnnotation(ModelField.class).columnNumber() < 7) //
				.sorted((f1, f2) -> Integer.compare(f1.getAnnotation(ModelField.class).columnNumber(),f2.getAnnotation(ModelField.class).columnNumber() )) // 
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
	}

	@Override
	public int getColumnCount() {
		return this.modelFieldList.size();
	}

	@Override
	public int getRowCount() {
		return this.list.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Mp3 mp3 = list.get(arg0);
		String fieldName = modelFieldList.get(arg1).getName();
		String result;
		try {
			result = ReflectionUtils.get(mp3, fieldName);
		} catch (Exception e) {
			result = "";
			e.printStackTrace();
		}
		return result;
	}

	public String getColumnName(int col) {
		return modelFieldList.get(col).getAnnotation(MapField.class).key();
	}

	public Class<String> getColumnClass(int col) {
		if (col == 2) {
			return String.class;
		} else {
			return String.class;
		}
	}
}
