package com.rep;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FormatoJson {
    public static void main(String[] args) {
        Juego j = new Juego();
        j.setTitulo("Sonic");
        j.setAño(1991);
        j.setDesarrollador("Sonic Team");
        j.setPlataforma("Megadrive");
        j.setGenero("Plataformas");


        ObjectMapper mapper = new ObjectMapper();

        try {
            String s1 = mapper.writeValueAsString(j);
            System.out.println(s1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
