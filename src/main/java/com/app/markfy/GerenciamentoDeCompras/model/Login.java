package com.app.markfy.GerenciamentoDeCompras.model;

import com.app.markfy.GerenciamentoDeCompras.dto.login.CadastroLoginDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Table
@Entity
@Data
@NoArgsConstructor
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String senha;
    private LocalDate dataAcesso;

    @ManyToOne
    private Usuario usuario;

    @OneToMany
    @JsonIgnore
    private List<Compra> compras;

    public Login(String email, String senha, Usuario usuario) {
        this.email = email;
        this.senha = senha;
        this.dataAcesso = LocalDate.now();
        this.usuario = usuario;
    }
}
