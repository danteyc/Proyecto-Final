package com.cibertec.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "genero")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idGenre;

    public String nombre;

    // Getters and setters
}