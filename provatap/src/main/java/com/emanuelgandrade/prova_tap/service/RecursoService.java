package com.emanuelgandrade.prova_tap.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.emanuelgandrade.prova_tap.domain.Recurso;
import com.emanuelgandrade.prova_tap.repository.RecursoRepository;

@Service
@Validated
public class RecursoService implements IRecursoService{

	private final RecursoRepository repository;
	
	@Autowired
    public RecursoService(RecursoRepository repository) {
        this.repository = repository;
    }
	
	@Override
	public List<Recurso> listAllRecursos() {
		return repository.findAll();
	}

	@Override
	public Recurso getById(int id) {
		return repository.findOne(id);
	}

	@Override
	@Transactional
	public Recurso save(@NotNull @Valid final Recurso recurso) {
		return repository.save(recurso);
	}
	
	public RecursoRepository getRepository() {
		return repository;
	}
}