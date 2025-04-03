package com.ydo4ki.simplespan;

import java.util.Arrays;

import static com.ydo4ki.simplespan.Span2D.flat_index;

/**
 * @since 4/3/2025 8:10 PM
 * @author Sulphuris
 */
public final class Span2DBoolean extends span_2D<boolean[]> {
	
	private Span2DBoolean(boolean[] array, int width, int height) {
		super(array, width, height);
	}
	
	@Override
	public Span2DBoolean clone() {
		return new Span2DBoolean(array.clone(), width, height);
	}
	
	public Span2DBoolean(int width, int height) {
		this(width, height, false);
	}
	
	public Span2DBoolean(int width, int height, boolean defaultValue) {
		this(newArray(width, height, defaultValue), width, height);
	}
	
	public static Span2DBoolean wrap(boolean[] array, int width, int height) {
		wrapCheck(array.length, width, height);
		return new Span2DBoolean(array, width, height);
	}
	
	public boolean get(int x, int y) {
		return get(array, width, height, x, y);
	}
	
	public void set(int x, int y, boolean val) {
		set(array, width, height, x, y, val);
	}
	
	public static boolean[] newArray(int width, int height) {
		return newArray(width, height, false);
	}
	
	public static boolean[] newArray(int width, int height, boolean defaultValue) {
		boolean[] array = new boolean[width * height];
		if (defaultValue) {
			Arrays.fill(array, true);
		}
		return array;
	}
	
	public static boolean get(boolean[] data, int width, int height, int x, int y) {
		return data[flat_index(width, height, x, y)];
	}
	
	public static void set(boolean[] data, int width, int height, int x, int y, boolean newValue) {
		data[flat_index(width, height, x, y)] = newValue;
	}
}
