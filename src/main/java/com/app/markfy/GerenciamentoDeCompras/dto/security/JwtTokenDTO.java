package com.app.markfy.GerenciamentoDeCompras.dto.security;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record JwtTokenDTO (
        @NotNull
                @NotBlank
        String token
) {}