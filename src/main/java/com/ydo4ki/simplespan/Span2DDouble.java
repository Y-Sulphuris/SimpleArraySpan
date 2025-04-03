package com.ydo4ki.simplespan;

import java.util.Arrays;

import static com.ydo4ki.simplespan.Span2D.flat_index;

/**
 * @since 4/3/2025 8:10 PM
 * @author Sulphuris
 */
public final class Span2DDouble extends span_2D<double[]> {
	
	private Span2DDouble(double[] array, int width, int height) {
		super(array, width, height);
	}
	
	@Override
	public Span2DDouble clone() {
		return new Span2DDouble(array.clone(), width, height);
	}
	
	public Span2DDouble(int width, int height) {
		this(width, height, (double)0);
	}
	
	public Span2DDouble(int width, int height, double defaultValue) {
		this(newArray(width, height, defaultValue), width, height);
	}
	
	public static Span2DDouble wrap(double[] array, int width, int height) {
		wrapCheck(array.length, width, height);
		return new Span2DDouble(array, width, height);
	}
	
	public double get(int x, int y) {
		return get(array, width, height, x, y);
	}
	
	public void set(int x, int y, double val) {
		set(array, width, height, x, y, val);
	}
	
	public static double[] newArray(int width, int height) {
		return newArray(width, height, (double)0);
	}
	
	public static double[] newArray(int width, int height, double defaultValue) {
		double[] array = new double[width * height];
		if (defaultValue != 0) {
			Arrays.fill(array, defaultValue);
		}
		return array;
	}
	
	public static double get(double[] data, int width, int height, int x, int y) {
		return data[flat_index(width, height, x, y)];
	}
	
	public static void set(double[] data, int width, int height, int x, int y, double newValue) {
		data[flat_index(width, height, x, y)] = newValue;
	}
}
