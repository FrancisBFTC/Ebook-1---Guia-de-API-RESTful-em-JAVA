package br.com.dio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dio.entity.Pedido;
//import br.com.dio.entity.Produto;
//import br.com.dio.exception.ProductNullException;
//import br.com.dio.exception.ProductPriceException;
import br.com.dio.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	public Pedido save(Pedido pedido) throws Exception {
		return repository.save(pedido);
	}

	public Pedido findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Pedido> findAll() {
		return repository.findAll();
	}
}