package br.com.vendas.Resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vendas.entity.Produto;
import br.com.vendas.service.ProdutoService;

@RestController
@RequestMapping("/api")
public class ProdutoController {
	
	private ProdutoService produtoService;
	
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@RequestMapping(value = "produto", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Produto> getAllProdutos() {
		return produtoService.findAll();
	}
	
	@RequestMapping(value = "produto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> createProduto(@RequestBody Produto produto) throws URISyntaxException {
		try {
			Produto result = produtoService.save(produto);
			return ResponseEntity.created(new URI("/api/produto/" + result.getId())).body(result);
		} catch (EntityExistsException e) {
			return new ResponseEntity<Produto>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(value = "produto", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> updateProduto(@RequestBody Produto produto) throws URISyntaxException {
		if (produto.getId() == null) {
			return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
		}

		try {
			Produto result = produtoService.update(produto);

			return ResponseEntity.created(new URI("/api/produto/" + result.getId())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/produto/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteProduto(@PathVariable Integer id) {
		produtoService.delete(id);

		return ResponseEntity.ok().build();
	}
	
	
	
	
	
	
	

}
