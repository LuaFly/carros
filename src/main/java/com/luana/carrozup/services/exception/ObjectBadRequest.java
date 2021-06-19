package com.luana.carrozup.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ObjectBadRequest extends RuntimeException{

	public ObjectBadRequest(String msg) {
		super(msg);
	}
}
