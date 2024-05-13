package com.app.markfy.GerenciamentoDeCompras.dto.usuario;
import com.app.markfy.GerenciamentoDeCompras.model.Compra;
import com.app.markfy.GerenciamentoDeCompras.model.Endereco;
import com.app.markfy.GerenciamentoDeCompras.model.enums.EstadoCivilEnum;
import com.app.markfy.GerenciamentoDeCompras.model.enums.NivelEducacionalEnum;
import com.app.markfy.GerenciamentoDeCompras.model.enums.OcupacaoEnum;
import com.app.markfy.GerenciamentoDeCompras.model.enums.SexoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;
import java.util.List;

public record CadastroUsuarioDTO(
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
        SexoEnum sexo,
        @NotNull
            @NotBlank
        String cpf,
        @NotNull
        EstadoCivilEnum estadoCivil,
        @NotNull
        NivelEducacionalEnum nivelEducacional,
        @NotNull
        Float rendaAnual,
        @NotNull
        OcupacaoEnum ocupacao,
        @NotNull
        Endereco endereco,
        @NotNull
        List<Compra> compras
) {
}
