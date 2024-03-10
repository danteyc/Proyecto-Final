package com.cibertec.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.demo.model.Libro;
import com.cibertec.demo.repository.LibroRepository;

@Service
public class LibroService {

	@Autowired
	private LibroRepository libroRepository;
	
	public List<Libro> getAll() {
		return libroRepository.findAll();
	}
	
	public Libro create(Libro libro) {
		return libroRepository.save(libro);
	}
	
	public void delete(Long id) {
		libroRepository.deleteById(id);
	}
	
	public Libro getById(Long id) {
		return libroRepository.findById(id).orElse(null);
	}
}
