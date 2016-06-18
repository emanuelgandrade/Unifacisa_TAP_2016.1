package com.emanuelgandrade.prova_tap.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emanuelgandrade.prova_tap.domain.Recurso;
import com.emanuelgandrade.prova_tap.service.IRecursoService;

@RestController
public class RecursoController {


	private final IRecursoService recursoService;

	@Autowired
	public RecursoController(IRecursoService recursoService) {
		this.recursoService = recursoService;
	}

	@RequestMapping(value="/recurso", method = RequestMethod.GET)
	public ResponseEntity< List<Recurso> > listAllRecursos() {
		return new ResponseEntity< List<Recurso> >
		(recursoService.listAllRecursos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/recurso/{id}",method = RequestMethod.GET)
	public ResponseEntity<Recurso> getUser(@PathVariable int id) {
		
		Recurso recurso = recursoService.getById(id);
		
		return recurso == null ? 
				new ResponseEntity<Recurso>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Recurso>(recurso, HttpStatus.OK);
	}
	
	@RequestMapping(value="/recurso", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody Recurso recurso) {

		try {
			recursoService.save(recurso);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}