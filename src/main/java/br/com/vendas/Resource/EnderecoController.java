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

import br.com.vendas.entity.Endereco;
import br.com.vendas.service.EnderecoService;

@RestController
@RequestMapping("/api")
public class EnderecoController {

	private EnderecoService enderecoService;

	public EnderecoController(EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}

	@RequestMapping(value = "endereco", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Endereco> getAllEnderecos() {
		return enderecoService.findAll();
	}

	@RequestMapping(value = "endereco", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Endereco> createEndereco(@RequestBody Endereco endereco) throws URISyntaxException {
		try {
			Endereco result = enderecoService.save(endereco);
			return ResponseEntity.created(new URI("/api/endereco/" + result.getId())).body(result);
		} catch (EntityExistsException e) {
			return new ResponseEntity<Endereco>(HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "Endereco", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Endereco> updateEndereco(@RequestBody Endereco endereco) throws URISyntaxException {
		if (endereco.getId() == null) {
			return new ResponseEntity<Endereco>(HttpStatus.NOT_FOUND);
		}

		try {
			Endereco result = enderecoService.update(endereco);

			return ResponseEntity.created(new URI("/api/endereco/" + result.getId())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<Endereco>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/endereco/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteEndereco(@PathVariable Integer id) {
		enderecoService.delete(id);

		return ResponseEntity.ok().build();
	}

}
