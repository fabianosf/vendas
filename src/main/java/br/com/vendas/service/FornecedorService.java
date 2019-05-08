package br.com.vendas.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.com.vendas.entity.Fornecedor;
import br.com.vendas.repository.FornecedorRepository;

@Service
public class FornecedorService {
	
	private FornecedorRepository fornecedorRepository;
	
	public FornecedorService(FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
	}
	
	public Fornecedor save(Fornecedor fornecedor) {
		if (fornecedor.getId() != null && fornecedorRepository.exists(fornecedor.getId())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
		return fornecedorRepository.save(fornecedor);	
	}
	
	public Fornecedor update(Fornecedor fornecedor) {
		if (fornecedor.getId() != null && !fornecedorRepository.exists(fornecedor.getId())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return fornecedorRepository.save(fornecedor);
	}
	
	public List<Fornecedor> findAll() {
		return (List<Fornecedor>) fornecedorRepository.findAll();
	}
	
	public Fornecedor findOne(Integer id) {
		return fornecedorRepository.findOne(id);
	}
	
	public void delete(Integer id) {
		fornecedorRepository.delete(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
