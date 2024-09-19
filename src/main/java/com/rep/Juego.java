package com.rep;

import lombok.Data;

import java.io.Serializable;

@Data
public class Juego implements Serializable {
    private String titulo;
    private String plataforma;
    private Integer año;
    private String genero;
    private String desarrollador;

    public String toCSV(){
        return titulo+", "+
                plataforma+", "+
                año+", "+
               genero+", "+
               desarrollador;
    }
}
