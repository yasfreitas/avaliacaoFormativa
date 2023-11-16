package com.formativa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formativa.entities.Produto;
import com.formativa.repository.ProdutoRepository;

@Service
public class ProdutoService {
	private final ProdutoRepository produtoRepository;
	
	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public List<Produto> getAllProdutos(){
		return produtoRepository.findAll();
	}
	
	public Produto getProdutoById(Long id) {
		Optional <Produto> produto = produtoRepository.findById(id);
		return produto.orElse(null);
	}
	
	public Produto saveProduto (Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public Produto updateProduto(Long id, Produto updateProduto) {
		Optional <Produto> produto = produtoRepository.findById(id);
		if (produto.isPresent()) {
			updateProduto.setId(id);
			return produtoRepository.save(updateProduto);
		}
		return null;
	}
	public boolean apagarProduto(Long id) {
		Optional <Produto> produto = produtoRepository.findById(id);
		if (produto.isPresent()) {
			produtoRepository.deleteById(id);
			return true;
		}
		return false;
	}


}
