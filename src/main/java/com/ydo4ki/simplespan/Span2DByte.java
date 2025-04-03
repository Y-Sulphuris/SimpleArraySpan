package com.ydo4ki.simplespan;

import java.util.Arrays;

import static com.ydo4ki.simplespan.Span2D.flat_index;

/**
 * @since 4/3/2025 8:10 PM
 * @author Sulphuris
 */
public final class Span2DByte extends span_2D<byte[]> {
	
	private Span2DByte(byte[] array, int width, int height) {
		super(array, width, height);
	}
	
	@Override
	public Span2DByte clone() {
		return new Span2DByte(array.clone(), width, height);
	}
	
	public Span2DByte(int width, int height) {
		this(width, height, (byte)0);
	}
	
	public Span2DByte(int width, int height, byte defaultValue) {
		this(newArray(width, height, defaultValue), width, height);
	}
	
	public static Span2DByte wrap(byte[] array, int width, int height) {
		wrapCheck(array.length, width, height);
		return new Span2DByte(array, width, height);
	}
	
	public byte get(int x, int y) {
		return get(array, width, height, x, y);
	}
	
	public void set(int x, int y, byte val) {
		set(array, width, height, x, y, val);
	}
	
	public static byte[] newArray(int width, int height) {
		return newArray(width, height, (byte)0);
	}
	
	public static byte[] newArray(int width, int height, byte defaultValue) {
		byte[] array = new byte[width * height];
		if (defaultValue != 0) {
			Arrays.fill(array, defaultValue);
		}
		return array;
	}
	
	public static byte get(byte[] data, int width, int height, int x, int y) {
		return data[flat_index(width, height, x, y)];
	}
	
	public static void set(byte[] data, int width, int height, int x, int y, byte newValue) {
		data[flat_index(width, height, x, y)] = newValue;
	}
}
