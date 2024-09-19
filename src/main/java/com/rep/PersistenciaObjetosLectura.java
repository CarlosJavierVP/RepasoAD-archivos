package com.rep;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class PersistenciaObjetosLectura {
    public static void main(String[] args) {

        try (var ois = new ObjectInputStream(new FileInputStream("Videojuego.ser"))){
            Videojuego v = (Videojuego) ois.readObject();
            System.out.println(v);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
