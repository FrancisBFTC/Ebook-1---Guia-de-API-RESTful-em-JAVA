package br.com.dio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.entity.Pedido;
import br.com.dio.entity.Produto;
import br.com.dio.service.PedidoService;
import br.com.dio.service.ProdutoService;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {
	@Autowired
	private PedidoService service;
	
	//@RequestMapping(method = RequestMethod.GET, value = "/save")
	@PostMapping(value = "/save")
	public ResponseEntity<Pedido> salvaProduto(@RequestBody Pedido pedido) throws Exception {
		pedido = service.save(pedido);
		return ResponseEntity.ok().body(pedido);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> buscaProduto(@PathVariable Long id) {
		Pedido pedido = service.findById(id);
		return ResponseEntity.ok().body(pedido);
	}
	
	@GetMapping(value = "/busca-todos")
	public ResponseEntity<List<Pedido>> buscaTodosProdutos() {
		List<Pedido> pedidos = service.findAll();
		return ResponseEntity.ok().body(pedidos);
	}
}
