package com.app.markfy.GerenciamentoDeCompras.dto.item;

import com.app.markfy.GerenciamentoDeCompras.model.enums.TamanhoEnum;

public record AtualizacaoItemDTO(
        String nome,
        Float valor,
        String marca,
        TamanhoEnum tamanhoEnum,
        Integer estoque
) {
}
