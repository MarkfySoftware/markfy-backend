package com.app.markfy.GerenciamentoDeCompras.exceptions;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class ErrorMessage{
    private String error;
}
