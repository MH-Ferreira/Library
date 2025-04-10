package com.example.Biblioteca.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Biblioteca.DTO.LivroDTO;
import com.example.Biblioteca.Service.LivroService;
@RestController
@RequestMapping("/livros")
public class Livrocontroller {
	    @Autowired
	    private LivroService livroService;

	    // Criar um metodo Get para buscar todos os livros
	    @GetMapping
	    public ResponseEntity<?> findAll() {
	        try {
	            List<LivroDTO> livros = livroService.findAll();
	            return ResponseEntity.ok(livros);
	        } catch (Exception e) {
	            return ResponseEntity.internalServerError().body("Erro ao buscar livros: " + e.getMessage());
	        }
	    }

	    // Criar um metodo Get para buscar um livro
	    @GetMapping("/{id}")
	    public ResponseEntity<?> getLivroInfo(@PathVariable int id) {
	        try {
	            Object resultado = livroService.getLivroInfo(id);
	            if (resultado instanceof LivroDTO) {
	                return ResponseEntity.ok(resultado);
	            } else {
	                return ResponseEntity.status(404).body(resultado);
	            }
	        } catch (Exception e) {
	            return ResponseEntity.internalServerError().body("Erro ao buscar livro: " + e.getMessage());
	        }
	    }
	    

	    // Criar um metodo Put para atualizar um livro
	    @PutMapping("/{id}")
	    public ResponseEntity<?> updateLivro(@PathVariable int id, @RequestBody LivroDTO livroDTO) {
	        try {
	            livroDTO.setId((long) id);
	            livroService.updateLivroInfo(livroDTO);
	            return ResponseEntity.ok("Livro atualizado com sucesso");
	        } catch (Exception e) {
	            return ResponseEntity.internalServerError().body("Erro ao atualizar livro: " + e.getMessage());
	        }
	    }

	    // Criar um metodo Get para mostrar o cache
	    @GetMapping("/cache")
	    public ResponseEntity<?> mostrarCache() {
	        try {
	            livroService.mostrarCache();
	            return ResponseEntity.ok("Cache exibido no console");
	        } catch (Exception e) {
	            return ResponseEntity.internalServerError().body("Erro ao mostrar cache: " + e.getMessage());
	        }
	    }
}
