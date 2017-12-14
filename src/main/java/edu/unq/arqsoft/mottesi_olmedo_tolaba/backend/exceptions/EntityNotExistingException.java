package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.exceptions;


public class EntityNotExistingException extends RuntimeException {

	public EntityNotExistingException(String errorMsg) {
		super(errorMsg);
	}
}
