package com.rep;

import lombok.Data;

import java.io.Serializable;

@Data
public class Videojuego implements Serializable {

    private String nombre;
    private String genero;
    private Double precio;



}
