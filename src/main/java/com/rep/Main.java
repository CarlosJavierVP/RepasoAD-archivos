package com.rep;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        //File es un puntero que apunta a archivos o carpetas
        File f = new File(".");
        for(String s : f.list()){
            System.out.println(s);
        }

        for(File s : f.listFiles()){
            System.out.println(s.getName()+" "+s.isDirectory()+" "+s.isFile()+" "+s.length());
        }

        File f2 = new File("hola.txt");

        try {
            f2.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // try con recursos, cuando lo termine de usar cierra el flujo automaticamente
        try (BufferedReader bfr = new BufferedReader(new FileReader("pom.xml"))){
            String s;
            while ((s = bfr.readLine()) != null){
                System.out.println(s);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
