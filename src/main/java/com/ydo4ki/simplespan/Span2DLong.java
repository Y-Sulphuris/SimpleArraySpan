package com.ydo4ki.simplespan;

import java.util.Arrays;

import static com.ydo4ki.simplespan.Span2D.flat_index;

/**
 * @since 4/3/2025 8:10 PM
 * @author Sulphuris
 */
public final class Span2DLong extends span_2D<long[]> {
	
	private Span2DLong(long[] array, int width, int height) {
		super(array, width, height);
	}
	
	@Override
	public Span2DLong clone() {
		return new Span2DLong(array.clone(), width, height);
	}
	
	public Span2DLong(int width, int height) {
		this(width, height, (long)0);
	}
	
	public Span2DLong(int width, int height, long defaultValue) {
		this(newArray(width, height, defaultValue), width, height);
	}
	
	public static Span2DLong wrap(long[] array, int width, int height) {
		wrapCheck(array.length, width, height);
		return new Span2DLong(array, width, height);
	}
	
	public long get(int x, int y) {
		return get(array, width, height, x, y);
	}
	
	public void set(int x, int y, long val) {
		set(array, width, height, x, y, val);
	}
	
	public static long[] newArray(int width, int height) {
		return newArray(width, height, (long)0);
	}
	
	public static long[] newArray(int width, int height, long defaultValue) {
		long[] array = new long[width * height];
		if (defaultValue != 0) {
			Arrays.fill(array, defaultValue);
		}
		return array;
	}
	
	public static long get(long[] data, int width, int height, int x, int y) {
		return data[flat_index(width, height, x, y)];
	}
	
	public static void set(long[] data, int width, int height, int x, int y, long newValue) {
		data[flat_index(width, height, x, y)] = newValue;
	}
}
