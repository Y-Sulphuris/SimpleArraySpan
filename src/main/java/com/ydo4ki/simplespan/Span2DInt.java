package com.ydo4ki.simplespan;

import java.util.Arrays;

import static com.ydo4ki.simplespan.Span2D.flat_index;

/**
 * @since 4/3/2025 8:10 PM
 * @author Sulphuris
 */
public final class Span2DInt extends span_2D<int[]> {
	
	private Span2DInt(int[] array, int width, int height) {
		super(array, width, height);
	}
	
	@Override
	public Span2DInt clone() {
		return new Span2DInt(array.clone(), width, height);
	}
	
	public Span2DInt(int width, int height) {
		this(width, height, (int)0);
	}
	
	public Span2DInt(int width, int height, int defaultValue) {
		this(newArray(width, height, defaultValue), width, height);
	}
	
	public static Span2DInt wrap(int[] array, int width, int height) {
		wrapCheck(array.length, width, height);
		return new Span2DInt(array, width, height);
	}
	
	public int get(int x, int y) {
		return get(array, width, height, x, y);
	}
	
	public void set(int x, int y, int val) {
		set(array, width, height, x, y, val);
	}
	
	public static int[] newArray(int width, int height) {
		return newArray(width, height, (int)0);
	}
	
	public static int[] newArray(int width, int height, int defaultValue) {
		int[] array = new int[width * height];
		if (defaultValue != 0) {
			Arrays.fill(array, defaultValue);
		}
		return array;
	}
	
	public static int get(int[] data, int width, int height, int x, int y) {
		return data[flat_index(width, height, x, y)];
	}
	
	public static void set(int[] data, int width, int height, int x, int y, int newValue) {
		data[flat_index(width, height, x, y)] = newValue;
	}
}
