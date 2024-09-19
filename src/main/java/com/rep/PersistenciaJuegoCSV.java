package com.rep;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PersistenciaJuegoCSV {
    public static void main(String[] args) {
        var j = new Juego();
        j.setTitulo("Sonic");
        j.setAño(1991);
        j.setDesarrollador("Sonic Team");
        j.setPlataforma("Megadrive");
        j.setGenero("Plataformas");

        try( var bw = new BufferedWriter( new FileWriter("juegos.csv"))){
            /*
            bw.write(j.getTitulo()+", "+
                    j.getPlataforma()+", "+
                    j.getAño()+", "+
                    j.getGenero()+", "+
                    j.getDesarrollador());
             */
            bw.write(j.toCSV());
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
