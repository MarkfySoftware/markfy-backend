package com.app.markfy.GerenciamentoDeCompras.dto.item;

import com.app.markfy.GerenciamentoDeCompras.model.enums.TamanhoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizacaoItemDTO(
        @NotNull
                @NotBlank
        String nome,

        @NotNull
        Float valor,

        @NotNull
                @NotBlank
        String marca,
        @NotNull
        TamanhoEnum tamanhoEnum,
        @NotNull
        Integer estoque
) {
}
