package br.com.vendas.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.com.vendas.entity.Endereco;
import br.com.vendas.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	 private EnderecoRepository enderecoRepository;
	 
	 public EnderecoService(EnderecoRepository enderecoRepository) {
		 this.enderecoRepository = enderecoRepository;
	 }
	 
	 public Endereco save(Endereco endereco) {
			if (endereco.getId() != null && enderecoRepository.exists(endereco.getId())) {
				throw new EntityExistsException("There is already existing entity with such ID in the database.");
			}
			return enderecoRepository.save(endereco);	
		}
	 
	 public Endereco update(Endereco endereco) {
			if (endereco.getId() != null && !enderecoRepository.exists(endereco.getId())) {
				throw new EntityNotFoundException("There is no entity with such ID in the database.");
			}

			return enderecoRepository.save(endereco);
		}
	 
	 public List<Endereco> findAll() {
			return (List<Endereco>) enderecoRepository.findAll();
		}
	 
	 public Endereco findOne(Integer id) {
			return enderecoRepository.findOne(id);
		}
	 
	 public void delete(Integer id) {
			enderecoRepository.delete(id);
		}
	 
	 
	 
	 
	 
	 
	 
	 
	 

}
