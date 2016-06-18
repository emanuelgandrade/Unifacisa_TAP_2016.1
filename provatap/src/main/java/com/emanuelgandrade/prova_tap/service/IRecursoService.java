package com.emanuelgandrade.prova_tap.service;

import java.util.List;

import com.emanuelgandrade.prova_tap.domain.Recurso;

public interface IRecursoService {

	public List<Recurso> listAllRecursos();

	public Recurso getById(int id);

	public Recurso save(Recurso recurso);
	
}
