package com.ydo4ki.simplespan;

import java.util.Arrays;

import static com.ydo4ki.simplespan.Span2D.flat_index;

/**
 * @since 4/3/2025 8:33 PM
 * @author Sulphuris
 */
public class Span2DChar extends span_2D<char[]> {
	
	private Span2DChar(char[] array, int width, int height) {
		super(array, width, height);
	}
	
	@Override
	public Span2DChar clone() {
		return new Span2DChar(array.clone(), width, height);
	}
	
	public Span2DChar(int width, int height) {
		this(width, height, (char)0);
	}
	
	public Span2DChar(int width, int height, char defaultValue) {
		this(newArray(width, height, defaultValue), width, height);
	}
	
	public static Span2DChar wrap(char[] array, int width, int height) {
		wrapCheck(array.length, width, height);
		return new Span2DChar(array, width, height);
	}
	
	public char get(int x, int y) {
		return get(array, width, height, x, y);
	}
	
	public void set(int x, int y, char val) {
		set(array, width, height, x, y, val);
	}
	
	public static char[] newArray(int width, int height) {
		return newArray(width, height, (char)0);
	}
	
	public static char[] newArray(int width, int height, char defaultValue) {
		char[] array = new char[width * height];
		if (defaultValue != 0) {
			Arrays.fill(array, defaultValue);
		}
		return array;
	}
	
	public static char get(char[] data, int width, int height, int x, int y) {
		return data[flat_index(width, height, x, y)];
	}
	
	public static void set(char[] data, int width, int height, int x, int y, char newValue) {
		data[flat_index(width, height, x, y)] = newValue;
	}
}

