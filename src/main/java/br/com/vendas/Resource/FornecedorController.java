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

import br.com.vendas.entity.Fornecedor;
import br.com.vendas.service.FornecedorService;

@RestController
@RequestMapping("/api")
public class FornecedorController {

	private FornecedorService fornecedorService;

	public FornecedorController(FornecedorService fornecedorService) {
		this.fornecedorService = fornecedorService;
	}

	@RequestMapping(value = "fornecedor", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Fornecedor> getAllFornecedores() {
		return fornecedorService.findAll();
	}

	@RequestMapping(value = "fornecedor", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Fornecedor> createFornecedor(@RequestBody Fornecedor fornecedor) throws URISyntaxException {
		try {
			Fornecedor result = fornecedorService.save(fornecedor);
			return ResponseEntity.created(new URI("/api/fornecedor/" + result.getId())).body(result);
		} catch (EntityExistsException e) {
			return new ResponseEntity<Fornecedor>(HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "Fornecedor", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Fornecedor> updateFornecedor(@RequestBody Fornecedor fornecedor) throws URISyntaxException {
		if (fornecedor.getId() == null) {
			return new ResponseEntity<Fornecedor>(HttpStatus.NOT_FOUND);
		}

		try {
			Fornecedor result = fornecedorService.update(fornecedor);

			return ResponseEntity.created(new URI("/api/fornecedor/" + result.getId())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<Fornecedor>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/fornecedor/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteFornecedor(@PathVariable Integer id) {
		fornecedorService.delete(id);

		return ResponseEntity.ok().build();
	}

}
