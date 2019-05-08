package br.com.vendas.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.com.vendas.entity.Produto;
import br.com.vendas.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	private ProdutoRepository produtoRepository;
	
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public Produto save(Produto produto) {
		if (produto.getId() != null && produtoRepository.exists(produto.getId())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
		return produtoRepository.save(produto);	
	}
	
	public Produto update(Produto produto) {
		if (produto.getId() != null && !produtoRepository.exists(produto.getId())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return produtoRepository.save(produto);
	}
	
	public List<Produto> findAll() {
		return (List<Produto>) produtoRepository.findAll();
	}
	
	public Produto findOne(Integer id) {
		return produtoRepository.findOne(id);
	}
	
	public void delete(Integer id) {
		produtoRepository.delete(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
