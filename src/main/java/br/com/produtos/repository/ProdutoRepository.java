package br.com.produtos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.produtos.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	Optional<Produto> findById(Long id);
	

}
