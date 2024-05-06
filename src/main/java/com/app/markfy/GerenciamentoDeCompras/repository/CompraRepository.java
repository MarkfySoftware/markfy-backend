package com.app.markfy.GerenciamentoDeCompras.repository;

import com.app.markfy.GerenciamentoDeCompras.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
}
