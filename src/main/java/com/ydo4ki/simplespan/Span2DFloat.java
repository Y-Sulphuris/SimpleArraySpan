package com.ydo4ki.simplespan;

import java.util.Arrays;

import static com.ydo4ki.simplespan.Span2D.flat_index;

/**
 * @since 4/3/2025 8:10 PM
 * @author Sulphuris
 */
public final class Span2DFloat extends span_2D<float[]> {
	
	private Span2DFloat(float[] array, int width, int height) {
		super(array, width, height);
	}
	
	@Override
	public Span2DFloat clone() {
		return new Span2DFloat(array.clone(), width, height);
	}
	
	public Span2DFloat(int width, int height) {
		this(width, height, (float)0);
	}
	
	public Span2DFloat(int width, int height, float defaultValue) {
		this(newArray(width, height, defaultValue), width, height);
	}
	
	public static Span2DFloat wrap(float[] array, int width, int height) {
		wrapCheck(array.length, width, height);
		return new Span2DFloat(array, width, height);
	}
	
	public float get(int x, int y) {
		return get(array, width, height, x, y);
	}
	
	public void set(int x, int y, float val) {
		set(array, width, height, x, y, val);
	}
	
	public static float[] newArray(int width, int height) {
		return newArray(width, height, (float)0);
	}
	
	public static float[] newArray(int width, int height, float defaultValue) {
		float[] array = new float[width * height];
		if (defaultValue != 0) {
			Arrays.fill(array, defaultValue);
		}
		return array;
	}
	
	public static float get(float[] data, int width, int height, int x, int y) {
		return data[flat_index(width, height, x, y)];
	}
	
	public static void set(float[] data, int width, int height, int x, int y, float newValue) {
		data[flat_index(width, height, x, y)] = newValue;
	}
}
