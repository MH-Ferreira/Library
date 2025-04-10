package com.example.Biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Biblioteca.entities.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

	
}
