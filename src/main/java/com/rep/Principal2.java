package com.rep;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Principal2 {
    public static void main(String[] args) {
        Properties props = new Properties();
        try {
            props.load(new FileReader("props.cfg"));
            System.out.println(props);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
