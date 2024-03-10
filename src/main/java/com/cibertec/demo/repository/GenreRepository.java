package com.cibertec.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.demo.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}