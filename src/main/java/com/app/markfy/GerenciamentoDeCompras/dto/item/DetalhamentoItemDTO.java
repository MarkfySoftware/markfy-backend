package com.app.markfy.GerenciamentoDeCompras.dto.item;

import com.app.markfy.GerenciamentoDeCompras.model.Item;
import com.app.markfy.GerenciamentoDeCompras.model.enums.TamanhoEnum;

public record DetalhamentoItemDTO(
         Long id,
         String nome,
         Float valor,
         String marca,
         TamanhoEnum tamanhoEnum,
         Integer estoque
) {

    public DetalhamentoItemDTO(Item item) {
        this(item.getId(), item.getNome(), item.getValor(), item.getMarca(), item.getTamanho(), item.getEstoque());
    }
}
