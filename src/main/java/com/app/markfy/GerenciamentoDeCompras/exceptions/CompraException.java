package com.app.markfy.GerenciamentoDeCompras.exceptions;

import lombok.Getter;

@Getter
public class CompraException extends Throwable {
    private String message;

    public CompraException(String message) {
        super(message);
        this.message = message;
    }
}
