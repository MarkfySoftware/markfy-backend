package com.app.markfy.GerenciamentoDeCompras.repository;

import com.app.markfy.GerenciamentoDeCompras.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
