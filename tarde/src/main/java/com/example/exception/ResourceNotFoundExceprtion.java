package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceprtion extends RuntimeException {
	
public static final long serialVersionUID = 1L;
	
	public ResourceNotFoundExceprtion(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}

}
