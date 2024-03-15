// RESOURCE LAYER( CONTROLADOR REST (APLICAÇÃO <--> RESOURCE (AQUI)-->SERVICE))

package com.joseleandro.demo.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseleandro.demo.entities.Category;
import com.joseleandro.demo.services.CategoryService;

// @RestController: Esta anotação é usada para marcar esta classe como um controlador REST.
@RestController
// @RequestMapping: Esta anotação é usada para mapear uma solicitação HTTP para métodos específicos neste controlador.
@RequestMapping(value = "/category")
public class CategoryResource {
	
	@Autowired
	private CategoryService service; // Injeção de dependência do CategoryService
	
	// @GetMapping: Esta anotação é usada para mapear solicitações HTTP GET para este método.
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll(); // Chama o método findAll() do CategoryService para buscar todos os usuários
		return ResponseEntity.ok().body(list); // Retorna a lista de usuários com o status HTTP 200 OK
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}

