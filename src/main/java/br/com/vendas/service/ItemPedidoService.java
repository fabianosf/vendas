package br.com.vendas.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.com.vendas.entity.ItemPedido;
import br.com.vendas.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {

	private ItemPedidoRepository itemPedidoRepository;

	public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
		this.itemPedidoRepository = itemPedidoRepository;
	}

	public ItemPedido save(ItemPedido itemPedido) {
		if (itemPedido.getId() != null && itemPedidoRepository.exists(itemPedido.getId())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
		return itemPedidoRepository.save(itemPedido);
	}

	public ItemPedido update(ItemPedido itemPedido) {
		if (itemPedido.getId() != null && !itemPedidoRepository.exists(itemPedido.getId())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return itemPedidoRepository.save(itemPedido);
	}

	public List<ItemPedido> findAll() {
		return (List<ItemPedido>) itemPedidoRepository.findAll();
	}

	public ItemPedido findOne(Integer id) {
		return itemPedidoRepository.findOne(id);
	}

	public void delete(Integer id) {
		itemPedidoRepository.delete(id);
	}

}
