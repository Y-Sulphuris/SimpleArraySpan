package com.ydo4ki.simplespan;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @since 4/3/2025 8:01 PM
 * @author Sulphuris
 */
public final class Span2D<T> extends span_2D<T[]> {
	private Span2D(T[] array, int width, int height) {
		super(array, width, height);
	}
	
	public Span2D(Class<T> componentType, int width, int height) {
		this(componentType, width, height, null);
	}
	
	public Span2D(Class<T> componentType, int width, int height, T defaultValue) {
		this(newArray(componentType, width, height, defaultValue), width, height);
	}
	
	public static <T> Span2D<T> wrap(T[] array, int width, int height) {
		wrapCheck(array.length, width, height);
		return new Span2D<>(array, width, height);
	}
	
	public T get(int x, int y) {
		return get(array, width, height, x, y);
	}
	
	public void set(int x, int y, T val) {
		set(array, width, height, x, y, val);
	}
	
	public static <T> T[] newArray(Class<T> componentType, int width, int height) {
		return newArray(componentType, width, height, null);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[] newArray(Class<T> componentType, int width, int height, T defaultValue) {
		T[] array = (T[]) Array.newInstance(componentType, width * height);
		if (defaultValue != null) {
			Arrays.fill(array, defaultValue);
		}
		return array;
	}
	
	public static int flat_index(int width, int height, int x, int y) {
		if (x >= width || x < 0)
			throw new ArrayIndexOutOfBoundsException("x " + x + " out of width " + width);
		if (y >= height || y < 0)
			throw new ArrayIndexOutOfBoundsException("y " + y + " out of height " + height);
		
		return height * x + y;
	}
	
	public static <T> T get(T[] data, int width, int height, int x, int y) {
		return data[flat_index(width, height, x, y)];
	}
	
	public static <T> void set(T[] data, int width, int height, int x, int y, T newValue) {
		data[flat_index(width, height, x, y)] = newValue;
	}
	
	@Override
	public Span2D<T> clone() {
		return new Span2D<>(array.clone(), width, height);
	}
}
