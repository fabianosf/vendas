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

import br.com.vendas.entity.ItemPedido;
import br.com.vendas.service.ItemPedidoService;

@RestController
@RequestMapping("/api")
public class ItemPedidoController {

	private ItemPedidoService itemPedidoService;

	public ItemPedidoController(ItemPedidoService itemPedidoService) {
		this.itemPedidoService = itemPedidoService;
	}

	@RequestMapping(value = "itemPedido", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ItemPedido> getAllItemPedidos() {
		return itemPedidoService.findAll();
	}

	@RequestMapping(value = "itemPedido", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemPedido> createItemPedido(@RequestBody ItemPedido itemPedido) throws URISyntaxException {
		try {
			ItemPedido result = itemPedidoService.save(itemPedido);
			return ResponseEntity.created(new URI("/api/itemPedido/" + result.getId())).body(result);
		} catch (EntityExistsException e) {
			return new ResponseEntity<ItemPedido>(HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "ItemPedido", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemPedido> updateItemPedido(@RequestBody ItemPedido itemPedido) throws URISyntaxException {
		if (itemPedido.getId() == null) {
			return new ResponseEntity<ItemPedido>(HttpStatus.NOT_FOUND);
		}

		try {
			ItemPedido result = itemPedidoService.update(itemPedido);

			return ResponseEntity.created(new URI("/api/itemPedido/" + result.getId())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<ItemPedido>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/itemPedido/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteItemPedido(@PathVariable Integer id) {
		itemPedidoService.delete(id);

		return ResponseEntity.ok().build();
	}

}
