package com.ydo4ki.simplespan;

/**
 * Internal class. Don't look at it.
 * @since 4/3/2025 8:19 PM
 * @author Sulphuris
 */
abstract class span_2D<A> implements Cloneable {
	protected final A array;
	public final int width, height;
	
	span_2D(A array, int width, int height) {
		this.array = array;
		this.width = width;
		this.height = height;
	}
	
	public A array() {
		return array;
	}
	
	static void wrapCheck(int length, int width, int height) throws ArrayIndexOutOfBoundsException {
		if (width * height != length)
			throw new ArrayIndexOutOfBoundsException("Unexpected array length " + length + " for span " + width + ":" + height);
	}
	
	@Override
	public abstract span_2D<A> clone();
}
