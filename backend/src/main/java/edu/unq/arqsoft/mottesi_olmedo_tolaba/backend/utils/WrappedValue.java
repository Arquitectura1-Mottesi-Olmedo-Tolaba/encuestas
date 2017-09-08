package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.utils;

public class WrappedValue<T> {

	private T value;

	public WrappedValue() { }

	public WrappedValue(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
}
