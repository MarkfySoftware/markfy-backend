package com.app.markfy.GerenciamentoDeCompras.model;

import com.app.markfy.GerenciamentoDeCompras.dto.usuario.AtualizacaoUsuarioDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.usuario.CadastroUsuarioDTO;
import com.app.markfy.GerenciamentoDeCompras.model.enums.EstadoCivilEnum;
import com.app.markfy.GerenciamentoDeCompras.model.enums.NivelEducacionalEnum;
import com.app.markfy.GerenciamentoDeCompras.model.enums.OcupacaoEnum;
import com.app.markfy.GerenciamentoDeCompras.model.enums.SexoEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;
import java.util.List;

@Table
@Entity
@Data
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataDeNasciemto;
    private String email;
    private String senha;
    private SexoEnum sexo;
    private String cpf;
    private EstadoCivilEnum estadoCivil;
    private NivelEducacionalEnum nivelEducacional;
    private Float rendaAnual;
    private OcupacaoEnum ocupacao;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Compra> compras;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Login> logins;

    public Usuario(CadastroUsuarioDTO cadastroUsuarioDTO, String senhaCriptografada) {
        this.nome = cadastroUsuarioDTO.nome();
        this.dataDeNasciemto = cadastroUsuarioDTO.dataDeNasciemto();
        this.email = cadastroUsuarioDTO.email();
        this.senha = senhaCriptografada;
        this.sexo = cadastroUsuarioDTO.sexo();
        this.cpf = cadastroUsuarioDTO.cpf();
        this.estadoCivil = cadastroUsuarioDTO.estadoCivil();
        this.nivelEducacional= cadastroUsuarioDTO.nivelEducacional();
        this.rendaAnual = cadastroUsuarioDTO.rendaAnual();
        this.ocupacao = cadastroUsuarioDTO.ocupacao();
        this.endereco = cadastroUsuarioDTO.endereco();
        this.compras = cadastroUsuarioDTO.compras();
    }

    public void atualizarUsuario(AtualizacaoUsuarioDTO atualizacaoUsuarioDTO) {
        if(atualizacaoUsuarioDTO.nome() != null) this.nome = atualizacaoUsuarioDTO.nome();
        if(atualizacaoUsuarioDTO.dataDeNasciemto() != null) this.dataDeNasciemto = atualizacaoUsuarioDTO.dataDeNasciemto();
        if(atualizacaoUsuarioDTO.email() != null) this.email = atualizacaoUsuarioDTO.email();
        if(atualizacaoUsuarioDTO.senha() != null) this.senha = atualizacaoUsuarioDTO.senha();
        if(atualizacaoUsuarioDTO.sexoEnum() != null) this.sexo = atualizacaoUsuarioDTO.sexoEnum();
        if(atualizacaoUsuarioDTO.cpf() != null) this.cpf = atualizacaoUsuarioDTO.cpf();
        if(atualizacaoUsuarioDTO.estadoCivilEnum() != null) this.estadoCivil = atualizacaoUsuarioDTO.estadoCivilEnum();
        if(atualizacaoUsuarioDTO.nivelEducacionalEnum() != null) this.nivelEducacional = atualizacaoUsuarioDTO.nivelEducacionalEnum();
        if(atualizacaoUsuarioDTO.rendaAnual() != null) this.rendaAnual = atualizacaoUsuarioDTO.rendaAnual();
        if(atualizacaoUsuarioDTO.ocupacaoEnum() != null) this.ocupacao = atualizacaoUsuarioDTO.ocupacaoEnum();
    }
}
