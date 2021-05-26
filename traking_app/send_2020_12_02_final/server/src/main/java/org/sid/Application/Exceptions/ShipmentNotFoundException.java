package org.sid.Application.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ShipmentNotFoundException extends RuntimeException{
   
	public ShipmentNotFoundException(String message) {
        super(message);
    }
}
