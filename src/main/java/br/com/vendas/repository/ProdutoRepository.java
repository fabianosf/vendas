package br.com.vendas.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.vendas.entity.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>{

}
