package com.cibertec.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cibertec.demo.model.Genre;
import com.cibertec.demo.model.Libro;
import com.cibertec.demo.service.LibroService;
import com.cibertec.demo.service.GenreService;

import java.time.LocalDate;
import java.util.Date;

@Controller
@RequestMapping("/libros")
public class LibroController {

	@Autowired
	private LibroService libroService;
	@Autowired
	private GenreService generoService;
	
	@GetMapping("")
	public String getAll(Model model ) {
		
		List<Libro> listLibros = libroService.getAll();
		
		model.addAttribute("libros", listLibros);
		
		return "libroList";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		List<Genre> listGenres = generoService.getAll();
		
		model.addAttribute("generos", listGenres);
		return "libroRegister";
	}
	
	@PostMapping("/register")
	public String create(
			@RequestParam("name") String name, 
			@RequestParam("autor") String autor,
			@RequestParam("genero") Long genero,
			@RequestParam("fechaEstreno") LocalDate fechaEstreno,
			Model model
	){
		
		Libro p = new Libro();
		p.nombre = name;
		p.autor = autor;
		p.fechaEstreno = fechaEstreno;
		p.genero = generoService.getById(genero);
		libroService.create(p);
		
		return "redirect:/libros";
	}
	
	
	@GetMapping("/edit/{id}")
	public String getByID(@PathVariable Long id, Model model) {
		Libro p = libroService.getById(id);
		
		model.addAttribute("libro", p);
		List<Genre> listGenres = generoService.getAll();
		
		model.addAttribute("generos", listGenres);
		return "libroEdit";
	}
	
	@PostMapping("/edit")
	public String edit(
			@RequestParam("id") Long id, 
			@RequestParam("name") String name, 
			@RequestParam("autor") String autor, 
			@RequestParam("genero") Long genero, 
			@RequestParam("fechaEstreno") LocalDate fechaEstreno,
			Model model
	) {
		
		Libro p = libroService.getById(id);
		p.nombre = name;
		p.autor = autor;
		p.genero = generoService.getById(genero);
		p.fechaEstreno = fechaEstreno;
		
		libroService.create(p);

		return "redirect:/libros";
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		libroService.delete(id);
		return "redirect:/libros";
	}
}
