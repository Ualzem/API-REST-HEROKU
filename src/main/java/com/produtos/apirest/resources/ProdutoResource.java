package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	
	//  PARA ACESSAR A API PELO SWAGGER:  http://localhost:8080/swagger-ui.html
	
	
	       //  VAI LISTAR TODOS OS PRODUTOS:
	@GetMapping("/produtos")
	@ApiOperation(value="Retorna 1 lista de todos os produtos")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
		
	}
	
	
	
	      // VAI BUSCAR 1 PRODUTO POR ID:
	@GetMapping("/produto/{id}")
	@ApiOperation(value="Retorna 1 produto com o parâmetro id na busca")
	public Produto listaProdutoUnico(@PathVariable(value="id") long id) {
		return produtoRepository.findById(id);
	}
	
	
	      //  VAI SALVAR 1 NOVO PRODUTO NO BANCO
	@PostMapping("/produto")
	@ApiOperation(value="Cria e salva 1 produto na API")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
		
		
//		NO POSTMAN ADICIONAMOS 1 NOVO PRODUTO ASSIM:
//		{
//		    "nome": "Iphone 10",
//		    "quantidade": 5.00,
//		    "valor": 6513.00
//		    
//		}
		
			
		    // VAI DELETAR 1 PRODUTO NO BANCO:
	@DeleteMapping("/produto")
	@ApiOperation(value="Deleta 1 produto na API")
	public void deletaProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	
}
//	NO POSTMAN DELETAMOS 1 PRODUTO ASSIM:
//	{
//      "id": 4,
//	    "nome": "Iphone 10",
//	    "quantidade": 5.00,
//	    "valor": 6513.00
//	    
//	}
	
	            // VAI  ALTERAR E ATUALIZAR 1 PRODUTO NO BANCO:
	@PutMapping("/produto")
	@ApiOperation(value="Altera e atualiza 1 produto na API")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	

}
