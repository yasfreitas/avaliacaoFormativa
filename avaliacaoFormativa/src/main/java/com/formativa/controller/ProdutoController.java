package com.formativa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formativa.entities.Produto;
import com.formativa.service.ProdutoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
@Tag(name = "Produtos", description="API REST PRODUTOS")
public class ProdutoController {
	
	private final ProdutoService produtoService; 

	@Autowired 
	public ProdutoController(ProdutoService produtoService) { 
	this.produtoService = produtoService; 
	} 

	@PostMapping("/") 
	@Operation(summary = "Cadastra um produto") 
	public ResponseEntity<Produto> createProduto(@RequestBody @Valid Produto produto) { 
		Produto salvaProduto = produtoService.saveProduto(produto); 
	return ResponseEntity.status(HttpStatus.CREATED).body(salvaProduto); 
	} 

	@PutMapping("/{id}") 
	@Operation(summary = "Alterar um produto") 
	public ResponseEntity<Produto> alteraProdutoControl(@PathVariable Long id, @RequestBody @Valid Produto produto){ 
		Produto alteraProduto = produtoService.updateProduto(id, produto); 
		if (updateProduto != null) { 
			return ResponseEntity.ok(produto); 
		} 
		else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 

	@GetMapping("/{id}") 
	@Operation(summary = "Localiza produto por ID") 
		public ResponseEntity<Produto> buscaProdutoControlId (@PathVariable Long id){ 
		Produto produto = produtoService.getProdutoById(id); 
			if(produto != null) { 
				return ResponseEntity.ok(produto); 
			} 
			else { 
				return ResponseEntity.notFound().build(); 
			} 
		} 

		@GetMapping("/") 
		@Operation(summary = "Apresenta todos os produtos") 
		public ResponseEntity<List<Produto>> getAllProdutosControl(){ 
			List<Produto> ptoduto = produtoService.getAllProdutos(); 
			return ResponseEntity.ok(produto); 
		} 

	@DeleteMapping("/{id}") 
	@Operation(summary = "Apagar um produtos") 
	public ResponseEntity<Produto> apagarProsutosControl(@PathVariable Long id){ 
		boolean apagar = produtoService.apagarProduto(id); 
		if (apagar) { 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
		} 
		else { 
			return ResponseEntity.notFound().build(); 	} 

	} 
	

}
