package com.app.markfy.GerenciamentoDeCompras.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizacaoEnderecoDTO(
        @NotNull
                @NotBlank
        String cep,
        @NotNull
        String rua,

        @NotNull
        Integer numero,

        String complemento
) {
}
