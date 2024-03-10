package com.cibertec.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.demo.model.Libro;


public interface LibroRepository extends JpaRepository<Libro, Long> {

}