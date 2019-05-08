package br.com.vendas.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.com.vendas.entity.Cliente;
import br.com.vendas.repository.ClienteRepository;

@Service
public class ClienteService {	
	
	private ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Cliente save(Cliente cliente) {
		if (cliente.getId() != null && clienteRepository.exists(cliente.getId())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
		return clienteRepository.save(cliente);	
	}
	
	public Cliente update(Cliente cliente) {
		if (cliente.getId() != null && !clienteRepository.exists(cliente.getId())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteRepository.findAll();
	}
	
	public Cliente findOne(Integer id) {
		return clienteRepository.findOne(id);
	}
	
	public void delete(Integer id) {
		clienteRepository.delete(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
