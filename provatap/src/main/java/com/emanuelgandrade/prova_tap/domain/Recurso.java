package com.emanuelgandrade.prova_tap.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Recurso implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	@Column
	private String nome;
	@Column
	private String descrição;
	
	public Recurso() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	
	
}
