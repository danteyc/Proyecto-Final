package com.cibertec.demo.model;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.Size;

import jakarta.persistence.*;

@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idLibro;

    @Size(min = 4,max = 60 )
    public String nombre;

    @Size(min = 4,max = 60 )
    public String autor;

    public LocalDate fechaEstreno;

    @ManyToOne
    @JoinColumn(name = "idgenero")
    public Genre genero;

    // Getters and setters
}