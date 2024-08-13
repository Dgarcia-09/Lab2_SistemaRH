package com.diegogarcia.system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class ClienteException extends RuntimeException {

    public ClienteException(String mensaje) {
        super(mensaje);
    }

}
