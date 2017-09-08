package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.provider;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Brand;

public class BrandFactory {

	public static Brand exampleNewElem(){
		String name = "Bagley";
		return newElem(name);
	}
	
	public static Brand newElem(String name){
		Brand newBrand = new Brand();
		newBrand.setName(name);
		return newBrand;
	}
	
}
