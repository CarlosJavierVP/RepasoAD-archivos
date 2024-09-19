package com.rep;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeerCSV {
    public static void main(String[] args) {
        var listado = new ArrayList<Juego>();

        try(BufferedReader br = new BufferedReader(new FileReader("juegos.csv"))){
            String linea;
            while ((linea = br.readLine()) != null){
                String[] datos = linea.split(",");
                var jue = new Juego();
                jue.setTitulo(datos[0]);
                jue.setPlataforma(datos[1]);
                jue.setAño(Integer.parseInt(datos[2]));
                jue.setGenero(datos[3]);
                jue.setDesarrollador(datos[4]);
                listado.add(jue);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(listado);

    }
}
