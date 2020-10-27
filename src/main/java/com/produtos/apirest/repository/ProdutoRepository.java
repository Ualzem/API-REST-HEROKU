package com.produtos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	// BUSCAR PRODUTO POR ID:
	Produto findById(long id);

}
