package com.example.Biblioteca.DTO;

import com.example.Biblioteca.entities.Livro;

public class LivroDTO {

	private Long id;
	private String nome;
	
	public LivroDTO() {
	}

	public LivroDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public LivroDTO(Livro lorena) {
		id = lorena.getId();
		nome = lorena.getNome();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
	
}
