package com.emanuelgandrade.prova_tap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emanuelgandrade.prova_tap.domain.Recurso;

public interface RecursoRepository extends JpaRepository<Recurso, Integer> {
	public Recurso findById(int id);
}
