package com.app.markfy.GerenciamentoDeCompras.exceptions;

public class BusinessException extends Throwable {
    private String message;

    public BusinessException(String message) {
        super(message);
        this.message = message;
    }
}
