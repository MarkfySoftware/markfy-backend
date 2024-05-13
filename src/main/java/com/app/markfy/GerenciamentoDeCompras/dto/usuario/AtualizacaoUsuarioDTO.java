package com.app.markfy.GerenciamentoDeCompras.dto.usuario;

import com.app.markfy.GerenciamentoDeCompras.model.enums.EstadoCivilEnum;
import com.app.markfy.GerenciamentoDeCompras.model.enums.NivelEducacionalEnum;
import com.app.markfy.GerenciamentoDeCompras.model.enums.OcupacaoEnum;
import com.app.markfy.GerenciamentoDeCompras.model.enums.SexoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record AtualizacaoUsuarioDTO(
        @NotNull
                @NotBlank
        String nome,
        @NotNull
                @Past
        LocalDate dataDeNasciemto,
        @NotNull
            @NotBlank
        String email,
        @NotNull
            @NotBlank
        String senha,
        @NotNull
        SexoEnum sexoEnum,
        @NotNull
                @NotBlank
        String cpf,
        @NotNull
        EstadoCivilEnum estadoCivilEnum,
        @NotNull
        NivelEducacionalEnum nivelEducacionalEnum,
        @NotNull
        Float rendaAnual,
        @NotNull
        OcupacaoEnum ocupacaoEnum
) {
}
