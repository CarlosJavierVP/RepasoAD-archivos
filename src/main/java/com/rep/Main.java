package com.rep;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
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

         */


        String archivo = "pom.xml";
        leerArchivo(archivo);
        leerArchivo2(archivo);
        copiarArchivoTexto("pom.xml", "pom2.xml");
        //falta url
        //scrapUrl("https://.es");
        leerScanner("pom.xml");

        //Un properties es un mapa (clave, valor)
        Properties prop = new Properties();
        prop.setProperty("nombre", "Jauja");
        prop.setProperty("apellido", "Jareje");
        prop.setProperty("correo", "nanana@gmail.com");

        System.out.println(prop);
        try {
            prop.store(new FileWriter("props.cfg"), "Info de usuario");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void leerScanner(String ruta){
        try {
            Scanner sc = new Scanner(new File(ruta));
            //delimitador de cara a saltar a la siguiente línea
            //sc.useDelimiter("=");
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
                //System.out.println(sc.next());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    /*
    private static void scrapUrl(String ruta){
        try {
            URL url = new URL(ruta);
            try (BufferedReader bfr = new BufferedReader(new InputStreamReader(url.openStream()))){
                String linea;
                while ((linea = bfr.readLine()) != null){
                    System.out.println(linea);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

     */

    private static void copiarArchivoTexto(String archivo, String archivo2){
        try(BufferedReader bfr = new BufferedReader(new FileReader(archivo));
            BufferedWriter bfw = new BufferedWriter(new FileWriter(archivo2))){
                String linea;
                Integer contador = 0;
                while ((linea = bfr.readLine()) != null ){
                    contador++;
                    bfw.write(contador +": "+linea);
                    bfw.newLine();
                }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void leerArchivo(String archivo) {
        // try con recursos, cuando lo termine de usar cierra el flujo automaticamente
        try (BufferedReader bfr = new BufferedReader(new FileReader(archivo))){
            String s;
            Integer contador =0;
            while ((s = bfr.readLine()) != null){
                System.out.println(s);
                contador++;
            }
            System.out.println("Este archivo tiene "+contador+" líneas");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //lee el archivo entero y luego se procesa
    private static void leerArchivo2(String archivo){
        try (BufferedReader bfr = new BufferedReader(new FileReader(archivo))){
         Integer lineas = bfr.lines().toList().size();
            System.out.println(lineas);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
