package com.example.Biblioteca.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Biblioteca.DTO.LivroDTO;
import com.example.Biblioteca.Repository.LivroRepository;
import com.example.Biblioteca.entities.Livro;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class LivroService {

	  @Autowired
	    private LivroRepository livroRepository;
	    
	    private List<LivroDTO> list = new ArrayList<>();

	    public List<LivroDTO> findAll() {
	        List<Livro> livros = livroRepository.findAll();
	        return livros.stream().map(LivroDTO::new).collect(Collectors.toList());
	    }

	    public Object getLivroInfo(int bookId) {
	        // Procura no cache
	        for (LivroDTO livro : list) {
	            if (livro.getId() == bookId) {
	                System.out.println("Cache hit - ID: " + bookId);
	                return livro;
	            }
	        }
	        
	        // Se não encontrou no cache, busca no banco
	        System.out.println("Cache miss - ID: " + bookId);
	        Optional<Livro> livroOptional = livroRepository.findById((long) bookId);
	        
	        if (livroOptional.isPresent()) {
	            LivroDTO livroDTO = new LivroDTO(livroOptional.get());
	            list.add(livroDTO);
	            System.out.println("Livro encontrado no banco e adicionado ao cache");
	            return livroDTO;
	        } else {
	            System.out.println("Livro não encontrado no banco");
	            return "Livro com ID " + bookId + " não encontrado";
	        }
	    }

	    public void updateLivroInfo(LivroDTO livroDTO) {
	        // Atualiza no banco de dados
	        Livro livro = livroRepository.findById(livroDTO.getId())
	            .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
	        livro.setNome(livroDTO.getNome());
	        livroRepository.save(livro);

	        // Atualiza no cache
	        for (int i = 0; i < list.size(); i++) {
	            if (list.get(i).getId() == livroDTO.getId()) {
	                list.set(i, livroDTO);
	                System.out.println("Cache atualizado - ID: " + livroDTO.getId());
	                break;
	            }
	        }
	    }

	    // Método para mostrar o conteúdo do cache
	    public void mostrarCache() {
	        System.out.println("\n=== CONTEÚDO DO CACHE ===");
	        if (list.isEmpty()) {
	            System.out.println("Cache vazio!");
	        } else {
	            for (LivroDTO livro : list) {
	                System.out.println("ID: " + livro.getId() + " | Nome: " + livro.getNome());
	            }
	        }
	        System.out.println("========================\n");
	    }
}
