package com.app.markfy.GerenciamentoDeCompras.dto.usuario;

import com.app.markfy.GerenciamentoDeCompras.model.enums.EstadoCivilEnum;
import com.app.markfy.GerenciamentoDeCompras.model.enums.NivelEducacionalEnum;
import com.app.markfy.GerenciamentoDeCompras.model.enums.OcupacaoEnum;
import com.app.markfy.GerenciamentoDeCompras.model.enums.SexoEnum;

import java.time.LocalDate;

public record AtualizacaoUsuarioDTO(
        String nome,
        LocalDate dataDeNasciemto,
        String email,
        String senha,
        SexoEnum sexoEnum,
        String cpf,
        EstadoCivilEnum estadoCivilEnum,
        NivelEducacionalEnum nivelEducacionalEnum,
        Float rendaAnual,
        OcupacaoEnum ocupacaoEnum
) {
}
