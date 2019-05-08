package br.com.vendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.vendas.repository.ClienteRepository;
import br.com.vendas.repository.EnderecoRepository;
import br.com.vendas.repository.FornecedorRepository;
import br.com.vendas.repository.ItemPedidoRepository;
import br.com.vendas.repository.PedidoRepository;
import br.com.vendas.repository.ProdutoRepository;

@SpringBootApplication
public class SistemaVendasApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SistemaVendasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*

		// manytoone
		Pedido p1 = new Pedido("Rua das Flores", true, 20.50);
		List<Pedido> pedidos = new ArrayList<Pedido>();
		pedidos.add(p1);

		// onetomany
		Cliente c1 = new Cliente("Maria Gloria", "123", "mariag", "123.123.123-00", new Date());
		c1.setPedidos(pedidos);
		p1.setCliente(c1);
		// save
		clienteRepository.save(c1);
		// save
		pedidoRepository.save(p1);

		Cliente c2 = new Cliente("Marta Maria", "456", "martam", "123.123.123-00", new Date());
		Endereco e1 = new Endereco("Rua das Flores", 55, "Jardim", "RJ");

		c2.setEndereco(e1);
		e1.setCliente(c2);

		clienteRepository.save(c2);
		enderecoRepository.save(e1);

		// manytoone
		ItemPedido ip1 = new ItemPedido(10, 10.50);
		List<ItemPedido> itemPedidos = new ArrayList<ItemPedido>();
		itemPedidos.add(ip1);

		// onetomany
		Pedido p2 = new Pedido("Rua das Matas", true, 10.50);
		p2.setItemPedidos(itemPedidos);
		ip1.setPedido(p2);

		pedidoRepository.save(p2);
		itemPedidoRepository.save(ip1);

		Fornecedor f1 = new Fornecedor("Pedro Rocha", "000.000.000.000.000");
		fornecedorRepository.save(f1);

		// Relaciomento OneToMany
		// * Produto x ItemPedido
		// *
		// *
		// *
		// Primeiro ManyToOne
		ItemPedido ip2 = new ItemPedido(10, 20.50);
		List<ItemPedido> itemPedidos1 = new ArrayList<ItemPedido>();
		itemPedidos1.add(ip2);

		// OneToMany
		Produto p11 = new Produto("Batata", 5.50, 10, 10, 50);
		p11.setItemPedidos(itemPedidos1);
		ip2.setProduto(p11);

		produtoRepository.save(p11);
		itemPedidoRepository.save(ip2);

		// OneToMany
		// Fornecedor x Produto

		// ManyToOne
		Produto p3 = new Produto("Arroz", 7.50, 5, 10, 50);
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(p3);

		Fornecedor f2 = new Fornecedor("Maria Flores", "111.111.111.111");
		f2.setProdutos(produtos);
		p3.setFornecedor(f2);

		fornecedorRepository.save(f2);
		produtoRepository.save(p3);
		
		*/

	}

}
