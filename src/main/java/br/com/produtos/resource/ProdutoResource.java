package br.com.produtos.resource;

import java.util.List;
import java.util.Optional;

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

import br.com.produtos.models.Produto;
import br.com.produtos.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API Rest Produtos")
@CrossOrigin(origins = "*")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produto")
	@ApiOperation(value = "retorna todos os produtos")
	public List<Produto> listar(){
		return produtoRepository.findAll();
	}

	@GetMapping("/produto/{id}")
	@ApiOperation(value = "retorna umm unico produto")
	public Optional<Produto> listaUnico(@PathVariable (value = "id") long id){
		return produtoRepository.findById(id);
	}
	
	@PostMapping("produto")
	@ApiOperation(value = "salva produto")
	public Produto salva(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@PutMapping("produto")
	@ApiOperation(value = "atualiza produto")
	public Produto atualiza(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("produto")
	@ApiOperation(value = "deleta produto")
	public void deleta(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}
}