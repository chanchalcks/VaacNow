package com.vaccnow.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class VaacNowExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, String> internalServerErrorHandler(Exception e) {
		
		Map<String, String> message = new HashMap<>();
		message.put("message", e.getMessage());
		return message;
	}

}
