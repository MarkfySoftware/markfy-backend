package com.app.markfy.GerenciamentoDeCompras.exceptions;

import lombok.Getter;

@Getter
public class LoginException extends Throwable {
    private String message;
    public LoginException(String message) {
        super(message);
        this.message = message;
    }
}