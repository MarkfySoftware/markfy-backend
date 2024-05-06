package com.app.markfy.GerenciamentoDeCompras.exceptions;

import lombok.Getter;

@Getter
public class NotFoundResourceException extends Throwable {
    private String message;
    public NotFoundResourceException(String message) {
        super(message);
        this.message = message;
    }
}
