package br.com.vendas.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.vendas.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

}
