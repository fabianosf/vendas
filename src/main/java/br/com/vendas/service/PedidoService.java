package br.com.vendas.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.com.vendas.entity.Pedido;
import br.com.vendas.repository.PedidoRepository;

@Service
public class PedidoService {

	private PedidoRepository pedidoRepository;

	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	public Pedido save(Pedido pedido) {
		if (pedido.getId() != null && pedidoRepository.exists(pedido.getId())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
		return pedidoRepository.save(pedido);
	}

	public Pedido update(Pedido pedido) {
		if (pedido.getId() != null && !pedidoRepository.exists(pedido.getId())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return pedidoRepository.save(pedido);
	}

	public List<Pedido> findAll() {
		return (List<Pedido>) pedidoRepository.findAll();
	}

	public Pedido findOne(Integer id) {
		return pedidoRepository.findOne(id);
	}

	public void delete(Integer id) {
		pedidoRepository.delete(id);
	}

}
