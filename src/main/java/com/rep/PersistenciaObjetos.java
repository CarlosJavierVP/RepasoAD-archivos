package com.rep;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PersistenciaObjetos {
    public static void main(String[] args) {

        var v = new Videojuego();
        v.setNombre("BG3");
        v.setGenero("RPG");
        v.setPrecio(59.99);

        try( var oos = new ObjectOutputStream(new FileOutputStream("Videojuego.ser"))) {
            oos.writeObject(v);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
