package br.com.vendas.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.vendas.entity.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Integer>{

}
