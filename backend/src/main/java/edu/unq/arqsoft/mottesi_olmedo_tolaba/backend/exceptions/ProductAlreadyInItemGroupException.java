package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.exceptions;

import org.eclipse.core.internal.runtime.Product;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Brand;

public class ProductAlreadyInItemGroupException extends RuntimeException {

	private static final long serialVersionUID = -4588678425008904558L;
	private Brand brand;
	
	public ProductAlreadyInItemGroupException(Brand brand, String errorMsg) {
		super(errorMsg);
		this.setBrand(brand);
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	
}
