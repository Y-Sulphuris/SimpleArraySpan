package com.ydo4ki.simplespan;

import java.util.Arrays;

import static com.ydo4ki.simplespan.Span2D.flat_index;

/**
 * @since 4/3/2025 8:10 PM
 * @author Sulphuris
 */
public final class Span2DShort extends span_2D<short[]> {
	
	private Span2DShort(short[] array, int width, int height) {
		super(array, width, height);
	}
	
	@Override
	public Span2DShort clone() {
		return new Span2DShort(array.clone(), width, height);
	}
	
	public Span2DShort(int width, int height) {
		this(width, height, (short)0);
	}
	
	public Span2DShort(int width, int height, short defaultValue) {
		this(newArray(width, height, defaultValue), width, height);
	}
	
	public static Span2DShort wrap(short[] array, int width, int height) {
		wrapCheck(array.length, width, height);
		return new Span2DShort(array, width, height);
	}
	
	public short get(int x, int y) {
		return get(array, width, height, x, y);
	}
	
	public void set(int x, int y, short val) {
		set(array, width, height, x, y, val);
	}
	
	public static short[] newArray(int width, int height) {
		return newArray(width, height, (short)0);
	}
	
	public static short[] newArray(int width, int height, short defaultValue) {
		short[] array = new short[width * height];
		if (defaultValue != 0) {
			Arrays.fill(array, defaultValue);
		}
		return array;
	}
	
	public static short get(short[] data, int width, int height, int x, int y) {
		return data[flat_index(width, height, x, y)];
	}
	
	public static void set(short[] data, int width, int height, int x, int y, short newValue) {
		data[flat_index(width, height, x, y)] = newValue;
	}
}
