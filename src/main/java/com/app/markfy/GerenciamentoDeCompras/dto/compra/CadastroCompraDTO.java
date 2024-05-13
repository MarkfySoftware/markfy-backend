package com.app.markfy.GerenciamentoDeCompras.dto.compra;

import com.app.markfy.GerenciamentoDeCompras.model.Item;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record CadastroCompraDTO(
        Long idLogin,
        @NotNull
        List<Long> idsItems
) {
}
