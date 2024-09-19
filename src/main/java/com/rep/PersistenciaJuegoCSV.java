package com.rep;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PersistenciaJuegoCSV {
    public static void main(String[] args) {
        var j = new Juego();
        j.setTitulo("Sonic");
        j.setAño(1991);
        j.setDesarrollador("Sonic Team");
        j.setPlataforma("Megadrive");
        j.setGenero("Plataformas");
        var j2 = new Juego();
        j2.setTitulo("Mario");
        j2.setAño(1985);
        j2.setDesarrollador("Nintendo");
        j2.setPlataforma("Switch");
        j2.setGenero("Plataformas");
        var j3 = new Juego();
        j3.setTitulo("BG3");
        j3.setAño(2023);
        j3.setDesarrollador("LarianStudio");
        j3.setPlataforma("PC");
        j3.setGenero("RPG");

        ArrayList<Juego> listaJuegos = new ArrayList<>();
        listaJuegos.add(j);
        listaJuegos.add(j2);
        listaJuegos.add(j3);



        try( var bw = new BufferedWriter( new FileWriter("juegos.csv"))){
            /*
            bw.write(j.getTitulo()+", "+
                    j.getPlataforma()+", "+
                    j.getAño()+", "+
                    j.getGenero()+", "+
                    j.getDesarrollador());
             */
            listaJuegos.forEach((Juego ju) ->{
                try{
                    bw.write(ju.toCSV());
                    bw.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            /*
            bw.write(j.toCSV());
            bw.newLine();

             */
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
