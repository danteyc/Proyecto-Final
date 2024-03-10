package com.cibertec.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.demo.model.Genre;
import com.cibertec.demo.repository.GenreRepository;

@Service
public class GenreService {

	@Autowired
	private GenreRepository generoRepository;
	
	public List<Genre> getAll() {
		return generoRepository.findAll();
	}
	
	public Genre create(Genre peli) {
		return generoRepository.save(peli);
	}
	
	public void delete(Long id) {
		generoRepository.deleteById(id);
	}
	
	public Genre getById(Long id) {
		return generoRepository.findById(id).orElse(null);
	}
}
