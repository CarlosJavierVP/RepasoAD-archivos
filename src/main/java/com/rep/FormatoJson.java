package com.rep;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FormatoJson {
    public static void main(String[] args) {
        //arraylist en json
        var juegos = new ArrayList<Juego>(0);
        Juego j = new Juego();
        j.setTitulo("Sonic");
        j.setAño(1991);
        j.setDesarrollador("Sonic Team");
        j.setPlataforma("Megadrive");
        j.setGenero("Plataformas");
        juegos.add(j);
        juegos.add(j);


        ObjectMapper mapper = new ObjectMapper();

        try {
            //ordenar el json
            String s2 = mapper.writer(new DefaultPrettyPrinter()).writeValueAsString(juegos);
            mapper.writer(new DefaultPrettyPrinter()).writeValue(new File("juegos.json"),juegos);
            System.out.println(s2);
            /*
            String s1 = mapper.writeValueAsString(j);
            System.out.println(s1);
            //Escribir en formato json (en un archivo) el arraylist
            mapper.writeValue(new File("sonic.json"),juegos);
            */
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Juego j2 = mapper.readValue( new File("juego.json"),Juego.class);
            System.out.print(j2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
